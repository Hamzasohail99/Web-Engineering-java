import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Search extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Searching..</title></head>");
        out.println("<body>");

        String rollNo = request.getParameter("rollNo");
        String name = request.getParameter("studentName");

        PersonDAO personDAO = new PersonDAO();
        PersonInfo person = personDAO.searchPerson(rollNo, name);

        if (person != null) {
            out.println("<h1>Record!</h1>");
            out.println("<table>");
            out.println("<th><tr> <td>Roll No</td> <td> Name </td> <td>      CGPA</td> </tr></th>");
            out.println("<th><tr> <td>" + person.rollNo + "</td> <td>" + person.studentName + "</td> <td>" + person.cgpa
                    + "</td> </tr></th>");
            // out.println(person);
            out.println("</table>");

            out.println("<a href=\"index.html\"> Home </a>");
        } else {

            request.setAttribute("key", "Record not exist");
            RequestDispatcher rd = request.getRequestDispatcher("/Error");
            rd.forward(request, response);
        }

        out.close();
    }

}
