package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

import hash.MD5Hash;

/**
 * Created by Виталий on 28.04.2017.
 */
public class Server implements Runnable{
    public ServerSocket ss;//объявляем серверный сокет
    public Server() { //конструктор класса Сервер
        try {
            ss=new ServerSocket(10800); //создаем серверный сокет, порт такой же, как в клиенте
            Socket socket =ss.accept(); //создаем сокет, производный от серверного сокета
            System.out.println("Connecting to some client"); //просто некое сообщение

            InputStream is=socket.getInputStream(); //создаем входящий поток
            int stringLength=is.read(); //объявляем переменную, которая будет суммировать все принятые числа
            StringBuilder inputText = new StringBuilder();//объявляем переменную, в которую будут записываться числа из входящего потока

            for(int i=1;i<=stringLength;i++){//пишем в y значения, полученные из входящего потока. Условия прекращения цикла - пока Клиент не пришлет 0
                inputText.append((char)is.read());
                System.out.println("InputText now is "+inputText);
            };

            System.out.println(inputText);

            //System.out.println("Server: calculate: " + summ);//печатаем результат от имени сервера
            OutputStream os=socket.getOutputStream();//создаем исходящий поток
            String hash=MD5Hash.getHash(inputText.toString());
            os.write(hash.length());
            for(byte x:hash.getBytes()){
                os.write(x);
            }
            //os.write(summ);//пишем значение суммы в исходящий поток

        }catch (IOException ex){
            System.out.println("Server: exception thown " + ex);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        ;
      /*  new Thread(new Runnable(){
            @Override
            public void run() {
            new Server();
            }
        });*/
    }


    @Override
    public void run() {
        new Server();
    }
}