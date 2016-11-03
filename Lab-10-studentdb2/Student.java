package studentdb2;
import java.io.Serializable;

/**
 * Created by Conni on 11/3/2016.
 */
public class Student implements Serializable{
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubject;

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, String courseCode, String courseDescription) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.crushName = crushName;
        this.setFaveSubject(courseCode,courseDescription);
    }
    
    public String getStudentNumber() {
    
        return studentNumber;
    
    }
    
    public String getCrushName() {
    
        return crushName;
    
    }
    
    public void setCrushName(String cName) {
    
        this.crushName = cName;
    
    }
    
    public void setFaveSubject(String cc, String cd) {
    
        this.faveSubject.setCourseCode(cc);
        
        this.faveSubject.setCourseDescription(cd);
    
    }
    
    public Course getFaveSubject() {
    
        //Course c = new Course();
        //c.setCourseCode(this.getCourseCode());
        //c.setCourseDescription(this.getCourseDescription());
        return faveSubject;
    
    }
    
    public String getCourseCode() {
    
        return faveSubject.getCourseCode();
    
    }
    
    public String getCourseDescription() {
    
        return faveSubject.getCourseDescription();
    
    }
    
    public void setStudentNumber(String studentNumber) {
    
        this.studentNumber = studentNumber;
   
    }
    
    public String getFirstName() {
    
        return firstName;
    
    }
    
    public void setFirstName(String firstName) {
    
        this.firstName = firstName;
    
    }
    
    public char getMiddleInitial() {
    
        return middleInitial;
    
    }
    
    public void setMiddleInitial(char middleInitial) {
    
        this.middleInitial = middleInitial;
    
    }
    
    public String getLastName() {
    
        return lastName;
    
    }
    
    public void setLastName(String lastName) {
    
        this.lastName = lastName;
    
    }
    
    public String getCourse() {
    
        return course;
    
    }
    
    public void setCourse(String course) {
    
        this.course = course;
    
    }
    
    public int getYearLevel() {
    
        return yearLevel;
    
    }
    
    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }
    
    
    
    @Override
    public String toString() {
        return String.format("Student Number: %s\nFirst Name: %s\nMiddle Initial: %c\nLast Name: %s\nProgram: %s\nYear Level: %d\nCrush's Name: %s\nFavorite Subject: \n\tCourse code: %s\n\tCourse Description: %s" studentNumber, firstName, middleInitial, lastName, course, yearLevel, crushName, getCourseCode(), getCourseDescription());
    }



}
