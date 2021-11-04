package Repo;

import Uni.Course;
import Uni.IMemoryRepository;

public class CourseRepo extends IMemoryRepository<Course> {
    public CourseRepo(){
        super();
    }

    @Override
    /**
     * we are going to update the teacher that teaches the course
     */
    public Course update(Course obj) {
        for(Course c : repoList){
            if(c.getName().equals(obj.getName()))
            {
                c.setTeacher(obj.getTeacher());
                return c;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }
}
