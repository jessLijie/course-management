import java.util.Scanner;

public class LecturerView {
    Scanner s = new Scanner(System.in);

    public String readCourse() 
    {
        System.out.print("Enter Course Code >> ");
        String code = s.nextLine();
        return code;
    }

    public void displayStudentList(Student s)
    {
        System.out.println("Name: " +s.getName());
    }

}
