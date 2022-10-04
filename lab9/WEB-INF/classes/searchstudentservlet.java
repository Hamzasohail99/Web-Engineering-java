import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class searchstudentservlet extends HttpServlet { 

public void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 

	String rollno = request.getParameter("rollno");
	String name = request.getParameter("name"); 
	 
	

	
	// creating PersonDAO object, and calling searchPerson() method 
	studentDAO studentDAO = new studentDAO(); 
	studentinfo student = studentDAO.searchstudent(rollno, name); 

	out.println("<html>"); 
	out.println("<body>"); 
	out.println("<h1>Search Results</h1>");

	if (student != null){ 
		out.println("<h3>"+ student.toString() +"</h3>" ); 
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
