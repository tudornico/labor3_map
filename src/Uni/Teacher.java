package Uni;



import java.util.List;

public class Teacher extends Person {
    private List<Course> courses;

    public Teacher(List<Course> courses) {
        this.courses = courses;
    }
}
