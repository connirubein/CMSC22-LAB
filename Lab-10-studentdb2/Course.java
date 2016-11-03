package studentdb2;
import java.io.Serializable;

/**
 * Created by Conni on 11/3/2016.
 */
public class Course implements Serializable{
    
    private String courseCode;
    private String courseDescription;
    
    public Course(String cc, String cd){
        this.courseCode = cc;
        this.courseDescription = cd;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }
    public void setCourseCode( String cc ) {
        this.courseCode = cc;
    }

    public void setCourseDescription( String cd ) {
        this.courseDescription = cd;
    }

    public String toString(){
        return String.format("Course Code: %s\nCourse Description: %s", courseCode, courseDescription);
    }

}
