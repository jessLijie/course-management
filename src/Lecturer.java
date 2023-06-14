import java.util.ArrayList;

public class Lecturer extends Person{
    ArrayList <Course> coordinatedCourse = new ArrayList<Course>();
    private String lecturerID;
     
    public Lecturer(){}
    public Lecturer(String name, String lecturerID){
        super(name);
        this.lecturerID=lecturerID;
    }

    
    public String getName()
    {
        return super.getName();
    }
}
