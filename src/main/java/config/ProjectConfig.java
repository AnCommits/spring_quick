package config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import services.CommentService;

@Configuration
@ComponentScan(basePackages = {"services", "repositories"})
public class ProjectConfig {

//    @Bean
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE) // Объявляем бин прототипным
//    public CommentService commentService() {
//        return new CommentService();
//    }
}
