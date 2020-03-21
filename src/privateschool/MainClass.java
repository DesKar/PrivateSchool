package privateschool;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the School Application! What would you like to do?");
        String option = null;

        RealSchool realSchool = new RealSchool();
        SyntheticSchool syntheticSchool = new SyntheticSchool();

        do {
            printUserOptions();
            option = input.next();
            switch (option) {
                case "-as":
                    System.out.println("adding student");
                    addStudent(realSchool, syntheticSchool);
                    break;
                case "-at":
                    System.out.println("adding trainer");
                    addTrainer(realSchool, syntheticSchool);
                    break;
                case "-aa":
                    System.out.println("Adding assignment");
                    addAssignment(realSchool, syntheticSchool);
                    break;
                case "-ac":
                    System.out.println("Adding course");
                    addCourse(realSchool, syntheticSchool);
                    break;
                case "-ps":
                    System.out.println("printing students");
                    printStudents(realSchool, syntheticSchool);
                    break;
                case "-pt":
                    System.out.println("printing trainers");
                    printTrainers(realSchool, syntheticSchool);
                    break;
                case "-pa":
                    System.out.println("printing assignments");
                    printAssignments(realSchool, syntheticSchool);
                    break;
                case "-pc":
                    System.out.println("printing courses");
                    printCourses(realSchool, syntheticSchool);
                    break;
                case "-q":
                    System.out.println("Thank you for using the School Application!");
                    break;
                default:
                    break;
            }

        } while (!option.equals("-q"));

    }

    public static void addStudent(RealSchool realSchool, SyntheticSchool syntheticSchool) {
        ArrayList<Student> listOfStudentsInSyntheticSchool = syntheticSchool.getListOfStudents();
        if (!listOfStudentsInSyntheticSchool.isEmpty()) {
            realSchool.addStudentInSchool();
            syntheticSchool.getListOfStudents().clear();

        } else {
            realSchool.addStudentInSchool();
        }

    }

    public static void addTrainer(RealSchool realSchool, SyntheticSchool syntheticSchool) {
        ArrayList<Trainer> listOfTrainersInSyntheticSchool = syntheticSchool.getListOfTrainers();
        if (!listOfTrainersInSyntheticSchool.isEmpty()) {
            realSchool.addTrainerInSchool();
            syntheticSchool.getListOfTrainers().clear();

        } else {
            realSchool.addTrainerInSchool();
        }

    }

    public static void addAssignment(RealSchool realSchool, SyntheticSchool syntheticSchool) {
        ArrayList<Assignment> listOfAssignmentsInSyntheticSchool = syntheticSchool.getListOfAssignments();
        if (!listOfAssignmentsInSyntheticSchool.isEmpty()) {
            realSchool.addAssignmentInSchool();
            syntheticSchool.getListOfAssignments().clear();

        } else {
            realSchool.addAssignmentInSchool();
        }

    }

    public static void addCourse(RealSchool realSchool, SyntheticSchool syntheticSchool) {
        ArrayList<Course> listOfCoursesInSyntheticSchool = syntheticSchool.getListOfCourses();
        if (!listOfCoursesInSyntheticSchool.isEmpty()) {
            realSchool.addCourseInSchool();
            syntheticSchool.getListOfCourses().clear();

        } else {
            realSchool.addCourseInSchool();
        }

    }

    public static void printStudents(RealSchool realSchool, SyntheticSchool syntheticSchool) {
        ArrayList<Student> listOfStudentsInRealSchool = realSchool.getListOfStudents();
        ArrayList<Student> listOfStudentsInSyntheticData = syntheticSchool.getListOfStudents();
        if (listOfStudentsInRealSchool.isEmpty() && listOfStudentsInSyntheticData.isEmpty()) {
            syntheticSchool.addStudentsInSchool();
            syntheticSchool.printListOfStudents();

        } else if (listOfStudentsInRealSchool.isEmpty()) {
            syntheticSchool.printListOfStudents();
        } else {
            realSchool.printListOfStudents();
        }

    }

    public static void printTrainers(RealSchool realSchool, SyntheticSchool syntheticSchool) {
        ArrayList<Trainer> listOfTrainersInRealSchool = realSchool.getListOfTrainers();
        ArrayList<Trainer> listOfTrainersInSyntheticSchool = syntheticSchool.getListOfTrainers();
        if (listOfTrainersInRealSchool.isEmpty() && listOfTrainersInSyntheticSchool.isEmpty()) {
            syntheticSchool.addTrainersInSchool();
            syntheticSchool.printListOfTrainers();

        } else if (listOfTrainersInRealSchool.isEmpty()) {
            syntheticSchool.printListOfTrainers();
        } else {
            realSchool.printListOfTrainers();
        }

    }

    public static void printAssignments(RealSchool realSchool, SyntheticSchool syntheticSchool) {
        ArrayList<Assignment> listOfAssignmentsInRealSchool = realSchool.getListOfAssignments();
        ArrayList<Assignment> listOfAssignmentsInSyntheticSchool = syntheticSchool.getListOfAssignments();
        if (listOfAssignmentsInRealSchool.isEmpty() && listOfAssignmentsInSyntheticSchool.isEmpty()) {
            syntheticSchool.addAssignmentsInSchool();
            syntheticSchool.printListOfAssignments();

        } else if (listOfAssignmentsInRealSchool.isEmpty()) {
            syntheticSchool.printListOfAssignments();
        } else {
            realSchool.printListOfAssignments();
        }
    }

    public static void printCourses(RealSchool realSchool, SyntheticSchool syntheticSchool) {
        ArrayList<Course> listOfCoursesInRealSchool = realSchool.getListOfCourses();
        ArrayList<Course> listOfCoursesInSyntheticSchool = syntheticSchool.getListOfCourses();
        if (listOfCoursesInRealSchool.isEmpty() && listOfCoursesInSyntheticSchool.isEmpty()) {
            syntheticSchool.addCoursesInSchool();
            syntheticSchool.printListOfCourses();

        } else if (listOfCoursesInRealSchool.isEmpty()) {
            syntheticSchool.printListOfCourses();
        } else {
            realSchool.printListOfCourses();
        }

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
        System.out.println("-q to exit\n");
    }
}
