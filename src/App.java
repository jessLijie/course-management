import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.BlockElement;

public class App {
    private static int role, action;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        clearScreen();
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();

        // StudentController sController = new
        // StudentController(studentList,courseList);
        LecturerController lController = new LecturerController(courseList, studentList);
        // AdminController aController = new AdminController(admins);

        Lecturer lecturer1 = new Lecturer("Ali", "123");
        Lecturer lecturer2 = new Lecturer("Abu", "456");
        lecturers.add(lecturer1);
        lecturers.add(lecturer2);

        AdminView adminView = new AdminView();
        StudentView studentView = new StudentView();

        System.out.println("| Course Registration System |");
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("1. Admin \n2. Lecturer \n3. Student ");
            System.out.print("Enter your role >> ");
            role = s.nextInt();
            s.nextLine();
            switch (role) {
                case 1: {
                    clearScreen();
                    System.out.println("Howdy Admin!");
                    System.out.println("1. Display course \n2. Add courses \n3. Remove course \n4. View Student");
                    System.out.print("Enter your action >> ");
                    action = s.nextInt();
                    switch (action) {
                        case 1: {
                            clearScreen();

                            // Display course
                            adminView.displayCourseDetails(courseList);

                            break;
                        }
                        case 2: {
                            clearScreen();

                            // Add courses
                            // adminView.addCourseView();
                            Course adminCourse = adminView.addCourseView();
                            courseList.add(adminCourse);

                            break;
                        }
                        case 3: {
                            clearScreen();
                            // Remove courses
                            break;
                        }
                        case 4: {
                            clearScreen();
                            // View student
                            // choose from courselist
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    clearScreen();
                    System.out.println("Howdy Lecturer!");
                    Boolean foundLec = false;
                    // verify identity
                    System.out.print("Enter your name >> ");
                    String lecturerName = s.nextLine();
                    for (int i = 0; i < lecturers.size(); i++) {
                        if (lecturerName.equals(lecturers.get(i).getName())) {
                            foundLec = true;
                        }
                    }
                    if (foundLec == true) {
                        System.out.println("1. View course \n2. Register Roster \n3. View Student List");
                        System.out.print("Enter your action >> ");
                        action = s.nextInt();
                        s.nextLine();
                        switch (action) {
                            case 1: {
                                clearScreen();
                                // View course logic
                                break;
                            }
                            case 2: {
                                clearScreen();
                                // Register Roster logic
                                lController.registerRoster(lecturerName);
                                break;
                            }
                            case 3: {
                                clearScreen();
                                // View student list
                                // Choose from registered roster
                                break;
                            }
                        }
                    } else {
                        System.out.println("Login as Lecturer Failed");
                    }
                    break;
                }
                case 3: {
                    clearScreen();
                    System.out.println("Howdy Student!");
                    System.out.println("\n1. View Courses \n2. Register for course \n3. View Registered Courses");
                    System.out.print("Enter your action >> ");
                    action = s.nextInt();
                    s.nextLine();
                    switch (action) {
                        case 1: {
                            clearScreen();
                            // View courses
                            // studentView.disp

                            break;
                        }
                        case 2: {
                            clearScreen();
                            // Register for course
                            break;
                        }
                        case 3: {
                            clearScreen();
                            // View registered courses
                            break;
                        }
                    }
                    break;
                }
                default: {
                    clearScreen();
                    System.out.println("Bye!");
                    break;
                }
            }
        } while (role == 1 || role == 2 || role == 3);

    }
}
