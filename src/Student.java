import java.util.ArrayList;

public class Student extends Person {
    private String studentID;
    ArrayList <Course> enrolledCourses;

    public Student(){}
    public Student(String name, String studentID) {
        super(name);
        this.studentID = studentID;
        this.enrolledCourses = new ArrayList<Course>();
    }
    public String getStudentID() {
        return studentID;
    }

    public String getName(){
        return super.getName();
    }

    public ArrayList<Course> getEnrolledCourse(){
        return this.enrolledCourses;
    }

}
