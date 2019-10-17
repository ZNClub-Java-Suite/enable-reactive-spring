package spring.znevzz.reactive.client.gateway.factory;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.znevzz.reactive.client.gateway.dao.LocalFileRepository;
import spring.znevzz.reactive.client.gateway.dao.FileRepository;

@Configuration
public class FileRepositoryBeanFactory {
    @Bean
    public FileRepository demo(){
        return new LocalFileRepository();
    }
}
