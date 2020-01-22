package spring.znevzz.reactive.client.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import spring.znevzz.reactive.client.gateway.dao.LocalFileRepository;
import spring.znevzz.reactive.client.gateway.model.FileResource;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


@SpringBootApplication
public class ReactiveFileGatewayApplication {

	public static void main(String[] args) {
		Hooks.onOperatorDebug();
		SpringApplication.run(ReactiveFileGatewayApplication.class, args);
	}

}

@Slf4j
@RestController
class ReactiveFileGatewayController {

	private final LocalFileRepository repository;
	private final List<FileResource> resources;

	@Autowired
	ReactiveFileGatewayController(LocalFileRepository repository,
								  List<FileResource> resources) {
		this.repository = repository;
		this.resources = resources;
	}

	@GetMapping(value = "/funds", produces = "application/stream+json")
	public Flux<String> getFunds() throws IOException {
		Flux<String> stringFlux = repository
				.readComplete(
						resources.stream()
								.filter(fileResource -> "funds".equals(fileResource.getName()))
								.findFirst()
								.orElseThrow( () -> new RuntimeException("No FileResource Found for /funds"))
				)
				.doOnError( error -> log.error(error.getMessage()));
		stringFlux.subscribe(this::info);
		return stringFlux
				.limitRequest(2)
//				.delayElements(Duration.ofSeconds(5))
				.log()
			;
	}

	private void info(String s) {
		log.info("value="+ s);
	}


}
