package spring.znevzz.reactive.file.gateway.factory;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.znevzz.reactive.file.gateway.dao.FileRepository;
import spring.znevzz.reactive.file.gateway.dao.LocalFileRepository;

@Configuration
public class FileRepositoryBeanFactory {
    @Bean
    public FileRepository demo(){
        return new LocalFileRepository();
    }
}
