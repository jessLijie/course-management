import java.util.ArrayList;

public class StudentController {

    public void registerCourse(ArrayList<Course>courseList, ArrayList<Course>registeredCourseList, ArrayList<Student>enrollStudents){
        StudentView studentView= new StudentView();

        // display available course list
        studentView.displayCourseDetails(courseList);

        //display enter course view
        String code= studentView.enterCourseView();

        //find course and return the course object
        Course course= findCourseByCode(code, courseList);

        if(course != null){
            String name= studentView.enterNameView();
            CourseController courseController= new CourseController();
            ArrayList<Student>enrolledStudents= courseController.getEnrolledStudents();

            // check the current enrolled student before adding to the list
            if(enrolledStudents.size()>= course.getMaxStudent()){
                System.out.println("Course is full. Cannot register.");
            }else{
                // add course to student bucket
                registeredCourseList.add(course);

                // add student to course bucket
                Student student= new Student(name);
                enrollStudents.add(student);
                course.setCurrentRegistered(course.getCurrentRegistered() + 1);
                System.out.println("Course registered successfully.");

            }
        }else{
            System.out.println("Invalid course code");
        }
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

    
}
