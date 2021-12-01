package laborator4.ui;


import laborator4.controller.RegistrationSystem;
import laborator4.model.Course;
import laborator4.model.Teacher;

import java.util.*;


public class Menu {

    RegistrationSystem registrationSystem;


    public Menu(RegistrationSystem registrationSystem) {
        this.registrationSystem = registrationSystem;
    }

    public void run() {


        int input;
        Scanner scanner = new Scanner(System.in);


        do {

            System.out.println("Meniu");
            System.out.println("1. Register student to course");
            System.out.println("2. Show courses with free places");
            System.out.println("3. Show students enrolled to a course");
            System.out.println("4. Show all courses");
            System.out.println("5. Delete a course");
            System.out.println("6. Filter Courses by ...");
            System.out.println("7. Sort Courses by ...");
            System.out.println("9. Exit! ");
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
                    try{
                       studentID= scanner.nextLong();
                    }catch (Exception e){
                        scanner.nextLine();
                        System.out.println("Wrong id");
                        break;
                    }


                    System.out.println(registrationSystem.getController().getAllCourses());
                    try{
                      courseID = scanner.nextLong();

                    }catch (Exception e){
                        System.out.println("Wrong id");
                        scanner.nextLine();
                        break;
                    }
                    registrationSystem.register(registrationSystem.getController().findOneKurs(courseID), registrationSystem.getController().findOneStudent(studentID));

                }
                case 2 -> {
                    StringBuilder myString = new StringBuilder();
                    for (Course course : registrationSystem.retrieveCoursesWithFreePlaces()) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);


                }
                case 3 -> {
                    System.out.println(registrationSystem.getController().getAllStudents());
                    StringBuilder myString = new StringBuilder();
                    for (Course course : registrationSystem.getController().getAllCourses()) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);


                    long studentId;
                    try{
                        studentId= scanner.nextLong();
                    }catch (Exception e){
                        System.out.println("Wrong id!");
                        scanner.nextLine();
                        break;
                    }

                    StringBuilder myString2 = new StringBuilder();
                    for (Course course : registrationSystem.getController().findOneStudent(studentId).getEnrolledCourses()) {
                        myString2.append(course).append("\n");
                    }
                    System.out.println(myString2);
                    System.out.println(registrationSystem.getController().getAllStudents());

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
                    for (Course course : registrationSystem.getController().getKursListTeacher(teacherId)) {
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
                    for (Course course : registrationSystem.getController().filterKurs()) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);
                }
                case 7 -> {
                    StringBuilder myString = new StringBuilder();
                    for (Course course : registrationSystem.getController().sortKurs()) {
                        myString.append(course).append("\n");
                    }
                    System.out.println(myString);
                }

            }
        } while (input != 9);


    }
}





























/*




        System.out.println("ceva");

        // List<String> l = new ArrayList<>(new HashSet<>());
        TreeSet<String> l = new TreeSet<>();
        System.out.println(l.add("ceva"));
        System.out.println(l.add("ceva"));

        System.out.println(Long.parseLong ("1", 10)); // asa fac conversie de la string la long !

        Student s1 = new Student("Ionut", "Muntean", 1L);
        Student s2 = new Student("Tudor", "Muntean", 2L);

        Teacher t1 = new Teacher("Mihai", "Oancea", 1L);




        Kurs k1 = new Kurs("Algebra",
                t1,
                100,
                new ArrayList<>(),
                6,
                1L);
        Kurs k2 = new Kurs("Geome",
                t1,
                50,
                new ArrayList<>(),
                6,
                2L);
       List<Kurs> listKurs = Arrays.asList(k1,k2);

       Student s3 = new Student("Tudor", "Baisanu", 3L);
       List<Student> listStudent = Arrays.asList(s1,s2,s3);
       // System.out.println(listStudent.get(0).getClass().getSimpleName());
       RegistrationSystem rs = new RegistrationSystem(listKurs,listStudent);

       System.out.println(rs.getAllCourses());
       rs.register(k1,s3);
        System.out.println(rs.getAllCourses());
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // CSVReader reader = new CSVReader("Studenti");
        List<List<String>> ls = CSVReader.readFile("src/lab3/Studenti");
        List<List<String>> lk = CSVReader.readFile("src/lab3/Cursuri");

        Teacher t2 = new Teacher("Gica", "Petrescu", 2L);


        KursRepository kr = new KursRepository(new ArrayList<>());
        TeacherRepository tr = new TeacherRepository(Arrays.asList(t1, t2));
        for(List<String> line: lk) {
            Teacher t = tr.findOne(Long.parseLong(line.get(1)));
            Kurs k = new Kurs(line.get(0), t, Integer.parseInt(line.get(2)), new ArrayList<>(), Integer.parseInt(line.get(4)), Long.parseLong(line.get(5)));
            kr.save(k);

        }

        // Student s3 = new Student("Tudor", "Muntean", 2L);

        System.out.println(kr.findAll());
//        System.out.println("listStudent:");
//        System.out.println(listStudent);
        List<Student> proba = new ArrayList<>(listStudent);

        System.out.println(listStudent.hashCode());
        System.out.println(proba.hashCode());

//        System.out.println("proba:");
//        System.out.println(proba);

        Student s4 = new Student("Andrei", "Micu", 4L);
        Student s5 = new Student("Bogdan", "Negru", 4L);
        Student s6 = new Student("Bogdan", "Solovastru", 4L);
        proba.add(s4);
        proba.add(s5);
        proba.add(s6);

        System.out.println("proba:");
        System.out.println(proba);

        System.out.println("proba:");
        System.out.println(proba);
*/
    //de bagat in controller

 //       proba.sort( (Student aux_s1, Student aux_s2) ->
        //{
            /*
            if (s1.getFirstName().equals(s2.getFirstName()))
                return s1.getLastName() < s2.getLastName();
            return s1.getFirstName() < s2.getFirstName();
            */
/*
            if (aux_s1.getFirstName().compareTo(aux_s2.getFirstName()) == 0) // sau .equals aici
                return aux_s1.getLastName().compareTo(aux_s2.getLastName());
            return aux_s1.getFirstName().compareTo(aux_s2.getFirstName());
        } );

        proba = proba.stream()
                .filter( (Student s) -> // explict > implicit
                        s.getLastName().equals("Muntean")) // n-avem nevoie de paranteze rotunde daca funtia primeste un singur argument!
                .collect(Collectors.toList());

        System.out.println("proba:");
        System.out.println(proba);


*/








































