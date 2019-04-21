import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
/*Программа пробегает по всем полям созданного бина, и если в поле есть аннотация с мин и макс,
* то этому полю присваивается значение суммы двух этих чисел*/


public class InjectNetworkScanCountPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f: fields){
            InjectNetworkScanCount annotation = f.getAnnotation(InjectNetworkScanCount.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                f.setAccessible(true);
                try {
                    f.set(o, max + min);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
