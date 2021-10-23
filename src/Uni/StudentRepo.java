package Uni;

public class StudentRepo<Student> extends IMemoryRepository<Student>{
    @Override
    public Student update(Student obj) {
        Student studentToUpdate = this.repoList.stream()
                .filter(Student -> ())
    }
}
