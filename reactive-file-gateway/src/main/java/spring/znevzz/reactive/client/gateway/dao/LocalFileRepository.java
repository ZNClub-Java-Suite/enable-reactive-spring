package spring.znevzz.reactive.client.gateway.dao;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import spring.znevzz.reactive.client.gateway.model.FileResource;
import spring.znevzz.reactive.client.gateway.model.FileResourceAttributes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


@Component
public class LocalFileRepository implements FileRepository<String> {


    @Override
    public Flux<String> readComplete(FileResource fileResource) throws IOException {

        Flux<String> result;

        Map<String, Object> configuration = fileResource.buildConfiguration();
        String location = (String) configuration.get(FileResourceAttributes.LOCATION.name());
        try(BufferedReader reader = new BufferedReader(new FileReader(location))){
//            Stream<String> lines = reader.lines();
//            result = Flux.fromStream(lines);

            String[] objects = reader.lines().toArray(String[]::new);
            result = Flux.fromArray(objects);
        }
        //temporary
        return result;
    }

}
