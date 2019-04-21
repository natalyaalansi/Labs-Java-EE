package App;
import Client.Client;
import Server.Server;

public class Application {
    public static void main(String[] args) {
//Создаем сервер в новом потоке
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Server();
            }
        }).start();

//создаем клиент в новом потоке
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        }).start();
    }
}