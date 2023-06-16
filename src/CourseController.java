import java.util.ArrayList;

public class CourseController {
    private ArrayList<Student> enrolledStudents;

   public CourseController() {
      this.enrolledStudents = new ArrayList<Student>();
   }

   public ArrayList<Student> getEnrolledStudents(){
      return enrolledStudents;
   }


}
