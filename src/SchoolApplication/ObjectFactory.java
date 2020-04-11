package SchoolApplication;

import static SchoolApplication.MainClass.db;
import java.time.LocalDate;

public class ObjectFactory {

    public static void addStudentToSchool() {
        Student student = createStudentObject();
        if (!StudentDAO.studentExists(student)) {
            StudentDAO.createRecordInStudents(student);
        } else {
            System.out.println("\nStudent already exists.");
        }
    }

    public static void addTrainerToSchool() {
        Trainer trainer = createTrainerObject();
        if (!TrainerDAO.trainerExists(trainer)) {
            TrainerDAO.createRecordInTrainers(trainer);
        } else {
            System.out.println("\nTrainer already exists.");
        }
    }

    public static void addAssignmentToSchool() {
        Assignment assignment = createAssignmentObject();
        if (!AssignmentDAO.assignmentExists(assignment)) {
            AssignmentDAO.createRecordInAssignments(assignment);
        } else {
            System.out.println("\nThe assignment already exists.");
        }
    }

    public static void addCourseToSchool() {
        Course course = createCourseObject();
        if (!CourseDAO.courseExists(course)) {
            CourseDAO.createRecordInCourses(course);
        } else {
            System.out.println("\nThe Course already exists.");
        }
    }

    private static Student createStudentObject() {
        String firstName = Utils.getStringWithMessage("Student first name: ");
        String lastName = Utils.getStringWithMessage("Student last name: ");
        LocalDate dateOfBirth = Utils.getDate("Student date of birth(YYYY-MM-DD): ");
        int tuitionFees = Utils.getIntNumber("Tuition fees: ", "Please provide a number bigger than 0: ", 0, Integer.MAX_VALUE);
        Student student = new Student(0, firstName, lastName, dateOfBirth, tuitionFees);
        return student;
    }

    private static Trainer createTrainerObject() {
        String firstName = Utils.getStringWithMessage("Trainer first name: ");
        String lastName = Utils.getStringWithMessage("Trainer last name: ");
        String subject = Utils.getStringWithMessage("Trainer subject: ");
        Trainer trainer = new Trainer(0, firstName, lastName, subject);
        return trainer;
    }

    private static Assignment createAssignmentObject() {
        String title = Utils.getStringWithMessage("Assignment title: ");
        String description = Utils.getStringWithMessage("Assignment description: ");
        LocalDate subDateTime = Utils.getDate("Assignment submission date (YYYY-MM-DD): ");
        int oralMark = Utils.getIntNumber("Oral Mark: ", "Please provide a number between 0-10: ", 0, 10);
        int localMark = Utils.getIntNumber("Local mark: ", "Please provide a number between 0-10: ", 0, 10);
        Assignment assignment = new Assignment(0, title, description, subDateTime, oralMark, localMark);
        return assignment;
    }

    private static Course createCourseObject() {
        String title = Utils.getStringWithMessage("Course title: ");
        String stream = Utils.getStringWithMessage("Course stream title: ");
        String type = Utils.getStringWithMessage("Course type: ");
        LocalDate startDate = Utils.getDate("Course starting date (YYYY-MM-DD): ");
        LocalDate endDate = Utils.getDate("Course ending date (YYYY-MM-DD): ", startDate);
        Course course = new Course(0, title, stream, type, startDate, endDate);
        return course;
    }
}
