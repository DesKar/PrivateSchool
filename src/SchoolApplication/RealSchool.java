package SchoolApplication;

import java.time.LocalDate;
import java.util.ArrayList;

public class RealSchool extends School {

    public void addStudentToSchool() {
        String firstName = Utils.getStringWithMessage("Student first name: ");
        String lastName = Utils.getStringWithMessage("Student last name: ");
        LocalDate dateOfBirth = Utils.getDate("Student date of birth(YYYY-MM-DD): ");
        int tuitionFees = Utils.getIntNumber("Tuition fees: ", "Please provide a number bigger than 0: ", 0, Integer.MAX_VALUE);
        Student student = new Student(firstName, lastName, dateOfBirth, tuitionFees);
        if (!studentExists(student)) {
            super.addStudenToStudents(student);
        } else {
            System.out.println("\nStudent already exists.");
        }

    }

    public void addTrainerToSchool() {
        String firstName = Utils.getStringWithMessage("Trainer first name: ");
        String lastName = Utils.getStringWithMessage("Trainer last name: ");
        String subject = Utils.getStringWithMessage("Trainer subject: ");
        Trainer trainer = new Trainer(firstName, lastName, subject);
        if (!trainerExists(trainer)) {
            super.addTrainerToTrainers(trainer);
        } else {
            System.out.println("\nTrainer already exists.");
        }

    }

    public void addAssignmentToSchool() {
        String title = Utils.getStringWithMessage("Assignment title: ");
        String description = Utils.getStringWithMessage("Assignment description: ");
        LocalDate subDateTime = Utils.getDate("Assignment submission date (YYYY-MM-DD): ");
        int oralMark = Utils.getIntNumber("Oral Mark: ", "Please provide a number between 0-10: ", 0, 10);
        int localMark = Utils.getIntNumber("Local mark: ", "Please provide a number between 0-10: ", 0, 10);
        Assignment assignment = new Assignment(title, description, subDateTime, oralMark, localMark);
        if (!assignmentExists(assignment)) {
            super.addAssignmentToAssignments(assignment);
        } else {
            System.out.println("\nThe assignment already exists.");
        }
    }

    public void addCourseToSchool() {
        String title = Utils.getStringWithMessage("Course title: ");
        String stream = Utils.getStringWithMessage("Course stream title: ");
        String type = Utils.getStringWithMessage("Course type: ");
        LocalDate startDate = Utils.getDate("Course starting date (YYYY-MM-DD): ");
        LocalDate endDate = Utils.getDate("Course ending date (YYYY-MM-DD): ", startDate);
        Course course = new Course(title, stream, type, startDate, endDate);
        if (!courseExists(course)) {
            super.addCourseToCourses(course);
        } else {
            System.out.println("\nThe Course already exists.");
        }
    }

    private boolean studentExists(Student newStudent) {
        ArrayList<Student> listOfStudets = super.getStudents();
        for (Student student : listOfStudets) {
            if (newStudent.equals(student)) {
                return true;
            }
        }
        return false;
    }

    private boolean trainerExists(Trainer newTrainer) {
        ArrayList<Trainer> listOfTrainers = super.getTrainers();
        for (Trainer trainer : listOfTrainers) {
            if (newTrainer.equals(trainer)) {
                return true;
            }
        }
        return false;
    }

    private boolean assignmentExists(Assignment newAssignmnet) {
        ArrayList<Assignment> listOfAssignments = super.getAssignments();
        for (Assignment assignment : listOfAssignments) {
            if (newAssignmnet.equals(assignment)) {
                return true;
            }
        }
        return false;
    }

    private boolean courseExists(Course newCourse) {
        ArrayList<Course> listOfCourses = super.getCourses();
        for (Course course : listOfCourses) {
            if (newCourse.equals(course)) {
                return true;
            }
        }
        return false;
    }
}
