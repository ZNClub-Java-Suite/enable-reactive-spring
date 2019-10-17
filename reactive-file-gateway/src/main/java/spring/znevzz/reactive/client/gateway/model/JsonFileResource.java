package spring.znevzz.reactive.client.gateway.model;

import java.util.HashMap;
import java.util.Map;

public class JsonFileResource implements FileResource {

    private String name;
    private String location;
    private Map<String, Object> configuration = new HashMap<>();

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getType() {
        return "JSON";
    }

    @Override
    public Map<String, Object> buildConfiguration() {
        configuration.putIfAbsent("NAME", this.name);
        configuration.putIfAbsent("LOCATION", this.location);
        return new HashMap<>(configuration);
    }

}
