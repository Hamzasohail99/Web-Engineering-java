import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Insert extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Inserting..</title></head>");
        out.println("<body>");

        String rollNo = request.getParameter("rollNo");
        String name = request.getParameter("studentName");
        String d = request.getParameter("cgpa");

        Double cgpa = Double.parseDouble(d);

        PersonDAO personDAO = new PersonDAO();
        int person = personDAO.addPerson(rollNo, name, cgpa);

        if (person == 1) {
            out.println("<h1>Record Inserted!</h1>");
            out.println("<a href=\"index.html\"></a>");
        }

        out.close();
    }

}
