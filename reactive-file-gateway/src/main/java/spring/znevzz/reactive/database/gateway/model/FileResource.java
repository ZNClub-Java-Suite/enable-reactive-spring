package spring.znevzz.reactive.database.gateway.model;

import java.util.Map;

public interface FileResource {
    String getType();
    Map<String, Object> buildConfiguration();
}
