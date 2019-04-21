/*Создаем класс-реализацию метода. В класс добавляем свойство "platformName" и метод-setter*/
public class WindowsPlatform implements Platform {

    private String platformName;

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public void printPlatformName() {
        System.out.println(platformName);
    }
}
