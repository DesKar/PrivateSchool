package privateschool;

import java.time.LocalDate;

public class SyntheticSchool extends School {

    private Student student = new Student("John", "Doe", LocalDate.ofEpochDay(0), 2000);
    private Trainer trainer = new Trainer("Jane", "Doe", "Java");
    private Assignment assignment = new Assignment("Individual Project", "The individual project of the students", LocalDate.of(2020, 4, 8), 10, 10);
    private Course course = new Course("Coding Bootcamp", "Java Full Stack Development", "Full-time", LocalDate.of(2020, 3, 4), LocalDate.of(2020, 6, 5));

    public SyntheticSchool() {
        super();
        super.setListOfStudents(student);
        super.setListOfTrainers(trainer);
        super.setListOfCourses(course);
        super.setListOfAssignments(assignment);
    }

}
