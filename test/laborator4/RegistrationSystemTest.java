package laborator4;

import laborator4.controller.RegistrationSystem;
import laborator4.model.Course;
import laborator4.model.Student;
import laborator4.model.Teacher;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



class RegistrationSystemTest {

    Student student1 = new Student("Cristian", "Deghe", 1L);
    Student student2 = new Student("Alexandra", "Opris", 2L);

    Teacher teacher1 = new Teacher("Andreea", "Popescu", 1L);
    Teacher teacher2 = new Teacher("Madalina", "Oprea", 2L);

    Course course1 = new Course("Algebra", teacher1, 100, new ArrayList<>(), 6, 1L);
    Course course2 = new Course("Geometrie", teacher2, 0, new ArrayList<>(), 6, 2L);

    List<Course> listaKurs = Arrays.asList(course1,course2);
    List<Student> listaStudent = Arrays.asList(student1,student2);
    List<Teacher> listaTeacher= Arrays.asList(teacher1,teacher2);
    RegistrationSystem registrationSystem = new RegistrationSystem(listaKurs, listaStudent,listaTeacher);


    @Test
    void register() {

        assert(!course1.getStudentsEnrolled().contains(student1));
        assert(registrationSystem.register(course1,student1));
        assert(course1.getStudentsEnrolled().contains(student1));


        assert(!course2.getStudentsEnrolled().contains(student1));
        assert(!registrationSystem.register(course2,student1));
        assert(!course2.getStudentsEnrolled().contains(student1));

    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        assert(registrationSystem.retrieveCoursesWithFreePlaces().size()==1);

    }

    @Test
    void retrieveStudentsEnrolledForACourse() {
        registrationSystem.register(course1,student1);
        assert(registrationSystem.retrieveStudentsEnrolledForACourse(course1).size()==1);
        assert(registrationSystem.retrieveStudentsEnrolledForACourse(course2).size()==0);
    }

    @Test
    void getAllCourses() {
        assert(registrationSystem.getAllCourses().size()==2);
    }
}