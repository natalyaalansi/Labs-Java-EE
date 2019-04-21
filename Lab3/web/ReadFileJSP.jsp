<%-- 
    Document   : ReadFileJSP
    Created on : Nov 8, 2018, 2:04:52 PM
    Author     : Alansi89
--%>

<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
        String fName = "/WEB-INF/users.txt";
        ServletContext cntxt = getServletContext();
        InputStream inStream = cntxt.getResourceAsStream(fName);
        
        String getLineFromFile;
        String selectName;
        boolean findType;
        int i = 0;
        selectName = request.getParameter("selectname");
        findType = request.getParameter("equalfind")!= null;
        BufferedReader br = new BufferedReader((new InputStreamReader(inStream)));

         out.println("<table border = \"1\">");
        //В цикле читаем строки до тех пор, пока не дойдем до последней строки
        while((getLineFromFile = br.readLine())!= null)
        {
            String[] wordFields = getLineFromFile.split(",");
            if (findType)
            {
                //если строка содержит переменную пкотрой фильтруем, 
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
        // если переменная переменную которая отвечает за количество 
        //вхождений равна 0, то выводим сообщение об этом
        if (i == 0){
            out.println("Ни одной строки не найдено.");
        }
        %>
    </body>
</html>

