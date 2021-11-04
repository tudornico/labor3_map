package Repo;

import Uni.IMemoryRepository;
import Uni.Student;

public class StudentRepo extends IMemoryRepository<Student> {
    public StudentRepo() {
        super();
    }

    @Override
    /**
     * we update the total credits of the student
     */
    public Student update(Student obj) {
        for(Student s : repoList){
            if(s.getStudentId() == obj.getStudentId()){
                s.setTotalCredits(obj.getTotalCredits());
                return s;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }
}
