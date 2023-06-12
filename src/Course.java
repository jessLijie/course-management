import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private int credit;
    private int maxStudent;
    private int currentRegistered;
    private String coordinator;


    public Course(String cc, String cn, int c, int max) {
        this.courseCode = cc;
        this.courseName = cn;
        this.credit = c;
        this.maxStudent = max;
        this.currentRegistered = 0;
        this.coordinator = "";
    }


    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCurrentRegistered(int currentRegistered) {
        this.currentRegistered = currentRegistered;
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

    public int getCurrentRegistered() {
        return currentRegistered;
    }

    public void displayCourseDetails(ArrayList<Course>courseList){
        if(courseList.size()==0){
            System.out.println("No available course");
        }else{
            for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            System.out.println("Course [" + (i + 1) + "]");
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course Credit(s): " + course.getCredit());
            System.out.println("Course Coordinator: " + course.getCoordinator());
            System.out.println("Course's maximum student: " + course.getMaxStudent());
            System.out.println("Current enrolled student: " + course.getCurrentRegistered());
            System.out.println();
        }
        }
        
    }


    

}
