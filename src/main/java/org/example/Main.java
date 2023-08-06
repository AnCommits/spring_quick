package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        System.out.println("=========");

        Parrot parrot1 = context.getBean(Parrot.class);
        System.out.println(parrot1.getName());

        Sparrow sparrow1 = context.getBean(Sparrow.class);
        System.out.println(sparrow1.getName());

        // Программное добавление бинов в контекст Spring
        Parrot x = new Parrot();
        x.setName("ProgParrot");
        Supplier<Parrot> parrotSupplier = () -> x;
        context.registerBean("softwareParrot", Parrot.class, parrotSupplier);

        Parrot parrot2 = context.getBean("softwareParrot", Parrot.class);
        System.out.println(parrot2.getName());

        Parrot x2 = new Parrot();
        x2.setName("PrimaryParrot");
        Supplier<Parrot> parrotSupplier2 = () -> x2;
        context.registerBean(
                "parrot2",
                Parrot.class,
                parrotSupplier2,
                bc -> bc.setPrimary(true)); // сделать бин первичным

        Parrot parrot3 = context.getBean(Parrot.class);
        System.out.println(parrot3.getName());

        context.close();
    }
}
