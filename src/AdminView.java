import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
    private Scanner scanner;

    public AdminView() {
        this.scanner = new Scanner(System.in);
    }

    public int AdminMenu() {
        int action;
        System.out.println("Howdy Admin!");
        System.out.println("1. Display course \n2. Add course \n3. Remove course \n4. View Student \n5. View Lecturer");
        System.out.print("Enter your action >> ");
        action = scanner.nextInt();
        return action;
    }

    public int coursesToAdd() {
        System.out.print("Enter the number of course(s) to upload >> ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();
        return numCourses;
    }

    public Course addCourseView() {
        System.out.print("Course code: ");
        String code = scanner.nextLine();
        System.out.print("Course name: ");
        String name = scanner.nextLine();
        System.out.print("Course coordinator: ");
        String coordinator = scanner.nextLine();
        System.out.print("Credit hour: ");
        int credit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        Course course = new Course(code, name, capacity, credit, coordinator);
        return course;
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

    public Course courseToSearch(ArrayList<Course> courseList) {
        Course course = new Course();
        Boolean status = true;
        System.out.println("Enter the course code to delete >> ");
        String code = scanner.nextLine();

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(code)) {
                course = courseList.get(i);
                System.out.println("Course deleted!");
            }
        }
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(code)) {
                status = true;
            } else {
                status = false;
            }
        }
        if (status == false) {
            System.out.println("Course does not exist!");
        }
        return course;
    }

    public void displayStudentDetails(ArrayList<Student> studentList) {
        if (studentList.size() == 0) {
            System.out.println("No students assigned! \n");
        } else {

            System.out.println("Student Information");
            System.out.println(
                    "-----------------------------------");
            System.out.printf("%-5s %-15s %-25s\n",
                    "No.", "ID", "Name");
            System.out.println(
                    "-----------------------------------");

            for (int i = 0; i < studentList.size(); i++) {
                Student student = studentList.get(i);
                System.out.printf("%-5d %-15s %-25s\n",
                        (i + 1),
                        student.getStudentID(),
                        student.getName());
            }
        }
    }

    public void displayLecturerDetails(ArrayList<Lecturer> lecturerList) {
        if (lecturerList.size() == 0) {
            System.out.println("No lecturers assigned! \n");
        } else {

            System.out.println("Lecturer Information");
            System.out.println(
                    "-----------------------------------");
            System.out.printf("%-5s %-15s %-25s\n",
                    "No.", "ID", "Name");
            System.out.println(
                    "-----------------------------------");

            for (int i = 0; i < lecturerList.size(); i++) {
                Lecturer lecturer = lecturerList.get(i);
                System.out.printf("%-5d %-15s %-25s\n",
                        (i + 1),
                        lecturer.getLecturerID(),
                        lecturer.getName());
            }

        }
    }

}
