package spring.znevzz.reactive.client.gateway.dao;

import reactor.core.publisher.Flux;
import spring.znevzz.reactive.client.gateway.model.FileResource;

import java.io.IOException;

public interface FileRepository<T> {

    Flux<T> readComplete(FileResource fileResource) throws IOException;
}
