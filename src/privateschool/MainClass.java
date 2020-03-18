package privateschool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Student> listOfStudents = new ArrayList();
        ArrayList<Trainer> listOfTrainers = new ArrayList();

        listOfStudents.add(createStudent());
        listOfTrainers.add(createTrainer());

    }

    public static Student createStudent() {

        String firstName = getName("Student first name: ");
        String lastName = getName("Student last name: ");
        LocalDate dateOfBirth = getDateOfBirth();
        double tuitionFees = getTuitionFees();
        Student student = new Student(firstName, lastName, dateOfBirth, tuitionFees);
        return student;
    }

    public static Trainer createTrainer() {
        String firstName = getName("Trainer first name: ");
        String lastName = getName("Trainer last name: ");
        Trainer trainer = new Trainer(firstName, lastName);
        return trainer;
    }

    public static String getName(String message) {
        System.out.print(message);
        return input.next();
    }

    private static LocalDate getDateOfBirth() {

        System.out.print("Student date of birth(YYYY-MM-DD)?");
        String date = input.next();
        while (date.charAt(4) != '-' || date.charAt(7) != '-') {
            System.out.print("Please provide the date in the format YYYY-MM-DD");
            date = input.next();
        }
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);

        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    private static double getTuitionFees() {
        double tuitionFees;
        do {
            System.out.print("Tuition fees: ");
            while (!input.hasNextDouble()) {
                System.out.print("Tuition fees: ");
                input.next();
            }
            tuitionFees = input.nextDouble();
        } while (tuitionFees < 0);
        return tuitionFees;
    }
    
}
