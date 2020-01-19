package spring.znevzz.reactive.client.gateway.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.znevzz.reactive.client.gateway.model.FileResource;
import spring.znevzz.reactive.client.gateway.model.JsonFileResource;

@Configuration
public class FileResourceBeanFactory {

    @Bean("funds")
    public FileResource demo(){
       FileResource funds = new JsonFileResource();
       funds.setName("mutual_funds");
       funds.setLocation("/home/znevzz/Desktop/Projects/ZNevzz/DataVisuals/data/mutual_funds.json");
       return funds;
    }
}
