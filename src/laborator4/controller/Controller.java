package laborator4.controller;


import laborator4.model.Course;
import laborator4.model.Student;
import laborator4.model.Teacher;
import laborator4.repository.CourseRepository;
import laborator4.repository.StudentRepository;
import laborator4.repository.TeacherRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    CourseRepository courseRepository;
    StudentRepository studentRepository;
    TeacherRepository teacherRepository;

    public Controller(CourseRepository courseRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {



        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;

    }

    public List<Student> getAllStudents(){return studentRepository.findAll();} //returneaza toti studentii
    public List<Course> getAllCourses(){return courseRepository.findAll();} //returneaza toate cursurile
    public List<Teacher> getAllTeachers(){return teacherRepository.findAll();} //returneaza toti profesorii

    public Course findOneKurs(Long id){return courseRepository.findOne(id);} //returneaqza cursul cu id-ul dat
    public Student findOneStudent(Long id){return studentRepository.findOne(id);} //returneaqza studentul cu id-ul dat

    public Course deleteCourse(Long idK){ //sterge cursul cu Id-ul dat
        return courseRepository.delete(idK);
    }

    public List<Course> getKursListTeacher(Long id){return teacherRepository.findOne(id).getCourses();} //returneaza cursurile unui profesor


    /**
     * Sort courses list by name.
     *
     * @return the list
     */
    public List<Course> sortKurs(){ //sorteaza cursurile dupa nume, iar daca au numele la fel, le sorteaza dupa nr de locuri libere
        List<Course> courseList=new ArrayList<>(courseRepository.findAll());

        courseList.sort( (Course courseList1, Course courseList2) ->
        {

            if (courseList1.getName().compareTo(courseList2.getName()) == 0)
                return courseList1.getMaxEnrollment()-courseList1.getStudentsEnrolled().size()-courseList2.getMaxEnrollment()-courseList2.getStudentsEnrolled().size();
            return courseList1.getName().compareTo(courseList2.getName());
        } );


    return courseList;
    }




    /**
     * Filter kurs list.
     *
     * @return the list
     */
    public List<Course> filterKurs(){ //afiseaza cursurile cu locuri libere
        List<Course> courses=new ArrayList<>(courseRepository.findAll());
        courses = courses.stream()
                .filter( (Course course) ->
                        course.getMaxEnrollment()-course.getStudentsEnrolled().size()>0)
                .collect(Collectors.toList());
        return courses;
    }

//    public List<Student> sortStudenten(){ //sorteaza cursurile dupa nume, iar daca au numele la fel, le sorteaza dupa nr de locuri libere
//        List<Course> studentList=new ArrayList<>(studentRepository.findAll());
//
//        studentList.sort( (Student studentsList1, Student studentsList2) ->
//        {
//
//            if (courseList1.getName().compareTo(courseList2.getName()) == 0)
//                return courseList1.getMaxEnrollment()-courseList1.getStudentsEnrolled().size()-courseList2.getMaxEnrollment()-courseList2.getStudentsEnrolled().size();
//            return courseList1.getName().compareTo(courseList2.getName());
//        } );
//
//
//        return studentList;
//    }


}

