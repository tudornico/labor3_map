package Repo;

import Uni.Course;
import Uni.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherRepoTest {

    @Test
    void create(){
        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);
        TeacherRepo teacherRepo = new TeacherRepo();
        assert(teacherRepo.create(t1) == t1);
        assert(teacherRepo.getAll().get(0) == t1);
    }
    @Test
    void getAll(){
        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);
        TeacherRepo teacherRepo =  new TeacherRepo();
        teacherRepo.create(t1);
        teacherRepo.create(t2);
        assert(teacherRepo.getAll().get(0) == t1);
        assert(teacherRepo.getAll().get(1) == t2);
    }
    @Test
    void update() {
        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);

        Course course1 = new Course("DatenBanken",t1,90,5,null);
        Course course2 = new Course("Java",t2,90,6,null);
        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        t1.setCourses(courseList);
        courseList.add(course2);

        TeacherRepo teacherRepo = new TeacherRepo();
        teacherRepo.create(t1);

        t1.setCourses(courseList);
        teacherRepo.update(t1);
        assert(teacherRepo.getAll().get(0).getCourses() == t1.getCourses() );

    }

    @Test
    void delete(){
        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);
        TeacherRepo teacherRepo = new TeacherRepo();
        teacherRepo.create(t1);
        teacherRepo.delete(t1);
        assert(teacherRepo.getAll().isEmpty());

    }
}