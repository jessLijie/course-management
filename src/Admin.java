public class Admin extends Person{
    private String staffID;

    public Admin() {
    }

    public Admin(String name, String staffID) {
        super(name);
        this.staffID = staffID;
    }

}
