package Repo;

import Uni.IMemoryRepository;
import Uni.Teacher;

public class TeacherRepo extends IMemoryRepository<Teacher> {
    public TeacherRepo(){
        super();
    }
    @Override
    /**
     * we update the course list from the teacher
     */
    public Teacher update(Teacher obj) {
        for(Teacher T : repoList){
            if( T.getFirstname().equals(obj.getFirstname()) && T.getLastname().equals(obj.getLastname()))
            {
                T.setCourses(obj.getCourses());
                return T;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }
}
