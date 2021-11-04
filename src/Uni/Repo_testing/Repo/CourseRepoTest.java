package Repo;

import Uni.Course;
import Uni.Student;
import Uni.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepoTest {


    @Test
    void create_test() {
        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);

        Course course1 = new Course("DatenBanken",t1,90,5,null);
        Course course2 = new Course("Java",t2,90,6,null);
        CourseRepo courseRepo = new CourseRepo();
        assert(courseRepo.create(course1) == course1);
        assert(courseRepo.getAll().get(0) == course1);

    }
    @Test
    void getAll_Test(){
        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);

        Course course1 = new Course("DatenBanken",t1,90,5,null);
        Course course2 = new Course("Java",t2,90,6,null);
        CourseRepo courseRepo = new CourseRepo();
        courseRepo.create(course1);
        courseRepo.create(course2);
        List<Course> test_list =  new ArrayList<Course>();
        test_list.add(course1);
        test_list.add(course2);
        assert(courseRepo.getAll().equals(test_list));
    }

    @Test
    void delete_Test(){
        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);

        Course course1 = new Course("DatenBanken",t1,90,5,null);
        Course course2 = new Course("Java",t2,90,6,null);
        CourseRepo courseRepo = new CourseRepo();
        courseRepo.create(course1);
        courseRepo.delete(course1);
        List<Course> testing_list = new ArrayList<>();
        assert(courseRepo.getAll().isEmpty());
    }

    @Test
    void update_Test(){
        Teacher t1 =new Teacher("Diana","Cristea",null);
        Teacher t2 =new Teacher("Popescu","Ioan",null);

        Course course1 = new Course("DatenBanken",t1,90,5,null);
        Course course2 = new Course("Java",t2,90,6,null);
        CourseRepo courseRepo = new CourseRepo();
        courseRepo.create(course1);
        Student s = new Student("Tudor","Nicolaescu",349,60,null);
        List<Student> studentList =  new ArrayList<>();
        studentList.add(s);
        Course testCourse =  new Course("DatenBanken",t2,90,5,studentList);
        courseRepo.update(testCourse);
        assert(courseRepo.getAll().get(0).getTeacher() == t2);
    }

}