import java.util.ArrayList;
import java.util.Scanner;

public class LecturerView {
    Lecturer lecturer;
    boolean Leclogin;
    Scanner s = new Scanner(System.in);
    public LecturerView(){
        this.Leclogin=false;
    }

    public int LecturerMenu(ArrayList<Lecturer> lecturers) {
        int action;
        System.out.println("Howdy Lecturer!");
        // if(this.Leclogin=false){
            if (verifyIdentity(lecturers) == true) {
            System.out.println("Successfully login as lecturer \n");
            System.out.println("1. View course coordinated \n2. Register Roster \n3. View Student List");
            System.out.print("Enter your action >> ");
            action = s.nextInt();
            s.nextLine();
            return action;
        // }
        // else{
        //     System.out.println("1. View course coordinated \n2. Register Roster \n3. View Student List");
        //     System.out.print("Enter your action >> ");
        //     action = s.nextInt();
        //     s.nextLine();
        //     return action;
        // }
        }
        System.out.println("Login as lecturer failed");
        return -1;
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

    public boolean verifyIdentity(ArrayList<Lecturer> lecturers) {
        
        System.out.print("Enter your name >> ");
        String lecturerName = s.nextLine();
        System.out.print("Enter your lecturer ID >> ");
        String lecturerID = s.nextLine();
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturerName.equals(lecturers.get(i).getName())
                    && lecturerID.equals(lecturers.get(i).getLecturerID())) {
                // set current lecturer
                lecturer = lecturers.get(i);
                return true;
            }

        }
        return false;
    }

    public Lecturer getCurrentLecturer() {
        return lecturer;
    }

    public String readCourse() {
        System.out.print("Enter Course Code >> ");
        String code = s.nextLine();
        return code;
    }

    public void displayCoordinatedCourse(Course c) {
        System.out.println();
        System.out.println("Course Coordinated");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-25s %-10s %-23s %-22s\n",
                "Code", "Name", "Credit(s)", "Enrolled Participants", "Max Participants");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-25s %-10d %-23d %-22d\n",
                c.getCourseCode(),
                c.getCourseName(),
                c.getCredit(),
                c.getCurrentRegistered(),
                c.getMaxStudent());
        System.out.println();
    }

}
