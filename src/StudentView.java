import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {
    Student student;
    Scanner scanner = new Scanner(System.in);

    public void ClearScreen() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime();
        } catch (IOException | InterruptedException ex) {
        }
    }

    public int StudentMenu(ArrayList<Student> students) {
        int action;
        System.out.println("Howdy Student!");
        // if(this.Leclogin=false){
            if (verifyIdentity(students) == true) {
            System.out.println("Successfully login as student");
            System.out.println("\n1. Register for course \n2. View Registered Courses");
            System.out.print("Enter your action >> ");
            action = scanner.nextInt();
            scanner.nextLine();
            return action;
        // }
        // else{
        //     System.out.println("\n1. Register for course \n2. View Registered Courses");
        //     System.out.print("Enter your action >> ");
        //     action = scanner.nextInt();
        //     scanner.nextLine();
        //     return action;
        // }
        }
        System.out.println("Login as student failed");
        return -1;
    }

    public boolean verifyIdentity(ArrayList<Student> students) {
        System.out.print("Enter your name >> ");
        String studentName = scanner.nextLine();
        System.out.print("Enter your student ID >> ");
        String studentID = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (studentName.equals(students.get(i).getName())
                    && studentID.equals(students.get(i).getStudentID())) {
                // set current student
                student = students.get(i);
                return true;
            }

        }
        return false;
    }

    public Student getCurrentStudent(){
        return this.student;
    }

    public String enterCourseView(){
        System.out.print("Enter the course code to register >> ");
        String code= scanner.nextLine();
        return code;      
    }

    public void displayCourseDetails(ArrayList<Course> courseList) {
        if (courseList.size() == 0) {
            System.out.println("No available course! \n");
        } else {

            System.out.println("Course Information");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s %-12s %-25s %-10s %-20s %-23s %-22s\n",
                    "No.", "Code", "Name", "Credit(s)", "Coordinator", "Max Participants", "Enrolled Participants");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.printf("%-5d %-12s %-25s %-10d %-20s %-23d %-22d\n",
                        (i + 1),
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getCredit(),
                        course.getCoordinator(),
                        course.getMaxStudent(),
                        course.getCurrentRegistered());
            }
            System.out.println();
        }
    }

    public void displayRegisteredCourse(ArrayList<Course>registered){
        
        if(registered.size()==0){
            System.out.println("No course is registered");
        }else{
             System.out.println(this.student.getName()+"'s registered course(s)");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s %-12s %-25s %-10s %-20s %-23s %-22s\n",
                    "No.", "Code", "Name", "Credit(s)", "Coordinator", "Max Participants", "Enrolled Participants");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < registered.size(); i++) {
                Course course = registered.get(i);
                System.out.printf("%-5d %-12s %-25s %-10d %-20s %-23d %-22d\n",
                        (i + 1),
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getCredit(),
                        course.getCoordinator(),
                        course.getMaxStudent(),
                        course.getCurrentRegistered());
            }
            System.out.println();
        }  
    }
    
    
}
