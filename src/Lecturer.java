import java.util.ArrayList;

public class Lecturer extends Person {
    private String lecturerID;
    ArrayList <Course> coordinatedCourse = new ArrayList<Course>(); 

    public Lecturer() {}
    public Lecturer(String name, String lecturerID) {
        super(name);
        this.lecturerID = lecturerID;
        this.coordinatedCourse = new ArrayList<Course>();
    }
    public String getLecturerID() {
        return lecturerID;
    }

    public String getName(){
        return super.getName();
    }
    public ArrayList<Course> getCoordinatedCourse() {
        return coordinatedCourse;
    }
    
}
