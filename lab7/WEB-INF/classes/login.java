import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class login extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String loginid = request.getParameter("loginid");
		String password  = request.getParameter("password");
		out.println("<html>");
    		out.println("<head><title>search</title></head>");
   		out.println("<body>");
    		try{
    			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/labtest";
    			Connection con = DriverManager.getConnection(url,"root","root");
    			Statement s = con.createStatement();
     			String query = "Select * from t2 where loginid='"+loginid+"' ";
     			ResultSet st = s.executeQuery( query );
		if(st.next()){
	    		out.println("<h1>record found</h1>");
	    		
 	   	}
		else{
			out.println("<h1>record not found</h1>");
		}
		out.println("</body></html>");
		s.close();
		con.close();
		}
		catch(IOException e){
			out.println(e);
		}


	}

}