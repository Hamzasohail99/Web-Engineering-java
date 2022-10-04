import java.sql.*; 
public class studentDAO { 

  public int insertstudent(String srollno, String sname, String scgpa){ 
   int rs = 0;
   try { 

	
	Class.forName("com.mysql.jdbc.Driver"); 
	String url = "jdbc:mysql://127.0.0.1/university"; 
	Connection con = DriverManager.getConnection(url, "root", "root"); 
	String sql = "INSERT INTO studentinfo (rollno, studentname, cgpa) VALUES(?, ?, ?) "; 
	PreparedStatement pStmt = con.prepareStatement(sql); 
	pStmt.setString(1, srollno);
	pStmt.setString(2, sname);
	pStmt.setString(3, scgpa); 
	 rs = pStmt.executeUpdate(); 
	
	con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 

  return rs; 
 }
 public studentinfo searchstudent(String srollno, String sname){ 
	studentinfo student = null; 
	try { 
 
	 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 String url = "jdbc:mysql://127.0.0.1/university"; 
	 Connection con = DriverManager.getConnection(url, "root", "root"); 
	 String sql = "SELECT * FROM studentinfo WHERE rollno = ? "+" AND studentname = ?"; 
	 PreparedStatement pStmt = con.prepareStatement(sql); 
	 pStmt.setString(1, srollno);
	 pStmt.setString(2, sname);
	  
	 ResultSet rs = pStmt.executeQuery(); 
	 if (rs.next( ) ) { 
		 String rollno = rs.getString("rollno"); 
		 String name = rs.getString("name"); 
		 String cgpa = rs.getString("cgpa"); 
		 student = new studentinfo(rollno, name, cgpa); 
	 } 
	 con.close(); 
	 }
	 catch(Exception ex){ 
		 System.out.println(ex); 
	 } 
 
   return student; 
  } 
}