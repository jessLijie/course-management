import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private int credit;
    private int maxStudent;
    private int currentRegistered;
    private String coordinator;
    ArrayList<Student> enrolledStudent;

    public Course(){
        this.enrolledStudent = new ArrayList<Student>();
    }

    public Course(String courseCode, String courseName, int credit, int maxStudent,
            String coordinator) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
        this.maxStudent = maxStudent;
        this.currentRegistered = 0;
        this.coordinator = coordinator;
        this.enrolledStudent = new ArrayList<Student>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public int getCurrentRegistered() {
        return currentRegistered;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

   public ArrayList<Student> getEnrolledStudents(){
      return enrolledStudent;
   }

   public void setCurrentRegistered(int currentRegistered) {
        this.currentRegistered = currentRegistered;
    }

   public void displayStudentRegistered(ArrayList<Student>enrolledStudents){
        if(enrolledStudents.size() == 0){
            System.out.println("No student registered yet.");
        }else{
            for(int i= 0; i<enrolledStudents.size(); i++){
                Student student= enrolledStudents.get(i);
                System.out.println("Students registered");
                student.getName();
            }
        }
    }



}
