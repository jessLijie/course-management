import java.util.ArrayList;

public class CourseView {

    public void displayStudentRegistered(ArrayList<Student>enrolledStudents){
        if(enrolledStudents.size() == 0){
            System.out.println("No student registed yet.");
        }else{
            for(int i= 0; i<enrolledStudents.size(); i++){
                Student student= enrolledStudents.get(i);
                System.out.println("Students registered");
                student.getName();
            }
        }
    }
}
