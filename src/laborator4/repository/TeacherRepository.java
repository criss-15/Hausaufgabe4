package laborator4.repository;


import laborator4.model.Teacher;

import java.util.List;

public class TeacherRepository extends InMemoryRepository<Teacher>{

    private List<Teacher> teacherList;

    public TeacherRepository(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }


    public Teacher findOne(Long id) {
        for( Teacher teacher :  teacherList)
            if(teacher.getId().equals(id))
                return teacher;
        return null;
    }


    public List<Teacher> findAll() {
        return teacherList;
    }

    @Override
    public Teacher create(Teacher entity) {
        if(!teacherList.contains(entity)) {
            teacherList.add(entity);
            return null;
        }
        return entity;
    }


    public Teacher delete(Long id) {
        Teacher teacher = findOne(id);
        if(teacher==null) {
            return null;
        }
        teacherList.remove(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher entity) {
        long id = entity.getId();
        if(findOne(id)!=null){
            teacherList.set(teacherList.indexOf(findOne(id)), entity);
            return null;
        }
        return entity;
    }
}
