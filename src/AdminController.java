import java.io.IOException;
import java.util.ArrayList;

public class AdminController {
    AdminView adminView;
    private ArrayList<Course> courseList;
    private ArrayList<Student> studentList;
    private ArrayList<Lecturer> lecturerList;

    public AdminController(ArrayList<Lecturer> lecturerList, ArrayList<Student> studentList,
            ArrayList<Course> courseList) {
        this.courseList = courseList;
        this.studentList = studentList;
        this.lecturerList = lecturerList;
        adminView = new AdminView();
    }
    public void ClearScreen(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime();
        } catch (IOException | InterruptedException ex) {}
    }

    public void adminAction() {
        int action = adminView.AdminMenu();
        ClearScreen();
        switch (action) {
            case 1: {
                // display course
                adminView.displayCourseDetails(courseList);
                break;
            }
            case 2: {
                // add course
                addCourse();
                break;
            }
            case 3: {
                // remove course
                deleteCourse();
                break;
            }
            case 4: {
                // view student
                adminView.displayStudentDetails(studentList);
                break;
            }
            case 5:{
                //view lecturer
                adminView.displayLecturerDetails(lecturerList);
            }
            default: {
                System.out.println("Invalid option :(");
                break;
            }
        }
    }

    public void addCourse() {
        int amount = adminView.coursesToAdd();
        for (int i = 0; i < amount; i++) {
            System.out.println("Course [" + (i + 1) + "]");
            Course course = adminView.addCourseView();
            courseList.add(course);
            System.out.println();
        }

    }

    public void deleteCourse() {
        Course courseToDelete = adminView.courseToSearch(courseList);
        if (courseList.size() == 0) {
            System.out.println("No course assigned yet");
            
        } else {
            courseList.remove(courseToDelete);
        }
    }

}
