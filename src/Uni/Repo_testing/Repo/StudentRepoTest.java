package Repo;

import Uni.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {

    @Test
    void create_Test(){
        Student student1 = new Student("Tudor", "Nicolaescu",349,60,null);
        Student student2 = new Student("Francisc","Tulici",355,60,null);
        Student student3 = new Student("Calin","Pop",123,60,null);
        StudentRepo studentRepo = new StudentRepo();
        assert(studentRepo.create(student1) == student1);
        assert(studentRepo.create(student2) == student2);
    }

    @Test
    void getAll_Test(){
        Student student1 = new Student("Tudor", "Nicolaescu",349,60,null);
        Student student2 = new Student("Francisc","Tulici",355,60,null);
        Student student3 = new Student("Calin","Pop",123,60,null);
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.create(student1);
        studentRepo.create(student2);
        List<Student> test_list = new ArrayList<>();
        test_list.add(student1);
        test_list.add(student2);
        assert(studentRepo.getAll().equals(test_list));
    }

    @Test
    void delete_Test(){
        Student student1 = new Student("Tudor", "Nicolaescu",349,60,null);
        Student student2 = new Student("Francisc","Tulici",355,60,null);
        Student student3 = new Student("Calin","Pop",123,60,null);

        StudentRepo studentRepo = new StudentRepo();
        studentRepo.create(student1);
        studentRepo.delete(student1);
        assert(studentRepo.getAll().isEmpty());
    }

    @Test
    void update_Test(){
        Student student1 = new Student("Tudor", "Nicolaescu",349,60,null);
        Student student2 = new Student("Francisc","Tulici",355,60,null);
        Student student3 = new Student("Calin","Pop",123,60,null);

        StudentRepo studentRepo = new StudentRepo();
        studentRepo.create(student1);
        student1.setTotalCredits(50);
        studentRepo.update(student1);
        assertEquals(studentRepo.getAll().get(0).getTotalCredits(),50);


    }

}