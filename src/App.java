import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListMap;

public class App {
    private static int role, action, courseCount;
    private static String courseRoster;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        clearScreen();
        ArrayList<Course> courseList = new ArrayList<>();
        Student x = new Student();
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
                    System.out.println("1. Add course \n2. Display courses");
                    System.out.print("Enter your action >> ");
                    action = s.nextInt();
                    switch (action) {
                        case 1: {
                            clearScreen();
                            System.out.print("Enter number of courses you'd like to add >> ");
                            courseCount = s.nextInt();
                            s.nextLine();
                            for (int i = 0; i < courseCount; i++) {
                                System.out.print("Enter course code for course [" + (i + 1) + "] >> ");
                                String courseCode = s.nextLine();
                                System.out.print("Enter course name for course [" + (i + 1) + "] >> ");
                                String courseName = s.nextLine();
                                System.out.print("Enter credit(s) for course [" + (i + 1) + "] >> ");
                                int credit = s.nextInt();
                                s.nextLine();
                                System.out.println();
                                Course course = new Course(courseCode, courseName, credit);
                                courseList.add(course);
                            }
                            break;
                        }
                        case 2: {
                            clearScreen();
                            displayCourseList(courseList);
                            break;
                        }

                    }

                    break;
                }
                case 2: {
                    clearScreen();
                    System.out.println("Howdy Lecturer!");
                    System.out.println("1. View course \n2. Register Roster");
                    System.out.print("Enter your action >> ");
                    action = s.nextInt();
                    s.nextLine();
                    switch (action) {
                        case 1: {
                            clearScreen();
                            displayCourseList(courseList);
                            break;
                        }
                        case 2: {
                            clearScreen();
                            System.out.print("Enter the course code >> ");
                            courseRoster = s.nextLine();
                            boolean courseExists = false;
                            for (int i = 0; i < courseList.size(); i++) {
                                Course course = courseList.get(i);
                                if (course.getCourseCode().equals(courseRoster)) {
                                    courseExists = true;
                                    System.out.print("Enter your name >> ");
                                    String coordinator = s.nextLine();
                                    course.setCoordinator(coordinator);
                                    break; 
                                }
                            }

                            if (!courseExists) {
                                System.out.println("Course doesn't exist!");
                            }

                        }

                    }
                    break;
                }
                case 3: {
                    clearScreen();
                    System.out.println("Howdy Student!");
                    System.out.print("Enter your name >> ");
                    String sName = s.nextLine();
                    System.out.print("Enter your matrics no. >> ");
                    String sMatrics = s.nextLine();
                    x.Student2(sName,sMatrics);
                    clearScreen();
                    System.out.println("Hello "+ sName +", \n1. View Courses \n2. Register for course \n3. View Registered Courses");
                    System.out.print("Enter your action >> ");
                    action = s.nextInt();
                    s.nextLine();
                    switch(action){
                        case 1:{
                            clearScreen();
                            displayCourseList(courseList);
                            break;
                        }
                        case 2:{
                            System.out.print("Enter the course code to register >> ");
                            String register = s.nextLine();
                            boolean courseExists = false;
                            for (int i = 0; i < courseList.size(); i++) {
                                Course course = courseList.get(i);
                                if (course.getCourseCode().equals(register)) {
                                    courseExists = true;
                                    x.addCourse(courseList.get(i));
                                    break; 
                                }
                            }

                            if (!courseExists) {
                                System.out.println("Course doesn't exist!");
                            }
                            break;
                        }
                        case 3:{
                            x.displayRegisteredCourse();
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

    public static void displayCourseList(ArrayList<Course> courseList) {
        if (courseList == null || courseList.isEmpty()) {
            System.out.println("No courses has been added yet!");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Course(s) available: ");
            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println("Course [" + (i + 1) + "]");
                System.out.println("Course Code: " + course.getCourseCode());
                System.out.println("Course Name: " + course.getCourseName());
                System.out.println("Course Credit(s): " + course.getCredit());
                System.out.println("Course Coordinator: " + course.getCoordinator());
                System.out.println();
            }
        }

    }
}
