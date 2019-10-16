package spring.znevzz.reactive.file.gateway.model;

import java.util.Map;

public interface FileResource {
    String getType();
    Map<String, Object> buildConfiguration();
}
