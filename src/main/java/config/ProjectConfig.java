package config;

import aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"services", "aspect"})
@EnableAspectJAutoProxy // Активирует аспекты в Spring-приложении
public class ProjectConfig {

    @Bean // Добавляет экземпляр класса LoggingAspect в контекст Spring
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
