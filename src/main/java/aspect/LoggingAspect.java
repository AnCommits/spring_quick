package aspect;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Получение имени и параметров перехватываемого метода
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");

        Comment comment = new Comment();
        comment.setText("Some other text");
        Object[] newArguments = {comment};

        Object returnedByMethod = joinPoint.proceed(newArguments);

        // Значение, возвращаемое перехваченным методом, выводится в консоль,
        // а вызывающий метод получает другое значение
        logger.info("Method executed and returned " + returnedByMethod);
        return "Failed";
    }
}
