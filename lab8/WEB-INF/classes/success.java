import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class success extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String key = (String)request.getAttribute("key");
		String loginid = request.getParameter("loginid");
		String password  = request.getParameter("password");
		out.println("<html>");
    		out.println("<head><title>error</title></head>");
   		out.println("<body>");
    		try{
    			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/university";
    			Connection con = DriverManager.getConnection(url,"root","root");
    			Statement s = con.createStatement();
     			String query = "Select * from profile where loginid = '"+loginid+"'";
     			ResultSet st = s.executeQuery( query );
		
	

		out.println("<h1>success</h1>");
		out.println("</body></html>");
		s.close();
		con.close();
		}
		catch(Exception e){
			out.println(e);
		}


	}

}