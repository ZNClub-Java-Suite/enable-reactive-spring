package spring.znevzz.reactive.file.gateway.model;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class JsonFileResource implements FileResource {

    @Override
    public String getType() {
        return "JSON";
    }

    @Override
    public Map<String, Object> buildConfiguration() {
        return Collections.emptyMap();
    }
}
