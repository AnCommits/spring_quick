package org.example;

import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);


        for (String beanName: context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        Parrot parrot1 = context.getBean(Parrot.class);
        parrot1.setName("Koko");
        System.out.println(parrot1.getName());
    }
}
