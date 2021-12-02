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



    /**
     * Find one student.
     *
     * @param id the id
     * @return the student
     */
    public Student findOne(Long id) {
        for( Student student :  studentList)
            if(student.getStudentID().equals(id))
                return student;
        return null;
    }


    /**
     * Find all list.
     *
     * @return the list
     */
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


    /**
     * Delete student.
     *
     * @param id the id
     * @return the student
     */
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
