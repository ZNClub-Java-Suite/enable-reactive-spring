package spring.znevzz.reactive.database.gateway.dao;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import spring.znevzz.reactive.database.gateway.model.FileResource;


@Component
public class LocalFileRepository implements FileRepository<String> {
    @Override
    public Flux<String> readComplete(FileResource fileResource) {
        return Flux
                .just("ONE");
    }
}
