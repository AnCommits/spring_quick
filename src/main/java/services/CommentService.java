package services;

import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    // При объявлении объекта logger необходимо дать ему имя в качестве параметра.
    // Для этого часто используют имя класса.
    // Данное имя будет появляться в записях журнала.
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }
}
