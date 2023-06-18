import java.io.IOException;
import java.util.ArrayList;

public class StudentController {
    Student student;
    StudentView studentView;
    ArrayList<Course> registeredCourses; 
    ArrayList<Course> courseList;

    public StudentController(ArrayList<Course>courses){
        this.courseList = courses;
        registeredCourses = new ArrayList<Course>();
        this.student = new Student();
        this.studentView = new StudentView();
    }

    public void ClearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime();
        } catch (IOException | InterruptedException ex) {
        }
    }

    public void studentAction(ArrayList<Student>students){
        int action;
        do {
            action = studentView.StudentMenu(students);
            ClearScreen();
            switch (action) {
                case 1: {
                    // Register for course
                    studentView.displayCourseDetails(courseList);
                    registerCourse(courseList);
                    break;
                }
                case 2: {
                    // View registered courses
                    studentView.displayRegisteredCourse(registeredCourses);
                    break;
                }
                default: {
                    System.out.println("Invalid option :(");
                    break;
                }
            }

        } while (action > 0 && action < 3);
    }

    private Course findCourseByCode(String code,ArrayList<Course>courseList) {

        // the current course object is assigned to the list of object of cousrses
        for (Course course : courseList) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    
    public void registerCourse(ArrayList<Course>courseList){
        student = studentView.getCurrentStudent();
        if(courseList.size()!=0){
        //display enter course view
        String code= studentView.enterCourseView();

        //find course and return the course object
        Course course= findCourseByCode(code, courseList);

        if(course != null){
            Course courseControl= new Course();
            ArrayList<Student>enrolledStudents= courseControl.getEnrolledStudents();

            // check the current enrolled student before adding to the list
            if(enrolledStudents.size()>= course.getMaxStudent()){
                System.out.println("Course is full. Cannot register.");
            }else{
                // add course to student bucket
                student.getEnrolledCourse().add(course);

                // Add course to registeredCourses list
                registeredCourses.add(course);

                // add student to course bucket
                // enrollStudents.add(studentView.getCurrentStudent());
                course.setCurrentRegistered(course.getCurrentRegistered() + 1);
                System.out.println("Course registered successfully.");

            }
        }else{
            System.out.println("Invalid course code");
        }
        }
    }
}
