package privateschool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        
        
        

        ArrayList<Student> listOfStudents = new ArrayList();
        ArrayList<Trainer> listOfTrainers = new ArrayList();
        ArrayList<Assignment> listOfAssignments = new ArrayList();
        ArrayList<Course> listOfCourses = new ArrayList();
        
        listOfStudents.add(createStudent());
        listOfTrainers.add(createTrainer());
        listOfAssignments.add(createAssignment());
        listOfCourses.add(createCourse());

    }

    public static Student createStudent() {

        String firstName = getStringWithMessage("Student first name: ");
        String lastName = getStringWithMessage("Student last name: ");
        LocalDate dateOfBirth = getDate("Student date of birth(YYYY-MM-DD): ");
        int tuitionFees = getIntNumber("Tuition fees: ", "Please provide a number bigger than 0: ", 0, Integer.MAX_VALUE);
        Student student = new Student(firstName, lastName, dateOfBirth, tuitionFees);
        return student;
    }

    public static Trainer createTrainer() {
        String firstName = getStringWithMessage("Trainer first name: ");
        String lastName = getStringWithMessage("Trainer last name: ");
        String subject = getStringWithMessage("Trainer subject: ");
        Trainer trainer = new Trainer(firstName, lastName, subject);
        return trainer;
    }

    public static Assignment createAssignment() {
        String title = getStringWithMessage("Assignment title: ");
        String description = getStringWithMessage("Assignment description: ");
        LocalDate subDateTime = getDate("Assignment submission date (YYYY-MM-DD): ");
        int oranMark = getIntNumber("Oral Mark: ", "Please provide a number between 0-10: ", 0, 10);
        int localMark = getIntNumber("Local mark: ", "Please provide a number between 0-10: ", 0, 10);
        Assignment assignment = new Assignment(title, description, subDateTime, oranMark, localMark);
        return assignment;
    }

    public static Course createCourse() {
        String title = getStringWithMessage("Course title: ");
        String stream = getStringWithMessage("Course stream title: ");
        String type = getStringWithMessage("Course type: ");
        LocalDate startDate = getDate("Course starting date: ");
        LocalDate endDate = getDate("Course starting date: ");
        Course course = new Course(title, stream, type, startDate, endDate);
        return course;
    }

    public static String getStringWithMessage(String message) {
        System.out.print(message);
        return input.next();
    }

    private static LocalDate getDate(String message) {

        System.out.print(message);
        String date = input.next();
        while (date.charAt(4) != '-' || date.charAt(7) != '-') {
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

    private static int getIntNumber(String message1, String message2, int lowerBound, int upperBound) {
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
