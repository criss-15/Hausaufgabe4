package laborator4.ui;

import laborator4.controller.RegistrationSystem;
import laborator4.model.Course;
import laborator4.model.Student;
import laborator4.model.Teacher;
import laborator4.repository.TeacherRepository;
import laborator4.utility.Reader;

import java.util.ArrayList;

import java.util.List;

/**
 * lab3.Main class where program starts.
 */
public class StartApp {

    /**
     * Start point of the application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start point");
        List<Student> studentList=new ArrayList<>();
        List<Course> courseList=new ArrayList<>();
        List<Teacher> teacherList=new ArrayList<>();
        List<List<String>> listStudents = Reader.readFile("src/laborator4/Studenti");
        List<List<String>> listCourse = Reader.readFile("src/laborator4/Cursuri");
        List<List<String>> listTeacher = Reader.readFile("src/laborator4/Profesori");


        for(List<String> line: listTeacher) {
            Teacher teacher = new Teacher(line.get(0), line.get(1), Long.parseLong(line.get(2)));
            teacherList.add(teacher);
        }

        TeacherRepository teacherRepository = new TeacherRepository(teacherList);
        for(List<String> line: listCourse) {
            Teacher teacher = teacherRepository.findOne(Long.parseLong(line.get(1)));
            Course course = new Course(line.get(0), teacher, Integer.parseInt(line.get(2)), new ArrayList<>(), Integer.parseInt(line.get(3)), Long.parseLong(line.get(4)));
            courseList.add(course);

        }

        for(List<String> line: listStudents) {
           Student student= new Student(line.get(0), line.get(1), Long.parseLong(line.get(2)));
            studentList.add(student);
        }



        RegistrationSystem registrationSystem = new RegistrationSystem(courseList, studentList,teacherList);
        Menu menu=new Menu(registrationSystem);
        menu.run();
    }
}
