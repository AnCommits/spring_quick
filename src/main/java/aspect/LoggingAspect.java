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

    @Around("@annotation(ToLog)") // Вплетение аспекта в методы с аннотацией @ToLog
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Получение имени и параметров перехватываемого метода
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");

        Object returnedByMethod = joinPoint.proceed(arguments);

        logger.info("Method executed and returned " + returnedByMethod);
        return null;
    }
}
