package laborator4.controller;

import laborator4.model.Course;
import laborator4.model.Student;
import laborator4.model.Teacher;
import laborator4.repository.CourseRepository;
import laborator4.repository.StudentRepository;
import laborator4.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

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


    public boolean register(Course k, Student s) {
        if(k.getMaxEnrollment() - k.getStudentsEnrolled().size()>=1){       // daca nr maxim de studenti inscrisi la un curs nu a fost atins inca atunci:
            if(s.getTotalCredits() + k.getCredits()<=30){  // daca nr actual de credite al studentului + nr de credite al cursului de adaugat in lista sa de cursuri nu depaseste 30

                List<Course> temp = s.getEnrolledCourses();
                temp.add(k);

                List<Student> aux=k.getStudentsEnrolled();
                aux.add(s);

                courseRepository.update(k);
                studentRepository.update(s);

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

    public List<Course> retrieveCoursesWithFreePlaces(){
        List<Course> temp=new ArrayList<>();
        for (Course k: courseRepository.findAll()) {
            if(k.getMaxEnrollment()-k.getStudentsEnrolled().size()>=1)
                temp.add(k);
        }
        return temp;
    }

    public List<Student> retrieveStudentsEnrolledForACourse(Course k){
        return k.getStudentsEnrolled();

    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();

    }



}
