package spring.znevzz.reactive.client.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import spring.znevzz.reactive.client.gateway.dao.LocalFileRepository;
import spring.znevzz.reactive.client.gateway.model.FileResource;

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

	ReactiveFileGatewayController(LocalFileRepository repository,
								  List<FileResource> resources) {
		this.repository = repository;
		this.resources = resources;
	}

	@GetMapping(value = "/funds", produces = "application/stream+json")
	public Flux<String> getFunds() {
		Flux<String> stringFlux = repository
				.readComplete(resources.stream().findAny().orElse(null))
				.doOnError( error -> log.error(error.getMessage()))
				;
		stringFlux.subscribe(this::info);
		addFund();

		return stringFlux
//				.delayElements(Duration.ofSeconds(5))
//				.log()
			;
	}

	private void info(String s) {
		log.info("value="+ s);
	}

	@GetMapping(value = "/add")
	public Mono<Void> addFund() {
		repository.setArray(null);
		return Mono.empty();
	}


}