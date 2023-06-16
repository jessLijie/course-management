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
