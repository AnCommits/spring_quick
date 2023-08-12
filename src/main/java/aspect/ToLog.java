package aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Активировать аннотацию для перехвата во время выполнения приложения
@Retention(RetentionPolicy.RUNTIME)
// Применять аннотацию только для методов
@Target(ElementType.METHOD)
public @interface ToLog {
}
