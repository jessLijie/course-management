import java.util.ArrayList;

public class LecturerController {
    Lecturer lecturer;
    LecturerView lecturerView;
    ArrayList<Course> courseList;
    ArrayList<Student> studentList;

    public LecturerController(ArrayList<Course> courseList, ArrayList<Student> studentList)
    {
        this.lecturerView = new LecturerView();
        this.lecturer = new Lecturer();
        this.courseList = courseList;
        this.studentList = studentList;
    }

    public String readLecturerName()
    {
        return lecturer.getName();
    }

    public void registerRoster(String name)
    {
        int index = 0;
        boolean foundCourse = false;
        String register = lecturerView.readCourse();
        System.out.println(register);
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getCourseCode().equals(register)) {
                index = i;
                foundCourse = true;
            }
        }
        if (foundCourse==true){
            this.courseList.get(index).setCoordinator(name);
        }else{
            System.out.println("Course not found");
        }
    }

    //view lecturer registered course
    
    public void viewStudentList(ArrayList<Student> studentList)
    {
        for (int i = 0; i < studentList.size(); i++)
        {
            lecturerView.displayStudentList(studentList.get(i));
        }
    }


}
