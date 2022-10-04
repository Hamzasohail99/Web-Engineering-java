import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.security.interfaces.RSAKey;

public class insertstudentservlet extends HttpServlet { 

public void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 

	String rollno = request.getParameter("rollno"); 
	String name = request.getParameter("name"); 
	String cgpa = request.getParameter("cgpa"); 
	
	studentDAO studentDAO = new studentDAO(); 
	int student = studentDAO.insertstudent(rollno, name, cgpa); 

	out.println("<html>"); 
	out.println("<body>"); 
	out.println("<h1>Search Results</h1>");

	if (student == 1){ 
		out.println("<h3>Student entered successfullyu</h3>" ); 
			} 
	else{ 
		out.println("<h3>Sorry! No records found</h3>" ); 
	} 
	out.println("</body>"); 
	out.println("</html>");
	out.close(); 
	} 

// Handles the HTTP GET method.
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException { 
		processRequest(request, response);} 

// Handles the HTTP POST method 
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
		processRequest(request, response); 
 } 

}
