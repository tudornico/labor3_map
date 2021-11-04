package Uni_Testing;

import Repo.CourseRepo;
import Repo.StudentRepo;
import Repo.TeacherRepo;
import Uni.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public  class RegistrationSystemTest {
    private RegistrationSystem test;

    public RegistrationSystemTest() {

    }


    @Before
    public void population(){

        //creating students with null list of courses
        Student student1 = new Student("Tudor", "Nicolaescu",349,60,null);
        Student student2 = new Student("Francisc","Tulici",355,60,null);
        Student student3 = new Student("Calin","Pop",123,60,null);

        //creating teachers with null list of courses

        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);

        //creating courses with null list of stundets

        Course course1 = new Course("DatenBanken",t1,90,5,null);
        Course course2 = new Course("Java",t2,90,6,null);

        //inserting courses in each student
        List<Course> courseList  = new ArrayList<>();
        courseList.add(course1);
        student1.setEnrolledCourses(courseList); // student 1 has just 1 course
        courseList.add(course2);
        student2.setEnrolledCourses(courseList); // the others have both courses
        student3.setEnrolledCourses(courseList);


        //inserting students into studentrepo
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.create(student1);
        studentRepo.create(student2);
        studentRepo.create(student3);
        this.test.setStudentRepo(studentRepo); // putting into the register system variable in the test class

        //inserting courses in teachers

        courseList.clear();
        courseList.add(course1);
        t1.setCourses(courseList); // first teacher teaches only the first course
        courseList.add(course2);
        t2.setCourses(courseList); // the second has all

        //inserting taechers into teacherrepo
        TeacherRepo teacherRepo =new TeacherRepo();
        teacherRepo.create(t1);
        teacherRepo.create(t2);
        this.test.setTeacherRepo(teacherRepo);

        // inserting students in courses
        List<Student> studentList = new ArrayList<>();
        studentList.add(student2);
        studentList.add(student3); // selected student 2 and 3 for the second course
        course2.setStudentsEnrolled(studentList);
        studentList.add(student1); // everyone is enlisted in the first course
        course1.setStudentsEnrolled(studentList);

        // inserting course in courseRepo

        CourseRepo courseRepo = new CourseRepo();
        courseRepo.create(course1);
        courseRepo.create(course2);
        this.test.setCourseRepo(courseRepo);

    }


    @Test
    void register() {
        Course c1 = this.test.getCourseRepo().getAll().get(1); // course1 from population

        Student student1 = this.test.getStudentRepo().getAll().get(0);
        Student student2 = this.test.getStudentRepo().getAll().get(1);

        assert(!this.test.register(c1, student1));
        assert(this.test.register(c1,student2));

    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        assertEquals(this.test.retrieveCoursesWithFreePlaces(),this.test.getCourseRepo().getAll());
    }

    @Test
    void retrieveStudentsEnrolledforaCourse() {
        Course c1 = this.test.getCourseRepo().getAll().get(1);
        assertEquals(this.test.retrieveStudentsEnrolledforaCourse(c1),this.test.getStudentRepo().getAll());
    }

    @Test
    void getAllCourses() {
        assertEquals(this.test.getAllCourses(),this.test.getCourseRepo().getAll());
    }
}