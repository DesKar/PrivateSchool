package SchoolApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);
    private static RealSchool realSchool = new RealSchool();
    private static SyntheticSchool syntheticSchool = new SyntheticSchool();

    public static void main(String[] args) {

        System.out.println("Welcome to the School Application!\n");
        String option = null;

        do {
            printUserOptions();
            option = input.next();
            switch (option) {
                case "-as":
                    realSchool.addStudentInSchool();
                    break;
                case "-at":
                    realSchool.addTrainerInSchool();
                    break;
                case "-aa":
                    realSchool.addAssignmentInSchool();
                    break;
                case "-ac":
                    realSchool.addCourseInSchool();
                    break;
                case "-ps":
                    printStudents();
                    break;
                case "-pt":
                    printTrainers();
                    break;
                case "-pa":
                    printAssignments();
                    break;
                case "-pc":
                    printCourses();
                    break;
                case "-q":
                    System.out.println("Thank you for using the School Application!");
                    break;
                case "-asc":
                    addStudentToCourse();

                    break;
                default:
                    break;
            }

        } while (!option.equals("-q"));

    }

    public static void printStudents() {
        ArrayList<Student> listOfStudentsInRealSchool = realSchool.getListOfStudents();
        if (listOfStudentsInRealSchool.isEmpty()){
            syntheticSchool.printListOfStudents();
        }else{
            realSchool.printListOfStudents();
        }

    }

    public static void printTrainers() {
        ArrayList<Trainer> listOfTrainersInRealSchool = realSchool.getListOfTrainers();
        if (listOfTrainersInRealSchool.isEmpty() ) {
            syntheticSchool.printListOfTrainers();
        } else {
            realSchool.printListOfTrainers();
        }

    }

    public static void printAssignments() {
        ArrayList<Assignment> listOfAssignmentsInRealSchool = realSchool.getListOfAssignments();
        if (listOfAssignmentsInRealSchool.isEmpty()) {
            syntheticSchool.printListOfAssignments();
        } else {
            realSchool.printListOfAssignments();
        }
    }

    public static void printCourses() {
        ArrayList<Course> listOfCoursesInRealSchool = realSchool.getListOfCourses();
        if (listOfCoursesInRealSchool.isEmpty()) {
            syntheticSchool.printListOfCourses();
        } else {
            realSchool.printListOfCourses();
        }

    }

    public static void addStudentToCourse() {
        System.out.println("Please choose a course to add students to: ");
        printCourses();
        int courseChosen = input.nextInt();
        printStudents();

    }

    public static void printUserOptions() {
        System.out.println("Please type: ");
        System.out.println("-as to add a student");
        System.out.println("-at to add a trainer");
        System.out.println("-aa to add an assignment");
        System.out.println("-ac to add a course");
        System.out.println("");

        System.out.println("-ps to print all students");
        System.out.println("-pt to print all trainers");
        System.out.println("-pa to print all assignments");
        System.out.println("-pc to print all courses");
        System.out.println("");

        System.out.println("-asc to add a student in a course");
        System.out.println("-atc to add a trainer in a course");
        System.out.println("-aac to add an assignment in a course");
        System.out.println("");

        System.out.println("-psc to print all students in a course");
        System.out.println("-ptc to print all trainers in a course");
        System.out.println("-pac to print all assignments in a course");
        System.out.println("");

        System.out.println("-paps to print all assignents per student");
        System.out.println("-pscs to print all students that belong to more than one course");
        System.out.println("");

        System.out.println("-q to exit\n");
    }
}
