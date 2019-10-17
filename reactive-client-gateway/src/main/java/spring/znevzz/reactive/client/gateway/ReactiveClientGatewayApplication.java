package spring.znevzz.reactive.client.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;


@SpringBootApplication
public class ReactiveClientGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReactiveClientGatewayApplication.class, args);
	}
}

@Slf4j
@RestController
class ReactiveClientGatewayController {

	@Value("${reactive.file.gateway.url:http://localhost:8095}")
	private String fileGatewayUrl;

	@GetMapping(value = "/funds", produces = "application/stream+json")
	public Flux<String> getFunds() {
		Flux<String> stringFlux = WebClient.create(fileGatewayUrl+"/funds").get()
				.retrieve()
				.bodyToFlux(String.class)
				.log()
				;

		stringFlux.subscribe(log::info);

		return stringFlux
				.delayElements(Duration.ofSeconds(2))
				.log()
			;
	}

}
