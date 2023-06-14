import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {

    private Scanner scanner;

    public AdminView(){
        this.scanner= new Scanner(System.in);
    }

    public int coursesToAdd(){
        System.out.print("Enter the number of courses to upload: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        return numCourses;
    }

    public Course addCourseView() {
        System.out.print("Course code: ");
        String code = scanner.nextLine();
        System.out.print("Course name: ");
        String name = scanner.nextLine();
        System.out.print("Course coordinator: ");
        String coordinator = scanner.nextLine();
        System.out.print("Credit hour: ");
        int credit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Course course = new Course(code, name, coordinator, capacity, credit);

        return course;
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

    
}
