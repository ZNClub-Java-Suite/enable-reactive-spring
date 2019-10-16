package spring.znevzz.reactive.file.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import spring.znevzz.reactive.file.gateway.dao.FileRepository;

@SpringBootApplication
public class ReactiveFileGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveFileGatewayApplication.class, args);
	}

}


@RestController
class ReactiveFileGatewayController {

	private final FileRepository repository;

	ReactiveFileGatewayController(FileRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/funds", produces = "application/stream+json")
	public Flux<String> getFunds() {
		return repository.readComplete(null)
				.log();
	}

}
