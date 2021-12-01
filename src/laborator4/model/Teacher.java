package laborator4.model;// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<Course> courses; // dc nu tre sa pun lab3.model.Kurs aici?
    private Long id;

    public Teacher(String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
    }

    public Teacher(String firstName, String lastName, Long id) {
        super(firstName, lastName);
        this.courses = new ArrayList<>();
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" + "Name="+ this.getFirstName()+ " " + this.getLastName()+
                ", kursList=" + courses +
                ", id=" + id +
                '}';
    }


}

