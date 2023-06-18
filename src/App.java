import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void ClearScreen(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime();
        } catch (IOException | InterruptedException ex) {}
    }
    public static void main(String[] args) throws Exception {
        
        //set of ArrayList that contains basic info
        ArrayList<Lecturer> lecturerList = new ArrayList <Lecturer> ();
        ArrayList<Student> studentList = new ArrayList <Student> ();
        ArrayList<Course> courseList = new ArrayList <Course> ();

        //pass arrayLists into controllers to control data among each controllers
        AdminController aController = new AdminController (lecturerList,studentList,courseList);
        LecturerController lController = new LecturerController (studentList,courseList);
        StudentController sController = new StudentController (courseList);

        //test case
        Student student1 = new Student("Harry", "abc");
        Student student2 = new Student("Hermione", "def");
        studentList.add(student1);
        studentList.add(student2);
        Lecturer lecturer1 = new Lecturer("Ali", "123");
        Lecturer lecturer2 = new Lecturer("Abu", "456");
        lecturerList.add(lecturer1);
        lecturerList.add(lecturer2);
        Course course1 = new Course("SECJ1013","Potion",4,10,"Severus Snape");
        Course course2 = new Course("SECJ2029","Charms",3,10,"Filius Flitwick");
        Course course3 = new Course("SECJ3000","Transfiguration",3,10,"Minerva McGonagall");
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        int role;
        Scanner s = new Scanner(System.in);
        ClearScreen();
        do{
            System.out.println("| Course Registration System |");
            System.out.println("1. Admin \n2. Lecturer \n3. Student ");
            System.out.print("Enter your role >> ");
            role = s.nextInt();
            s.nextLine();
            ClearScreen();
            switch(role){
                case 1:{
                    //Admin
                    aController.adminAction();
                    break;
                }
                case 2:{
                    //Lecturer
                    lController.lecturerAction(lecturerList);
                    break;
                }
                case 3:{
                    //Student
                    sController.studentAction(studentList);
                    break;
                }
            }
        }while(role<4 && role >0);
        
    }
}
