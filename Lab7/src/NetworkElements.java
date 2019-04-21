/*Создаем простой класс с полем примитивного типа (int)
и пометим своей собственной аннотацией)*/
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NetworkElements {
    @InjectNetworkScanCount(min = 1, max = 10000)

    private int NECount;
    public void printNECount(){ System.out.println(NECount); }

    /*Программа пишет класс с методом main, в нем есть ссылка на xml-конфигурацию, а в нем
      * в том числе инициализируется  в том числе бин InjectNetworkScanCountPostProcessor,
       * который перехватывает события после инициализации NetworkElements*/
    public static void main(String   [] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Network.xml");
        context.getBean(NetworkElements.class).printNECount();
    }

}
