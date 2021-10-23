package Uni;

import javax.swing.*;

public class TeacherRepo extends IMemoryRepository<Teacher>{
    public TeacherRepo(){
        super();
    }
    @Override
    public Teacher update(Teacher obj) {
        Teacher teachertoUpdate = this.repoList.stream()
                .filter(Teacher -> (Teacher.getLastname() == obj.getLastname() && Teacher.getFirstname() == obj.getFirstname()))
                .findFirst()
                .orElseThrow();

            teachertoUpdate.setLastname(obj.getLastname());
            teachertoUpdate.setFirstname(obj.getFirstname());
            return teachertoUpdate;
    }
}
