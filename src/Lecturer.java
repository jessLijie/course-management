import java.util.ArrayList;

public class Lecturer extends Person{
    ArrayList <Course> coordinatedCourse = new ArrayList<Course>();
    private String name;
    private String lecturerID;
     
    public Lecturer(String name, String lecturerID){
        super(name);
        this.lecturerID=lecturerID;
    }
}
