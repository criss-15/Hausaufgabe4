package laborator4.model;

import java.util.List;


public class Course {

    private String name;
    private Teacher teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;
    private Long id;


    public Course(String name, Teacher teacher, int maxNoStudents, List<Student> enrolledStudents, int noCredits, long id) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxNoStudents;
        this.studentsEnrolled = enrolledStudents;
        this.credits = noCredits;
        this.id=id;


        List<Course> aux = this.teacher.getCourses();
        aux.add(this);
        this.teacher.setCourses(aux);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Kurs{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher.getFirstName() + " " + teacher.getLastName() + ", KursNr=" +teacher.getCourses().size() +
                ", maxNoStudents=" + maxEnrollment +
                ", NrenrolledStudents=" + studentsEnrolled.size() +
                ", noCredits=" + credits +
                ", id=" + id +
                '}';

    }
}