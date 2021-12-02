package laborator4.controller;

import laborator4.model.Course;
import laborator4.model.Student;
import laborator4.model.Teacher;
import laborator4.repository.CourseRepository;
import laborator4.repository.StudentRepository;
import laborator4.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Registration system.
 */
public class RegistrationSystem {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public RegistrationSystem(List<Course> courseList, List<Student> studentList, List<Teacher> teacherList){
        this.courseRepository = new CourseRepository(courseList);
        this.studentRepository = new StudentRepository(studentList);
        this.teacherRepository =new TeacherRepository(teacherList);

        controller =new Controller(this.courseRepository, this.studentRepository, this.teacherRepository);
    }


    /**
     * Register boolean.
     * students register to course
     *
     * @param course  the course
     * @param student the student
     * @return the boolean
     */
    public boolean register(Course course, Student student) {
        if(course.getMaxEnrollment() - course.getStudentsEnrolled().size()>=1){       // daca nr maxim de studenti inscrisi la un curs nu a fost atins inca atunci:
            if(student.getTotalCredits() + course.getCredits()<=30){  // daca nr actual de credite al studentului + nr de credite al cursului de adaugat in lista sa de cursuri nu depaseste 30

                List<Course> courses = student.getEnrolledCourses();
                courses.add(course);

                List<Student> studentList=course.getStudentsEnrolled();
                studentList.add(student);

                courseRepository.update(course);
                studentRepository.update(student);

                return true;
            }
            else{
                System.out.println("To many credits!");
                return false;
            }

        }
        else{
            System.out.println("No!");
            return false;
        }


    }


    /**
     * Retrieve courses with free places list.
     *
     * @return the list
     */
    public List<Course> retrieveCoursesWithFreePlaces(){
        List<Course> temp=new ArrayList<>();
        for (Course k: courseRepository.findAll()) {
            if(k.getMaxEnrollment()-k.getStudentsEnrolled().size()>=1)
                temp.add(k);
        }
        return temp;
    }


    /**
     * Retrieve students enrolled for a course list.
     *
     * @param course the course
     * @return the list
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        return course.getStudentsEnrolled();

    }

    /**
     * Get all courses list.
     *
     * @return the list
     */
    public List<Course> getAllCourses(){
        return courseRepository.findAll();

    }



}
