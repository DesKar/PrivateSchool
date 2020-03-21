package SchoolApplication;

import java.time.LocalDate;

public class SyntheticSchool extends School {
    
    SyntheticSchool(){
        addStudentsInSchool();
        addTrainersInSchool();
        addAssignmentsInSchool();
        addCoursesInSchool();
    }

    private void addStudentsInSchool() {

        Student student = new Student("John", "Doe", LocalDate.ofEpochDay(0), 2000);
        super.setListOfStudents(student);
        student = new Student("Joe", "Bloggs", LocalDate.of(1988, 03, 05), 1500);
        super.setListOfStudents(student);
        student = new Student("Max", "Muster", LocalDate.ofEpochDay(0), 1850);
        super.setListOfStudents(student);
        student = new Student("Ada", "Lovelace", LocalDate.of(1815, 12, 10), 1500);
        super.setListOfStudents(student);
        student = new Student("Grace", "Hopper", LocalDate.of(1906, 01, 01), 2000);
        super.setListOfStudents(student);

    }

    private void addTrainersInSchool() {
        Trainer trainer = new Trainer("Jane", "Doe", "Java");
        super.setListOfTrainers(trainer);
        trainer = new Trainer("Juan", "Perez", "C#");
        super.setListOfTrainers(trainer);
        trainer = new Trainer("Helen", "Doe", "");
        super.setListOfTrainers(trainer);
    }

    private void addAssignmentsInSchool() {

        Assignment assignment = new Assignment("Individual Project", "The individual project of the students", LocalDate.of(2020, 4, 8), 10, 10);
        super.setListOfAssignments(assignment);
        assignment = new Assignment("Team Project", "The team project of the students", LocalDate.of(2020, 5, 28), 9, 9);
        super.setListOfAssignments(assignment);
    }

    private void addCoursesInSchool() {
        Course course = new Course("Coding Bootcamp", "Java Full Stack Development", "Full-time", LocalDate.of(2020, 3, 4), LocalDate.of(2020, 6, 5));
        super.setListOfCourses(course);
        course = new Course("Coding Bootcamp", "Java Full Stack Development", "Part-time", LocalDate.of(2020, 3, 4), LocalDate.of(2020, 8, 5));
        super.setListOfCourses(course);
    }

}
