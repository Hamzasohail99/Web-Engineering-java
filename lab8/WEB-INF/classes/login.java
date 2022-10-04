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
    	out.println("<head><title>login</title></head>");
   		out.println("<body>");
    		try{
    			Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1/university";
    			Connection con = DriverManager.getConnection(url,"root","root");
    			Statement s = con.createStatement();
     			String query = "Select * from logininfo where loginid='"+loginid+"' and password = '"+password+"'";
     			ResultSet st = s.executeQuery( query );
		if(st.next()){
	    		String msg = "login successful";
				request.setAttribute("key",msg);
				RequestDispatcher rd = request.getRequestDispatcher("/success");
				rd.forward(request,response);
	    		
 	   	}
		else{
				String msg = "login unsuccessful";
				request.setAttribute("key", msg);
				RequestDispatcher rd = request.getRequestDispatcher("/error");
				rd.forward(request,response);
		}
		out.println("</body></html>");
		s.close();
		con.close();
		}
		catch(Exception e){
			out.println(e);
		}


	}

}