package SchoolApplication;

import static SchoolApplication.MainClass.db;
import java.time.LocalDate;

public class RealSchool extends School {

    public void addStudentToSchool() {
        Student student = createStudentObject();
        if (!StudentDAO.studentExists(student, db)) {
            StudentDAO.createRecordInStudents(student, db);
        } else {
            System.out.println("\nStudent already exists.");
        }
    }

    public void addTrainerToSchool() {
        Trainer trainer = createTrainerObject();
        if (!TrainerDAO.trainerExists(trainer, db)) {
            TrainerDAO.createRecordInTrainers(trainer, db);
        } else {
            System.out.println("\nTrainer already exists.");
        }
    }

    public void addAssignmentToSchool() {
        Assignment assignment = createAssignmentObject();
        if (!AssignmentDAO.assignmentExists(assignment, db)) {
            AssignmentDAO.createRecordInAssignments(assignment, db);
        } else {
            System.out.println("\nThe assignment already exists.");
        }
    }

    public void addCourseToSchool() {
        Course course = createCourseObject();
        if (!CourseDAO.courseExists(course, db)) {
            CourseDAO.createRecordInCourses(course, db);
        } else {
            System.out.println("\nThe Course already exists.");
        }
    }

    private Student createStudentObject() {
        String firstName = Utils.getStringWithMessage("Student first name: ");
        String lastName = Utils.getStringWithMessage("Student last name: ");
        LocalDate dateOfBirth = Utils.getDate("Student date of birth(YYYY-MM-DD): ");
        int tuitionFees = Utils.getIntNumber("Tuition fees: ", "Please provide a number bigger than 0: ", 0, Integer.MAX_VALUE);
        Student student = new Student(0, firstName, lastName, dateOfBirth, tuitionFees);
        return student;
    }

    private Trainer createTrainerObject() {
        String firstName = Utils.getStringWithMessage("Trainer first name: ");
        String lastName = Utils.getStringWithMessage("Trainer last name: ");
        String subject = Utils.getStringWithMessage("Trainer subject: ");
        Trainer trainer = new Trainer(0, firstName, lastName, subject);
        return trainer;
    }

    private Assignment createAssignmentObject() {
        String title = Utils.getStringWithMessage("Assignment title: ");
        String description = Utils.getStringWithMessage("Assignment description: ");
        LocalDate subDateTime = Utils.getDate("Assignment submission date (YYYY-MM-DD): ");
        int oralMark = Utils.getIntNumber("Oral Mark: ", "Please provide a number between 0-10: ", 0, 10);
        int localMark = Utils.getIntNumber("Local mark: ", "Please provide a number between 0-10: ", 0, 10);
        Assignment assignment = new Assignment(0, title, description, subDateTime, oralMark, localMark);
        return assignment;
    }

    private Course createCourseObject() {
        String title = Utils.getStringWithMessage("Course title: ");
        String stream = Utils.getStringWithMessage("Course stream title: ");
        String type = Utils.getStringWithMessage("Course type: ");
        LocalDate startDate = Utils.getDate("Course starting date (YYYY-MM-DD): ");
        LocalDate endDate = Utils.getDate("Course ending date (YYYY-MM-DD): ", startDate);
        Course course = new Course(0, title, stream, type, startDate, endDate);
        return course;
    }
}
