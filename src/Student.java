import java.util.ArrayList;

public class Student extends Person{
    ArrayList <Course> courseRegistered = new ArrayList<Course>();
    private String name;
    private String matricsNo;

    public Student(String name, String matricsNo){
        super(name);
        this.matricsNo = matricsNo; 
    }

    public Student(String name){
        super(name);
    }

    public void addCourse(Course course){
        courseRegistered.add(course);
    }

    public void displayRegisteredCourse(){
        if(courseRegistered.size()==0){
            System.out.println("No registered course");
        }else{
            for (int i = 0; i < courseRegistered.size(); i++) {
            Course course = courseRegistered.get(i);
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
