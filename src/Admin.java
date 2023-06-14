import java.util.ArrayList;

public class Admin extends Person{
    private ArrayList<Course> courseList;
    private String name;
    private String staffID;

    public Admin(String name, String staffID) {
        super(name);
        this.staffID=staffID;
    }

    public String getName() {
        return name;
    }

    public String getStaffID() {
        return staffID;
    }
    
    public ArrayList<Course> getCourseList() {
        return courseList;
    }
    
    
}
