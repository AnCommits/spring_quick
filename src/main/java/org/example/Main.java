package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        for (String beanName: context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        System.out.println("=========");

        Parrot parrot1 = context.getBean(Parrot.class);
        System.out.println(parrot1.getName());

        Sparrow sparrow1 = context.getBean(Sparrow.class);
        System.out.println(sparrow1.getName());

        context.close();
    }
}
