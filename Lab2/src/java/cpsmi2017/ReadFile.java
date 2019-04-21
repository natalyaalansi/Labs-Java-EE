/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpsmi2017;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadFile", urlPatterns = {"/ReadFile"})
public class ReadFile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //получаем переменную по которой будем фильтровать
            String selectName = request.getParameter("selectname");
            boolean findType = request.getParameter("equalfind")!= null;

            //что-то делаем, пока не знаю что
            ServletContext cntxt = getServletContext();
            //формируем переменную откуда будем читать файл
            String fName = "/WEB-INF/users.txt";
            //вводим переменную по которой будем определять количество вхождений
            int i = 0;
            InputStream inStream = cntxt.getResourceAsStream(fName);
            //если входной поток из файла пустой, то выдаем ошибку
            if(inStream == null){
		response.setStatus(response.SC_NOT_FOUND);
            }
            //если нет, то начинаем работать с файлом
            else
            {
                //создаем объект потокового чтения
                BufferedReader br = new BufferedReader((new InputStreamReader(inStream)));
                //Создаем временную переменную - строку
                String getLineFromFile;
                
                //Тут формируем html страницу
                out.println("<!DOCTYPE HTML>");
                out.println("<html><body>");
                out.println("<table border = \"1\">");
                //В цикле читаем строки до тех пор, пока не дойдем до последней строки
                while((getLineFromFile = br.readLine())!= null)
                {
                    String[] wordFields = getLineFromFile.split(",");
                    if (findType)
                    {
                        //если строка содержит переменную по которой фильтруем, 
                        //то выводим эту строку в строке таблицы html 
                        //и увеличиваем переменную которая отвечает за 
                        //количество вхождений на единицу
                        if (wordFields[0].equals(selectName)){
                            out.println("<tr>");
                            for (int field = 0; field < wordFields.length; field++)
                            {
                                out.println("<td>" + wordFields[field] + "</td>");
                            }
                            out.println("</tr>");
                            i++;
                        }
                        
                    }
                    else
                    {
                        if (wordFields[0].contains(selectName)){
                            out.println("<tr>");
                            for (int field = 0; field < wordFields.length; field++)
                            {
                                out.println("<td>" + wordFields[field] + "</td>");
                            }
                            out.println("</tr>");
                            i++;
                        }

                    }
		}
                out.println("</table>");
                // если переменная,которая отвечает за количество 
                //вхождений равна 0, то выводим сообщение об этом
                if (i == 0){
                    out.println("Ни одной строки не найдено.");
                }
                out.println("</body></html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
