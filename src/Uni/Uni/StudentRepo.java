package Uni;

public class StudentRepo extends IMemoryRepository<Student>{
    public StudentRepo() {
        super();
    }

    @Override
    public Student update(Student obj) {
        Student studentToUpdate = this.repoList.stream()
                .filter(Student -> (Student.getLastname() == obj.getLastname()))
                .findFirst()
                .orElseThrow();

        studentToUpdate=obj;
        return studentToUpdate;
    }
}
