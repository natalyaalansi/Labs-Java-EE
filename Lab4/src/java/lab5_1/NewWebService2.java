/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;




@WebService(serviceName = "NewWebService2")
public class NewWebService2 {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "NewWebService2")
    public String NewWebService2(@WebParam(name = "name") String name) {
        File file = new File("C:/Users/Alansi89/Documents/users1.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.newLine();
            bw.write (name);
            bw.flush();
            return name + " has registered on flight!";
        } catch (IOException ex) {
            System.out.println("Error on the server #1");
        }
        
        return "No entry written. Try again.";
    }

}
