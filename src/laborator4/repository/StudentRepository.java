package laborator4.repository;

import laborator4.model.Student;

import java.util.List;

public class StudentRepository extends InMemoryRepository<Student>{


    List<Student> studentList;

    @Override
    public String toString() {
        return "StudentRepository{" +
                "studentList=" + studentList +
                '}';
    }
    public StudentRepository(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }



    public Student findOne(Long id) {
        for( Student student :  studentList)
            if(student.getStudentID().equals(id))
                return student;
        return null;
    }


    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student create(Student entity) {
        if(!studentList.contains(entity)) {
            studentList.add(entity);
            return null;
        }
        return entity;
    }


    public Student delete(Long id) {
        Student student = findOne(id);
        if(student==null) {
            return null;
        }
        studentList.remove(student);
        return student;
    }


    @Override
    public Student update(Student entity) {
        long id= entity.getStudentID();
        if(findOne(id)!=null){
            studentList.set(studentList.indexOf(findOne(id)),entity);
            return null;
        }
        return entity;
    }


}
