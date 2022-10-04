import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.servlet.http.HttpSession;

public class Courses extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.html");
        }

        String email = (String) session.getAttribute("email");
        int usertype = (int) session.getAttribute("usertype");

        if ((Integer) session.getAttribute("usertype") != usertype) {
            response.sendRedirect("login.html");
        }

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student Portal</title></head>");
        out.println("<body>");

        try {

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/university";

            Connection con = DriverManager.getConnection(url, "root", "root");

            Statement st = con.createStatement();

            String query = "Select course.name from course, uniprofile where (course.semester = uniprofile.semester) AND uniprofile.email ='"
                    + email + "'";

            ResultSet res = st.executeQuery(query);

            int flag = 0;

            out.println("<h1>Subjects</h1>");
            while (res.next()) {
                flag = 1;
                out.println("<h5>" + res.getString(1) + "</h1>");
            }

            if (flag == 0) {
                out.println("<h1> No Data Found! </h1>");
            }

            out.println("<FORM ACTION=\"/cms/Logout\" METHOD=POST>");
            out.println("Would you like to<BR>");
            out.println("<INPUT TYPE=submit VALUE=\" Logout \">");
            out.println("</FORM>");

            out.println("</body></html>");

            out.close();
            st.close();
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }

}