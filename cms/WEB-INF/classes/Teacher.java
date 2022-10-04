import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Teacher extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        out.println("<html>");
        out.println("<head><title>Signup Teacher</title></head>");
        out.println("<body>");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/university";

            Connection con = DriverManager.getConnection(url, "root", "root");

            Statement st = con.createStatement();

            String query = "INSERT INTO authentication (email, password, usertype) VALUES ('" + email + "', '"
                    + password + "', '1')";

            int res = st.executeUpdate(query);

            String query1 = "INSERT INTO uniprofile (email, name, phoneno) VALUES ('" + email + "', '"
                    + name + "', '" + phone + "')";

            System.out.println(query1);
            int rs = st.executeUpdate(query1);

            if (res == 1 && rs == 1) {
                out.println("Signup Successful!");
                out.println("<a href=\"login.html\"> Login   </a>");
            } else {
                out.println("Signup Failed!");
            }

            out.println("</body></html>");

            out.close();
            st.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
        }

    }

}
