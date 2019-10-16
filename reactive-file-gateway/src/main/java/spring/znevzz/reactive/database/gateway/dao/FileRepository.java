package spring.znevzz.reactive.database.gateway.dao;

import reactor.core.publisher.Flux;
import spring.znevzz.reactive.database.gateway.model.FileResource;

public interface FileRepository<T> {

    Flux<T> readComplete(FileResource fileResource);
}
