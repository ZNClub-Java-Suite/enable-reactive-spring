package spring.znevzz.reactive.file.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.znevzz.reactive.file.gateway.dao.LocalFileRepository;

import java.time.Duration;


@SpringBootApplication
public class ReactiveFileGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveFileGatewayApplication.class, args);
	}

}

@Slf4j
@RestController
class ReactiveFileGatewayController {

	private final LocalFileRepository repository;

	ReactiveFileGatewayController(LocalFileRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/funds", produces = "application/stream+json")
	public Flux<String> getFunds() {
		Flux<String> stringFlux = repository.readComplete(null);

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
