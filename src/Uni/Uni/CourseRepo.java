package Uni;

public class CourseRepo extends IMemoryRepository<Course> {
    CourseRepo(){
        super();
    }

    @Override
    public Course update(Course obj) {
        Course CoursetoUpdate = this.repoList.stream()
                .filter(Course -> (Course.getName() == obj.getName()))
                .findFirst()
                .orElseThrow();

        CoursetoUpdate = obj;
        return CoursetoUpdate;
    }
}
