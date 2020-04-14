package SchoolApplication;

import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);
    public static Database db = null;

    public static void main(String[] args) {

        Printing.printWelcomeMessage();
        chooseDb();
        String option = null;
        do {
            option = chooseOptionL1();
        } while (!option.equals("-q"));

    }

    public static void chooseDb() {
        String option = null;
        do {
            Printing.printDbMenu();
            option = input.nextLine();
            switch (option) {
                case "1":
                    db = new Database("PrivateSchoolDemo", "root", "password");
                    break;
                case "2":
                    db = new Database("PrivateSchool", "root", "password");
                    break;
                case "-q":
                    System.out.println("Thank you for using the School Application!");
                    input.close();
                    System.exit(0);
                default:
                    break;
            }
        } while (!(option.equals("-q") || option.equals("1") || option.equals("2")));
    }

    public static String chooseOptionL1() {
        String option = null;
        do {
            Printing.printOptionsL1();
            option = input.nextLine();
            switch (option) {
                case "1":
                    optionAddData();
                    break;
                case "2":
                    optionCombineData();
                    break;
                case "3":
                    optionPrintData();
                    break;
                case "-q":
                    System.out.println("Thank you for using the School Application!");
                    input.close();
                    System.exit(0);
                default:
                    break;
            }
        } while (!(option.equals("-q") || option.equals("1") || option.equals("2") || option.equals("3")));
        return option;
    }

    public static void optionAddData() {
        String option = null;
        do {
            Printing.printUserOptionsAddData();
            option = input.nextLine();
            switch (option) {
                case "1":
                    ObjectFactory.addStudentToSchool();
                    break;
                case "2":
                    ObjectFactory.addTrainerToSchool();
                    break;
                case "3":
                    ObjectFactory.addAssignmentToSchool();
                    break;
                case "4":
                    ObjectFactory.addCourseToSchool();
                    break;
                case "-1":
                    break;
            }
        } while (!(option.equals("-1") || option.equals("1") || option.equals("2")
                || option.equals("3") || option.equals("4")));
    }

    public static void optionCombineData() {
        String option = null;
        do {
            Printing.printUserOptionsCombineData();
            option = input.nextLine();
            switch (option) {
                case "1":
                    School.addStudentToCourse();
                    break;
                case "2":
                    School.addTrainerToCourse();
                    break;
                case "3":
                    School.addAssignmentToCourse();
                    break;
                case "-1":
                    break;
            }
        } while (!(option.equals("-1") || option.equals("1") || option.equals("2") || option.equals("3")));

    }

    public static void optionPrintData() {
        String option = null;
        do {
            Printing.printUserOptionsPrintData();
            option = input.nextLine();
            switch (option) {
                case "1":
                    School.printAllStudents();
                    break;
                case "2":
                    School.printAllTrainers();
                    break;
                case "3":
                    School.printAllAssignments();
                    break;
                case "4":
                    School.printAllCourses();
                    break;
                case "5":
                    School.printStudentsInCourse();
                    break;
                case "6":
                    School.printTrainersInCourse();
                    break;
                case "7":
                    School.printAssignmentsInCourse();
                    break;
                case "8":
                    School.printAssignmentsPerCoursePerStudent();
                    break;
                case "9":
                    School.printStudentsInManyCourses();
                    break;
                case "-1":
                    break;
            }
        } while (!(option.equals("-1") || option.equals("1") || option.equals("2") || option.equals("3")
                || option.equals("4") || option.equals("5") || option.equals("6") || option.equals("7")
                || option.equals("8") || option.equals("9")));
    }

}
