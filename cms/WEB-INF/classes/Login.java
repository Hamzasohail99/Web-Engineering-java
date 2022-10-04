import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        HttpSession session;

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        out.println("<html><head><title>Login Portal</title></head>");
        out.println("<body>");

        try {

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/university";

            Connection con = DriverManager.getConnection(url, "root", "root");

            Statement st = con.createStatement();

            String query = "Select * from authentication where email ='" + email + "' AND password = '" + password
                    + "' ";
            System.out.println(query);
            ResultSet res = st.executeQuery(query);

            if (res.next()) {
                session = request.getSession(true);

                int usr = res.getInt(4);

                session.setAttribute("usertype", usr);
                session.setAttribute("email", res.getString(2));

                if (usr == 0) {
                    st.close();
                    con.close();
                    RequestDispatcher rd = request.getRequestDispatcher("/Courses");
                    rd.forward(request, response);

                } else if (usr == 1) {
                    st.close();
                    con.close();
                    RequestDispatcher rd = request.getRequestDispatcher("/CoursesAssign");
                    rd.forward(request, response);

                }

            } else {
                out.println("<h1>Login Failure</h1>");
                out.println("<a href=\"login.html\">Click here to try again</a>");
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