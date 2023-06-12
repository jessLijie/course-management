public class Course {
    private String courseCode;
    private String courseName;
    private int credit;
    private int maxStudent;
    private String coordinator;


    public Course(String cc, String cn, int c, int max) {
        this.courseCode = cc;
        this.courseName = cn;
        this.credit = c;
        this.maxStudent = max;
        this.coordinator = "";
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

    public int getMaxStudent() {
        return maxStudent;
    }

}
