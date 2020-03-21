package privateschool;

import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the School Application! What would you like to do?");
        String option = "-q";

//        RealSchool realSchool = new RealSchool();
//        realSchoolCase(option, realSchool);

        SyntheticSchool syntheticSchool = new SyntheticSchool();
        syntheticSchoolCase(option, syntheticSchool);

    }

    public static void realSchoolCase(String option, RealSchool realSchool) {
        do {
            printUserOptions();
            option = input.next();
            if (option.equals("-as")) {
                System.out.println("adding student");
                realSchool.addStudentInSchool();
            } else if (option.equals("-at")) {
                System.out.println("adding trainer");
                realSchool.addTrainerInSchool();
            } else if (option.equals("-aa")) {
                System.out.println("Adding assignment");
                realSchool.addAssignmentInSchool();
            } else if (option.equals("-ac")) {
                System.out.println("Adding course");
                realSchool.addCourseInSchool();
            } else if (option.equals("-ps")) {
                System.out.println("printing students");
                realSchool.printListOfStudents();
            } else if (option.equals("-pt")) {
                System.out.println("printing trainers");
                realSchool.printListOfTrainers();
            } else if (option.equals("-pa")) {
                System.out.println("printing assignments");
                realSchool.printListOfAssignments();
            } else if (option.equals("-pc")) {
                System.out.println("printing courses");
                realSchool.printListOfCourses();
            } else if (option.equals("-q")) {
                System.out.println("Exiting");
            }
        } while (!option.equals("-q"));
    }

    public static void syntheticSchoolCase(String option, SyntheticSchool syntheticSchool) {
        syntheticSchool.addStudentsInSchool();
        syntheticSchool.addTrainersInSchool();
        syntheticSchool.addAssignmentsInSchool();
        syntheticSchool.addCoursesInSchool();
        do {
            printUserOptions();
            option = input.next();
            if (option.equals("-ps")) {
                System.out.println("printing students");
                syntheticSchool.printListOfStudents();
            } else if (option.equals("-pt")) {
                System.out.println("printing trainers");
                syntheticSchool.printListOfTrainers();
            } else if (option.equals("-pa")) {
                System.out.println("printing assignments");
                syntheticSchool.printListOfAssignments();
            } else if (option.equals("-pc")) {
                System.out.println("printing courses");
                syntheticSchool.printListOfCourses();
            } else if (option.equals("-q")) {
                System.out.println("Exiting");
            }
        } while (!option.equals("-q"));
    }

    public static void printUserOptions() {
        System.out.println("Please type: ");
        System.out.println("-as to add a student");
        System.out.println("-at to add a trainer");
        System.out.println("-aa to add an assignment");
        System.out.println("-ac to add a course");
        System.out.println("-ps to print all students");
        System.out.println("-pt to print all trainers");
        System.out.println("-pa to print all assignments");
        System.out.println("-pc to print all courses");
        System.out.println("-q to exit");
    }
}
