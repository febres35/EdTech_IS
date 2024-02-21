package cienciasucv.certicomp.Models;

public class Student extends User{
        private String studentID;
    
        public Student(String name, String lastname, String nationalID, String email, String studentID) {
            super(name, lastname, nationalID, email);
            this.studentID = studentID;
            setRole(role.STUDENT);
        }
    
        public String getStudentID() {
            return studentID;
        }
    
        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }
    }
