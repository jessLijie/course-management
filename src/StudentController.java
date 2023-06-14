import java.util.ArrayList;

public class StudentController {

    private String code;
    Course course;

    public void registerCourse(ArrayList<Course>courseList, ArrayList<Course>registeredCourseList){
        StudentView studentView= new StudentView();

        // display available course list
        studentView.displayCourseDetails(courseList);

        //display enter course view
        code= studentView.enterCourseView();

        //find course and return the course object
        course= findCourseByCode(code, courseList);

        if(course != null){
            // add course to student bucket
            registeredCourseList.add(course);
        }else{
            
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
