package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

import hash.MD5Hash;
import source.Sourse;

/**
 * Created by Виталий on 28.04.2017.
 */
public class Client implements Runnable{
    public Client()  {
        try {
            Socket clientSocket = new Socket("localhost", 10800); //Создаем сокет, параметры - хост и порт. В данном случае хост - локальный компьютер, вместо него может быть IP
            OutputStream os = clientSocket.getOutputStream(); //создаем исходящий поток
            //производим действия, которые будут передаваться в исходящий поток
            String mySet = Sourse.getText();//объявляем массив со значенниями
            os.write(mySet.length());
            for(byte x:mySet.getBytes()){//цикл: перебираем все значения из массива
                os.write(x); //пишем значения в исходящий поток
            };

            //блок, принимаещий информацию из входящего потока
            InputStream is = clientSocket.getInputStream(); //создаем входящий поток
            int hashLength = is.read();
            StringBuilder hash = new StringBuilder();
            for (int i=1;i<=hashLength;i++){
                hash.append((char)is.read());
            }
            System.out.println("Server get: hash is "+hash); //печатаем полученный результат
            System.out.println("Client: mySet hash is "+MD5Hash.getHash(mySet));
            if(MD5Hash.getHash(mySet).compareTo(hash.toString())==0){
                System.out.println("Hash from client is equal to hash from server");
            }
            System.out.println(MD5Hash.getHash(mySet).compareTo(hash.toString()));

        } catch (IOException ex){
            System.out.println("Something wrong: "+ex);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        new Client();
    }
}