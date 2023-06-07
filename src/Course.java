import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private int credit;
    private int maxStudent;
    private String coordinator;

    public Course(String cc, String cn, int c) {
        this.courseCode = cc;
        this.courseName = cn;
        this.credit = c;
        this.maxStudent = 0;
        this.coordinator = "";
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setMaxStudent(int max) {
        this.maxStudent = max;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCoordinator() {
        return coordinator;
    }

}
