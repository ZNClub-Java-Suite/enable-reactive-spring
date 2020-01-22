package spring.znevzz.reactive.client.gateway.model;

import java.util.Map;

public interface FileResource {
    void setName(String name);
    String getName();
    void setLocation(String location);
    String getType();
    Map<String, Object> buildConfiguration();
}
