import java.util.ArrayList;
import java.util.Scanner;

public class LecturerView {
    Scanner s = new Scanner(System.in);

    public String readCourse() 
    {
        System.out.print("Enter Course Code >> ");
        String code = s.nextLine();
        return code;
    }

    public void displayRegisteredCourse(Course c)
    {
        System.out.println();
        System.out.println("Registered Course");
        System.out.println("Course Code: " + c.getCourseCode());
        System.out.println("Course Name: " + c.getCourseName());
        System.out.println("Course Credit(s): " + c.getCredit());
        System.out.println("Course Coordinator: " + c.getCoordinator());
        System.out.println("Course's maximum student: " + c.getMaxStudent());
        System.out.println("Current enrolled student: " + c.getCurrentRegistered());
        System.out.println();
    }
    
    public void displayStudentList(ArrayList<Student>enrolledStudentList)
    {
        if(enrolledStudentList.size()==0){
            System.out.println("No students enrolled");
        }else{
            for (int i = 0; i < enrolledStudentList.size(); i++) {
                Student s = enrolledStudentList.get(i);
                System.out.println(s.getName());
                System.out.println();
            }
        }      }

}
