import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {

    private Scanner scanner;

    public StudentView(){
        this.scanner= new Scanner(System.in);
    }

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

    public String enterCourseView(){
        System.out.print("Enter the course code to register: ");
        String code= scanner.nextLine();

        return code;      
    }

    public String enterNameView(){
        System.out.print("Enter your name: ");
        String name= scanner.nextLine();

        return name;      
    }



    public void displayRegisteredCourse(ArrayList<Course>courseList){
        if(courseList.size()==0){
            System.out.println("No course is registered");
        }else{
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
