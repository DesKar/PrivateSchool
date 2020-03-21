package privateschool;

import java.time.LocalDate;
import static privateschool.MainClass.input;

public class RealSchool extends School {

    public void addStudentInSchool() {

        String firstName = getStringWithMessage("Student first name: ");
        String lastName = getStringWithMessage("Student last name: ");
        LocalDate dateOfBirth = getDate("Student date of birth(YYYY-MM-DD): ");
        int tuitionFees = getIntNumber("Tuition fees: ", "Please provide a number bigger than 0: ", 0, Integer.MAX_VALUE);
        Student student = new Student(firstName, lastName, dateOfBirth, tuitionFees);
        super.setListOfStudents(student);
    }

    public void addTrainerInSchool() {
        String firstName = getStringWithMessage("Trainer first name: ");
        String lastName = getStringWithMessage("Trainer last name: ");
        String subject = getStringWithMessage("Trainer subject: ");
        Trainer trainer = new Trainer(firstName, lastName, subject);
        super.setListOfTrainers(trainer);
    }

    public void addAssignmentInSchool() {
        String title = getStringWithMessage("Assignment title: ");
        String description = getStringWithMessage("Assignment description: ");
        LocalDate subDateTime = getDate("Assignment submission date (YYYY-MM-DD): ");
        int oralMark = getIntNumber("Oral Mark: ", "Please provide a number between 0-10: ", 0, 10);
        int localMark = getIntNumber("Local mark: ", "Please provide a number between 0-10: ", 0, 10);
        Assignment assignment = new Assignment(title, description, subDateTime, oralMark, localMark);
        super.setListOfAssignments(assignment);
    }

    public void addCourseInSchool() {
        String title = getStringWithMessage("Course title: ");
        String stream = getStringWithMessage("Course stream title: ");
        String type = getStringWithMessage("Course type: ");
        LocalDate startDate = getDate("Course starting date (YYYY-MM-DD): ");
        LocalDate endDate = getDate("Course ending date (YYYY-MM-DD): ");
        Course course = new Course(title, stream, type, startDate, endDate);
        super.setListOfCourses(course);
    }

    private String getStringWithMessage(String message) {
        System.out.print(message);
        return input.next();
    }

    private LocalDate getDate(String message) {

        System.out.print(message);
        LocalDate localDate = null;
        while (localDate == null) {
            try {
                String date = input.next();
                while (date.charAt(4) != '-' || date.charAt(7) != '-' || date.length() != 10) {
                    System.out.print("Please provide the date in the format YYYY-MM-DD: ");
                    date = input.next();
                }
                String[] dateArray = date.split("-");

                int year = Integer.parseInt(dateArray[0]);
                int month = Integer.parseInt(dateArray[1]);
                int day = Integer.parseInt(dateArray[2]);

                localDate = LocalDate.of(year, month, day);
            } catch (java.lang.NumberFormatException e) {
                System.out.print("Please provide the date in the format YYYY-MM-DD: ");

            } catch(java.time.DateTimeException e){
                System.out.print("Please make sure you add the correct date:");
            }
        }
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
