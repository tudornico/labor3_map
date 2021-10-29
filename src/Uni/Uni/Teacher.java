package Uni;



import java.util.List;

/**
 * class describing what a teacher is
 */
public class Teacher extends Person {
    private List<Course> courses;

    /**
     * constructor for the class teacher
     * @param courses the list of courses that one teacher teaches
     */
    public Teacher(String firstname,String lastname,List<Course> courses) {
        super(firstname,lastname);
        super.firstname=firstname;
        super.lastname=lastname;
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
