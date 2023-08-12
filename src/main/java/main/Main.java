package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s1 = context.getBean(CommentService.class);
        var s2 = context.getBean(UserService.class);
        // Каждый сервис получил свой экземпляр CommentRepository
        System.out.println(s1.getCommentRepository() == s2.getCommentRepository());

        context.close();
    }
}
