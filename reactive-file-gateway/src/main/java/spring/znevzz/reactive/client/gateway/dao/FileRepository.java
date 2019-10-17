package spring.znevzz.reactive.client.gateway.dao;

import reactor.core.publisher.Flux;
import spring.znevzz.reactive.client.gateway.model.FileResource;

public interface FileRepository<T> {

    Flux<T> readComplete(FileResource fileResource);
}
