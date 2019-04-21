/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "NewWebService", name = "hello")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String registerOnFlight(@WebParam(name = "a") String a) throws IOException {
        File file = new File("C:/Users/users.txt");
        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            boolean Help;
            while((strLine = br.readLine())!=null){
                Help = strLine.contains(a);
                if (Help){
                    return "Hello " + (a) + " !";
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Ничего не найдено. Попробуйте еще";
    }
    
}
