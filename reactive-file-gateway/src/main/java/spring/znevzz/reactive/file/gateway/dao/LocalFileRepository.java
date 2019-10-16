package spring.znevzz.reactive.file.gateway.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import spring.znevzz.reactive.file.gateway.model.FileResource;


@Component
public class LocalFileRepository implements FileRepository<String> {

    @Value("${sample.json.data}")
    private String data;

    @Override
    public Flux<String> readComplete(FileResource fileResource) {
        return Flux
                .just(data);
    }
}
