package spring.znevzz.reactive.client.gateway.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import spring.znevzz.reactive.client.gateway.model.FileResource;

import java.util.ArrayList;
import java.util.List;


@Component
public class LocalFileRepository implements FileRepository<String> {

    @Value("${sample.json.data}")
    private String data;

    private List<String> array;
    private Flux<String> flux;

    public LocalFileRepository() {
        this.array = new ArrayList<>();
        this.flux = Flux.fromIterable(array);
    }

    @Override
    public Flux<String> readComplete(FileResource fileResource) {
        return flux;
    }

    public void setArray(String element) {
        array.add( element == null? data : element );
    }
}
