package config;

import org.example.Parrot;
import org.example.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {

    @Bean
    Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Miki");
        return p;
    }

    @Bean
    Person person() {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot());
        return p;
    }
}
