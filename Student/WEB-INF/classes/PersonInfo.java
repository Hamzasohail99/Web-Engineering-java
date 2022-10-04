public class PersonInfo {
    String rollNo;
    String studentName;
    double cgpa;

    public PersonInfo(String n, String a, double pn) {
        rollNo = n;
        studentName = a;
        cgpa = pn;
    }

    public String toString() {
        return "Roll No: " + rollNo + "\n Student Name: " + studentName + "\n CGPA: " + cgpa;
    }
}