package Uni;

import java.util.ArrayList;
import java.util.List;

/**
 * the main app that defines the actions one University database needs
 */
public class RegistrationSystem {
   private CourseRepo courseRepo;
   private TeacherRepo teacherRepo;
   private StudentRepo studentRepo;

    public CourseRepo getCourseRepo() {
        return courseRepo;
    }

    public void setCourseRepo(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public TeacherRepo getTeacherRepo() {
        return teacherRepo;
    }

    public void setTeacherRepo(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    /**
     * we will create the data base for the students courses and teachers
     * @param courseRepo the repository of courses which contains all the courses
     * @param teacherRepo the repository for teachers which contains all the teachers
     * @param studentRepo the repository for students which contains all students
     */
    public RegistrationSystem(CourseRepo courseRepo,TeacherRepo teacherRepo,StudentRepo studentRepo)
    {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
    }

    /**
     * method that registers a student to a course
     * @param course the couse that one student need to be added to
     * @param student the student that will be attending the course
     * @return the true or false whether the student is enrolled or not
     */
    public boolean register(Course course , Student student){
        for(int i = 0 ;i<course.getStudentsEnrolled().size();i++){
            if(course.getStudentsEnrolled().get(i) == student )
                return true;
        }
        course.getStudentsEnrolled().add(student);
        return false;

    }

    /**
     * a method that shows all the courses that has free places
     * @return a list of courses that have free places
     */
    public List<Course> retrieveCoursesWithFreePlaces(){
        List<Course> available_courses = new ArrayList<>();
        for(int i =0;i<courseRepo.getAll().size();i++){
            if(courseRepo.getAll().get(i).getStudentsEnrolled().size()<courseRepo.getAll().get(i).getMaxEnrollment()){
                available_courses.add(courseRepo.getAll().get(i));
            }
        }
        return available_courses;
    }

    /**
     * method that shows all the students that are enrolled in a course
     * @param course the course in question
     * @return a list of students that meet the criteria
     */
    public List<Student> retrieveStudentsEnrolledforaCourse(Course course){

        return course.getStudentsEnrolled();
    }

    /**
     * method that shows all the courses
     * @return a list of courses
     */
    public List<Course> getAllCourses(){
        return this.courseRepo.getAll();
    }
}
