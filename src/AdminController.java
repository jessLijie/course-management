import java.util.ArrayList;

public class AdminController {
    ArrayList<Course>courseList;
    AdminView adminView;

    public AdminController(ArrayList<Course> courseList){
        this.courseList= courseList;
        adminView= new AdminView();
    }

    public void addCourse(){
        int amount= adminView.coursesToAdd();
        for(int i=0; i<amount; i++){
            System.out.println("Courses [" + (i+1) + "]");
            Course course= adminView.addCourseView();
            courseList.add(course);
        }
    }



}
