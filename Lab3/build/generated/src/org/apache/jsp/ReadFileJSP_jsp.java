package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;

public final class ReadFileJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
 
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
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
