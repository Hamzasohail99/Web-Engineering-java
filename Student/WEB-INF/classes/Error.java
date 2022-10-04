import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Error extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Error</title></head>");
        out.println("<body>");

        String loginID = request.getParameter("loginId");

        String key = (String) request.getAttribute("key");

        out.println("<h1>" + key + "</h1>");

        out.println("<a href=\"index.html\"> Search </a>");

        out.println("</body></html>");

        out.close();

    }

}
