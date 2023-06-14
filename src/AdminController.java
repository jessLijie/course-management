import java.util.ArrayList;

public class AdminController {
    AdminView adminView;
    ArrayList<Course>courseList;


    public AdminController(ArrayList<Course>courseList){
        this.courseList= courseList;
        adminView = new AdminView();
    }

    public void addCourse(){
        int amount = adminView.coursesToAdd();
        for(int i=0;i<amount;i++){
            System.out.println("Course ["+(i+1)+"]");
            Course course= adminView.addCourseView();
            courseList.add(course);
        }

    }
    public void deleteCourse(){
        Course courseToDelete=adminView.courseToSearch(courseList);
         if(courseList.size()==0){
             System.out.println("No course assigned yet");
        }
        else{
            courseList.remove(courseToDelete);
           
         }
    }





}
