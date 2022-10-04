import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class error extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
 	{
   	String key = (String)request.getAttribute("key");
	 
   	PrintWriter out = response.getWriter();


  	out.println("<html><body><b>"+key+" </b><br><body></html>");
 	}
}
