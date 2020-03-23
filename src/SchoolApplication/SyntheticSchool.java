package SchoolApplication;

import java.time.LocalDate;
import java.util.ArrayList;

public class SyntheticSchool extends School {

    SyntheticSchool() {
        addStudentsToSchool();
        addTrainersToSchool();
        addAssignmentsToSchool();
        addCoursesToSchool();

        addStudentsToCourse();
        addTrainersToCourse();
        addAssignmentsToCourse();
    }

    private void addStudentsToSchool() {

        Student student = new Student("John", "Doe", LocalDate.ofEpochDay(0), 2000);
        super.addStudentInListOfStudents(student);
        student = new Student("Joe", "Bloggs", LocalDate.of(1988, 03, 05), 1500);
        super.addStudentInListOfStudents(student);
        student = new Student("Max", "Muster", LocalDate.ofEpochDay(0), 1850);
        super.addStudentInListOfStudents(student);
        student = new Student("Ada", "Lovelace", LocalDate.of(1815, 12, 10), 1500);
        super.addStudentInListOfStudents(student);
        student = new Student("Grace", "Hopper", LocalDate.of(1906, 01, 01), 2000);
        super.addStudentInListOfStudents(student);

    }

    private void addTrainersToSchool() {
        Trainer trainer = new Trainer("Jane", "Doe", "Java");
        super.addTrainerInListOfTrainers(trainer);
        trainer = new Trainer("Juan", "Perez", "C#");
        super.addTrainerInListOfTrainers(trainer);
        trainer = new Trainer("Helen", "Doe", "");
        super.addTrainerInListOfTrainers(trainer);
    }

    private void addAssignmentsToSchool() {

        Assignment assignment = new Assignment("Java Individual Project", "The individual project of the students", LocalDate.of(2020, 4, 8), 10, 10);
        super.addAssignmentInListOfAssignments(assignment);
        assignment = new Assignment("Java Team Project", "The team project of the students", LocalDate.of(2020, 5, 28), 9, 9);
        super.addAssignmentInListOfAssignments(assignment);
        assignment = new Assignment("C# Individual Project", "The individual project of the students", LocalDate.of(2020, 4, 8), 10, 10);
        super.addAssignmentInListOfAssignments(assignment);
        assignment = new Assignment("C# Team Project", "The team project of the students", LocalDate.of(2020, 5, 28), 9, 9);
        super.addAssignmentInListOfAssignments(assignment);
    }

    private void addCoursesToSchool() {
        Course course = new Course("Coding Bootcamp", "Java Full Stack Development", "Full-time", LocalDate.of(2020, 3, 4), LocalDate.of(2020, 6, 5));
        super.addSCourseInListOfCourses(course);
        course = new Course("Coding Bootcamp", "C# Full Stack Development", "Part-time", LocalDate.of(2020, 3, 4), LocalDate.of(2020, 8, 5));
        super.addSCourseInListOfCourses(course);

    }

    private void addStudentsToCourse() {
        Course firstCourse = super.getListOfCourses().get(0);
        Course secondCourse = super.getListOfCourses().get(1);

        Student firstStudent = super.getListOfStudents().get(0);
        Student secondStudent = super.getListOfStudents().get(1);
        Student thirdStudent = super.getListOfStudents().get(2);
        Student fourthStudent = super.getListOfStudents().get(3);
        Student fifthStudent = super.getListOfStudents().get(4);

        ArrayList<Student> selectedStudentsForFirstCourse = new ArrayList();
        selectedStudentsForFirstCourse.add(firstStudent);
        selectedStudentsForFirstCourse.add(thirdStudent);
        selectedStudentsForFirstCourse.add(fourthStudent);

        ArrayList<Student> selectedStudentsForSecondCourse = new ArrayList();
        selectedStudentsForSecondCourse.add(secondStudent);
        selectedStudentsForSecondCourse.add(thirdStudent);
        selectedStudentsForSecondCourse.add(fifthStudent);

        StudentsInCourse studentsInFirstCourse = new StudentsInCourse(firstCourse, selectedStudentsForFirstCourse);
        super.addStudentsInCourseToListOfStudentsInCourse(studentsInFirstCourse);

        StudentsInCourse studentsInSecondCourse = new StudentsInCourse(secondCourse, selectedStudentsForSecondCourse);
        super.addStudentsInCourseToListOfStudentsInCourse(studentsInSecondCourse);

    }

    private void addTrainersToCourse() {
        Course firstCourse = super.getListOfCourses().get(0);
        Course secondCourse = super.getListOfCourses().get(1);

        Trainer firstTrainer = super.getListOfTrainers().get(0);
        Trainer secondTrainer = super.getListOfTrainers().get(1);
        Trainer thirdTrainert = super.getListOfTrainers().get(2);

        ArrayList<Trainer> selectedTrainersForFirstCourse = new ArrayList();
        selectedTrainersForFirstCourse.add(firstTrainer);
        selectedTrainersForFirstCourse.add(thirdTrainert);

        ArrayList<Trainer> selectedTrainersForSecondCourse = new ArrayList();
        selectedTrainersForSecondCourse.add(firstTrainer);
        selectedTrainersForSecondCourse.add(secondTrainer);

        TrainersInCourse trainersInFirstCourse = new TrainersInCourse(firstCourse, selectedTrainersForFirstCourse);
        super.addTrainersInCourseToListOfTrainersInCourse(trainersInFirstCourse);

        TrainersInCourse trainersInSecondCourse = new TrainersInCourse(secondCourse, selectedTrainersForSecondCourse);
        super.addTrainersInCourseToListOfTrainersInCourse(trainersInSecondCourse);

    }

    private void addAssignmentsToCourse() {
        Course firstCourse = super.getListOfCourses().get(0);
        Course secondCourse = super.getListOfCourses().get(1);

        Assignment firstAssignment = super.getListOfAssignments().get(0);
        Assignment secondAssignment = super.getListOfAssignments().get(1);
        Assignment thirdAssignment = super.getListOfAssignments().get(2);
        Assignment forthAssignment = super.getListOfAssignments().get(3);

        ArrayList<Assignment> selectedAssignmentsForFirstCourse = new ArrayList();
        selectedAssignmentsForFirstCourse.add(firstAssignment);
        selectedAssignmentsForFirstCourse.add(secondAssignment);

        ArrayList<Assignment> selectedAssignmentsForSecondCourse = new ArrayList();
        selectedAssignmentsForSecondCourse.add(thirdAssignment);
        selectedAssignmentsForSecondCourse.add(forthAssignment);

        AssignmentsInCourse assignmentsInFirstCourse = new AssignmentsInCourse(firstCourse, selectedAssignmentsForFirstCourse);
        super.addAssignmentsInCourseToListOfAssignmentsInCourse(assignmentsInFirstCourse);

        AssignmentsInCourse assignmentsInSecondCourse = new AssignmentsInCourse(secondCourse, selectedAssignmentsForSecondCourse);
        super.addAssignmentsInCourseToListOfAssignmentsInCourse(assignmentsInSecondCourse);
    }
}
