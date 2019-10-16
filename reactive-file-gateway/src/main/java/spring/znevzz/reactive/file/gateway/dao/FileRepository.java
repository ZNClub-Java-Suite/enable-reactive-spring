package spring.znevzz.reactive.file.gateway.dao;

import reactor.core.publisher.Flux;
import spring.znevzz.reactive.file.gateway.model.FileResource;

public interface FileRepository<T> {

    Flux<T> readComplete(FileResource fileResource);
}
