package spring.znevzz.reactive.client.gateway.model;

import java.util.Map;

public interface FileResource {
    void setName(String name);
    void setLocation(String location);
    String getType();
    Map<String, Object> buildConfiguration();
}
