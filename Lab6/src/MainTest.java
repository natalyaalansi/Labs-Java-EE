import org.springframework.context.support.ClassPathXmlApplicationContext;
/*Проверяем работу чтения свойств*/
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("PlatformConfig.xml");
        context.getBean(WindowsPlatform.class).printPlatformName();
    }
}
