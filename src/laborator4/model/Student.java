package laborator4.model;

import java.util.ArrayList;
import java.util.List;


public class Student extends Person{

    private Long studentID;
    private int totalCredits;
    private List<Course> enrolledCourses;




    public Student(String firstName, String lastName, Long studentID, List<Course> enrolledCourses){
        super(firstName, lastName);
        this.studentID = studentID;
        this.enrolledCourses = enrolledCourses;
        this.totalCredits = this.totalCreditsOfaStudent();


    }

    public Student(String firstName, String lastName, Long studentID){
        super(firstName, lastName);
        this.studentID = studentID;
        this.enrolledCourses = new ArrayList<>();
        this.totalCredits = this.totalCreditsOfaStudent();


    }


    public int totalCreditsOfaStudent(){
        int totalCredits = 0;
        for(Course course : enrolledCourses)
            totalCredits += course.getCredits();
        return totalCredits;
    }


    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    @Override
    public String toString() {
        return super.toString() +
                "studentID='" + studentID + '\'' +
                ", nrEnrolledClassList=" + enrolledCourses.size() +
                ", enrolledClassesCreditNumber=" + totalCredits +
                "}\n";
    }

}