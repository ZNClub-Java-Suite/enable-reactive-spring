package spring.znevzz.reactive.file.gateway.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.znevzz.reactive.file.gateway.model.FileResource;
import spring.znevzz.reactive.file.gateway.model.JsonFileResource;

@Configuration
public class FileResourceBeanFactory {

    @Bean
    public FileResource demo(){
         return new JsonFileResource();
    }
}
