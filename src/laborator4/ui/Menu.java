package laborator4.ui;


import laborator4.controller.RegistrationSystem;
import laborator4.model.Course;
import laborator4.model.Student;
import laborator4.model.Teacher;

import java.util.*;


public class Menu {

    RegistrationSystem registrationSystem;


    public Menu(RegistrationSystem registrationSystem) {
        this.registrationSystem = registrationSystem;
    }

    /**
     * The method for the UI Menu.
     */
    public void run() {


        int input;
        Scanner scanner = new Scanner(System.in);


        do {

            System.out.println("Menu");
            System.out.println("--------------------------------------");
            System.out.println("1. Register student to course");
            System.out.println("2. Show courses with free places");
            System.out.println("3. Show students enrolled to a course");
            System.out.println("4. Show all courses");
            System.out.println("5. Delete a course");
            System.out.println("6. Filter courses by creditsNumber");
            System.out.println("7. Sort courses by name");
            System.out.println("8. Filter students by creditsNumber");
            System.out.println("9. Sort students by firstName or lastName");
            System.out.println("0. Exit ");
            System.out.println("Choose option: ");

            try{
                input=scanner.nextInt();
            }catch(Exception e){
                scanner.nextLine();
                input=-1;
                System.out.println("Wrong option");
            }

            switch (input) {
                case 1 -> {
                    long studentID,courseID;
                    System.out.println(registrationSystem.getController().getAllStudents());
                    System.out.println("Choose id student: ");
                    try{
                       studentID= scanner.nextLong();
                    }catch (Exception e){
                        scanner.nextLine();
                        System.out.println("Wrong id");
                        break;
                    }


                    System.out.println(registrationSystem.getController().getAllCourses());
                    System.out.println("Choose id course: ");
                    try{
                      courseID = scanner.nextLong();

                    }catch (Exception e){
                        System.out.println("Wrong id");
                        scanner.nextLine();
                        break;
                    }
                    registrationSystem.register(registrationSystem.getController().findOneCourse(courseID), registrationSystem.getController().findOneStudent(studentID));

                }
                case 2 -> {
                    StringBuilder myString = new StringBuilder();
                    for (Course course : registrationSystem.retrieveCoursesWithFreePlaces()) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);


                }
                case 3 -> {

                    long courseID;
                    System.out.println(registrationSystem.getController().getAllCourses());
                    System.out.println("Choose id course: ");
                    try{
                        courseID = scanner.nextLong();

                    }catch (Exception e){
                        System.out.println("Wrong id");
                        scanner.nextLine();
                        break;
                    }

                    StringBuilder myString = new StringBuilder();
                    for (Student student : registrationSystem.retrieveStudentsEnrolledForACourse(registrationSystem.getController().findOneCourse(courseID))) {
                        myString.append(student).append("\n");
                    }
                    System.out.println(myString);



                }
                case 4 -> {
                    StringBuilder myString = new StringBuilder();
                    for (Course course : registrationSystem.getController().getAllCourses()) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);

                }
                case 5 -> {
                    long teacherId,courseId;
                    StringBuilder myString = new StringBuilder();
                    for (Teacher teacher : registrationSystem.getController().getAllTeachers()) {
                        myString.append(teacher).append("\n");
                    }
                    System.out.println(myString);
                    System.out.println("Choose teacher: ");
                    try{
                        teacherId= scanner.nextLong();
                    }catch (Exception e){
                        System.out.println("Wrong id");
                        scanner.nextLine();
                        break;
                    }
                    myString = new StringBuilder();
                    for (Course course : registrationSystem.getController().getCourseListTeacher(teacherId)) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);
                    System.out.println("Choose course: ");
                    try{
                        courseId= scanner.nextLong();
                    }catch (Exception e){
                        System.out.println("Wrong id");
                        scanner.nextLine();
                        break;
                    }
                    registrationSystem.getController().deleteCourse(courseId);

                }
                case 6 -> {
                    StringBuilder myString = new StringBuilder();
                    for (Course course : registrationSystem.getController().filterCourse()) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);
                }
                case 7 -> {
                    StringBuilder myString = new StringBuilder();
                    for (Course course : registrationSystem.getController().sortCourse()) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);
                }
                case 8 -> {
                    StringBuilder myString = new StringBuilder();
                    for(Student student : registrationSystem.getController().filterStudents()){
                        myString.append(student).append("\n");
                    }
                    System.out.println(myString);
                }
                case 9 -> {
                    StringBuilder myString = new StringBuilder();
                    for(Student student : registrationSystem.getController().sortStudenten()){
                        myString.append(student).append("\n");
                    }
                    System.out.println(myString);
                }


            }
        } while (input != 0);


    }
}




































































