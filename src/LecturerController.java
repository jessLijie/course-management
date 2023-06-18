import java.io.IOException;
import java.util.ArrayList;

public class LecturerController {
    Lecturer lecturer;
    LecturerView lecturerView;
    ArrayList<Course> courseList;
    ArrayList<Student> studentList;

    public LecturerController(ArrayList<Student> studentList, ArrayList<Course> courseList) {
        this.lecturerView = new LecturerView();
        this.lecturer = new Lecturer();
        this.courseList = courseList;
        this.studentList = studentList;
    }

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

    public void lecturerAction(ArrayList<Lecturer> lecturers) {
        int action;
        do {
            action = lecturerView.LecturerMenu(lecturers);
            ClearScreen();
            switch (action) {
                case 1: {
                    // view coordinated course
                    viewCoordinatedCourse(lecturerView.getCurrentLecturer().getName());
                    break;
                }
                case 2: {
                    // register roster
                    lecturerView.displayCourseDetails(courseList);
                    if (courseList.size() != 0) {
                        registerRoster(lecturerView.getCurrentLecturer().getName());
                    }
                    break;
                }
                case 3: {
                    // view student of coordinated course
                    viewCoordinatedCourse(lecturerView.getCurrentLecturer().getName());
                    break;

                }
                default: {
                    System.out.println("Invalid option :(");
                    break;
                }
            }

        } while (action > 0 && action < 4);
    }

    public void viewCoordinatedCourse(String lecturerName) {
        boolean foundRegisteredCourse = false;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCoordinator().equals(lecturerName)) {
                lecturerView.displayCoordinatedCourse(courseList.get(i));
                foundRegisteredCourse = true;
            }
        }
        if (foundRegisteredCourse == false) {
            System.out.println("No course registered");
        }
    }

    public void registerRoster(String name) {
        int index = 0;
        boolean foundCourse = false;
        String register = lecturerView.readCourse();
        System.out.println(register);
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(register)) {
                index = i;
                foundCourse = true;
            }
        }
        if (foundCourse == true) {
            this.courseList.get(index).setCoordinator(name);
            lecturerView.getCurrentLecturer().getCoordinatedCourse().add(this.courseList.get(index));
        } else {
            System.out.println("Course not found");
        }
    }
}
