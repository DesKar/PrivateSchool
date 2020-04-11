package SchoolApplication;

import java.util.Scanner;

public class MainClass {
//  Assignment oral mark and local mark should not be initialized with assignment, as this is per student 
//    the options appeat twice in some cases
    
    static Scanner input = new Scanner(System.in);
    public static final Database db = new Database();

    public static void main(String[] args) {

        Printing.printWelcomeMessage();

        String option = null;
        do {
            Printing.printUserOptions();
            option = input.nextLine();
            switch (option) {
                case "-as":
                    ObjectFactory.addStudentToSchool();
                    break;
                case "-at":
                    ObjectFactory.addTrainerToSchool();
                    break;
                case "-aa":
                    ObjectFactory.addAssignmentToSchool();
                    break;
                case "-ac":
                    ObjectFactory.addCourseToSchool();
                    break;
                case "-ps":
                    School.printAllStudents();
                    break;
                case "-pt":
                    School.printAllTrainers();
                    break;
                case "-pa":
                    School.printAllAssignments();
                    break;
                case "-pc":
                    School.printAllCourses();
                    break;
                case "-asc":
                   School.addStudentToCourse();
                    break;
                case "-aac":
                    School.addAssignmentToCourse();
                    break;
                case "-atc":
                    School.addTrainerToCourse();
                    break;
                case "-psc":
                    School.printStudentsInCourse();
                    break;
                case "-ptc":
                    School.printTrainersInCourse();
                    break;
                case "-pac":
                    School.printAssignmentsInCourse();
                    break;
//                case "-paps":
////                    school.printAssignmentsPerStudent();
//                    break;
//                case "-psmc":
//                    school.printStudentsInManyCourses();
//                    break;
//                case "-pscw":
//                    school.printStudentsToDeliverWithinCW();
//                    break;
                case "-q":
                    System.out.println("Thank you for using the School Application!");
                    input.close();
                    break;
                default:
                    break;
            }

        } while (!option.equals("-q"));

    }

}
