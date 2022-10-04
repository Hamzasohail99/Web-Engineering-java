import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

public class Data extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>All Data</title></head>");
        out.println("<body>");

        PersonDAO personDAO = new PersonDAO();
        ArrayList<PersonInfo> persons = personDAO.data();

        int i = 0;
        if (persons != null) {
            for (PersonInfo person : persons) {
                out.println("<h3>" + person + "</h3>");
            }

        } else {

            request.setAttribute("key", "Records not exist");
            RequestDispatcher rd = request.getRequestDispatcher("/Error");
            rd.forward(request, response);
        }

        out.close();
    }

}
