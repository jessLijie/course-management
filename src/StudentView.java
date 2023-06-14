import java.util.ArrayList;

public class StudentView {

    public void displayCourseDetails(ArrayList<Course>courseList){
        if(courseList.size()==0){
            System.out.println("No available course");
        }else{
            for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            System.out.println("Course [" + (i + 1) + "]");
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course Credit(s): " + course.getCredit());
            System.out.println("Course Coordinator: " + course.getCoordinator());
            System.out.println("Course's maximum student: " + course.getMaxStudent());
            System.out.println("Current enrolled student: " + course.getCurrentRegistered());
            System.out.println();
        }
        }  
    }

}
