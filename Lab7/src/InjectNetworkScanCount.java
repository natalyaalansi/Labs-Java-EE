import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/*Реализуем интерфейс-аннотацию, RetentionPolicy.RUNTIME, чтобы аннотация
была доступна во время работы приложения*/
@Retention(RetentionPolicy.RUNTIME)

public @interface InjectNetworkScanCount {
    int min();
    int max();
}
