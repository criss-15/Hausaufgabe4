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

    public Course findOneCourse(Long id){return courseRepository.findOne(id);} //returneaqza cursul cu id-ul dat
    public Student findOneStudent(Long id){return studentRepository.findOne(id);} //returneaqza studentul cu id-ul dat

    public Course deleteCourse(Long idK){ //sterge cursul cu Id-ul dat
        return courseRepository.delete(idK);
    }

    public List<Course> getCourseListTeacher(Long id){return teacherRepository.findOne(id).getCourses();} //returneaza cursurile unui profesor


    /**
     * Sort courses list by name.
     *
     * @return the list
     */
    public List<Course> sortCourse(){ //sorteaza cursurile dupa nume, iar daca au numele la fel, le sorteaza dupa nr de locuri libere
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
     * Filter course list.
     *
     * @return the list with the courses that have less than 6 credits
     */
    public List<Course> filterCourse(){ //afiseaza cursurile cu mai putin de 6 credite
        List<Course> courses=new ArrayList<>(courseRepository.findAll());
        courses = courses.stream()
                .filter( (Course course) ->
                        course.getCredits() < 6)
                .collect(Collectors.toList());
        return courses;
    }



    /**
     * Sort studenten list by firstname or lastname.
     *
     * @return the list
     */
    public List<Student> sortStudenten(){ //sorteaza cursurile dupa nume, iar daca au numele la fel, le sorteaza dupa prenume
        List<Student> studentList=new ArrayList<>(studentRepository.findAll());

        studentList.sort( (Student studentsList1, Student studentsList2) ->
        {

            if (studentsList1.getFirstName().compareTo(studentsList2.getFirstName()) > 0)
                return studentsList1.getFirstName().compareTo(studentsList2.getFirstName());
            return studentsList1.getLastName().compareTo(studentsList2.getLastName());
        } );


        return studentList;
    }


    /**
     * Filter students list.
     *
     * @return the list with students that have more than 6 credits
     */
    public List<Student> filterStudents(){
        List<Student> studentsList=new ArrayList<>(studentRepository.findAll());
        studentsList = studentsList.stream()
                .filter( (Student student) ->
                        student.getTotalCredits() <20)
                .collect(Collectors.toList());
        return studentsList;
    }


}

