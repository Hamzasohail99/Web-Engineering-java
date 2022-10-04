public class studentinfo { 
String rollno; 
String name; 
String cgpa; 
public studentinfo(String rno, String nm, String cgp) { 
    rollno = rno; 
    name = nm; 
    cgpa = cgp; 
} 
public String toString( ){ 
    return "Name: " + name + " rollno: " + rollno + " cgpa: " + cgpa; 
} 
}