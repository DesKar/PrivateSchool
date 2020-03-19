package privateschool;

import java.time.LocalDate;
import static privateschool.MainClass.input;

public class CodingSchool extends School {

    private Student student = createStudent();
    private Trainer trainer = createTrainer();
    private Assignment assignment = createAssignment();
    private Course course = createCourse();

    public CodingSchool() {
        super();
        super.setListOfStudents(student);
        super.setListOfTrainers(trainer);
        super.setListOfCourses(course);
        super.setListOfAssignments(assignment);
    }

    public CodingSchool(Student student) {
        super.setListOfStudents(student);
    }

    public CodingSchool(Trainer trainer) {
        super.setListOfTrainers(trainer);
    }

    public CodingSchool(Course course) {
        super.setListOfCourses(course);
    }

    public CodingSchool(Assignment assignment) {
        super.setListOfAssignments(assignment);
    }

    private Student createStudent() {

        String firstName = getStringWithMessage("Student first name: ");
        String lastName = getStringWithMessage("Student last name: ");
        LocalDate dateOfBirth = getDate("Student date of birth(YYYY-MM-DD): ");
        int tuitionFees = getIntNumber("Tuition fees: ", "Please provide a number bigger than 0: ", 0, Integer.MAX_VALUE);
        student = new Student(firstName, lastName, dateOfBirth, tuitionFees);
        return student;
    }

    private Trainer createTrainer() {
        String firstName = getStringWithMessage("Trainer first name: ");
        String lastName = getStringWithMessage("Trainer last name: ");
        String subject = getStringWithMessage("Trainer subject: ");
        trainer = new Trainer(firstName, lastName, subject);
        return trainer;
    }

    private Assignment createAssignment() {
        String title = getStringWithMessage("Assignment title: ");
        String description = getStringWithMessage("Assignment description: ");
        LocalDate subDateTime = getDate("Assignment submission date (YYYY-MM-DD): ");
        int oralMark = getIntNumber("Oral Mark: ", "Please provide a number between 0-10: ", 0, 10);
        int localMark = getIntNumber("Local mark: ", "Please provide a number between 0-10: ", 0, 10);
        assignment = new Assignment(title, description, subDateTime, oralMark, localMark);
        return assignment;
    }

    private Course createCourse() {
        String title = getStringWithMessage("Course title: ");
        String stream = getStringWithMessage("Course stream title: ");
        String type = getStringWithMessage("Course type: ");
        LocalDate startDate = getDate("Course starting date (YYYY-MM-DD): ");
        LocalDate endDate = getDate("Course ending date (YYYY-MM-DD): ");
        course = new Course(title, stream, type, startDate, endDate);
        return course;
    }

    private String getStringWithMessage(String message) {
        System.out.print(message);
        return input.next();
    }

    private LocalDate getDate(String message) {

        System.out.print(message);
        String date = input.next();
        while (date.charAt(4) != '-' || date.charAt(7) != '-' || date.length() != 10) {
            System.out.print("Please provide the date in the format YYYY-MM-DD: ");
            date = input.next();
        }
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);

        //TODO check validity of date
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    private int getIntNumber(String message1, String message2, int lowerBound, int upperBound) {
        int number;
        do {
            System.out.print(message1);
            while (!input.hasNextInt()) {
                System.out.print(message2);
                input.next();
            }
            number = input.nextInt();
        } while (number <= lowerBound || number >= upperBound);
        return number;
    }
}
