import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        out.println("<html>");
        out.println("<head><title>Logout</title></head>");
        out.println("<body><h1>Logout</h1>");

        if (session != null) {
            session.invalidate();
            session = null;

            out.println("<h1>You have been logged out successfully</h1>");
            out.println(("<a href=\"index.html\">Continue to main page</a>"));
            return;
        }

        out.println("<h1>You are not logged in</h1>");
        out.println(("<a href=\"Login\">Go to Login</a>"));

        out.println("</body></html>");

        out.close();

    }

}
