package SchoolApplication;

import java.util.Scanner;

public class MainClass {
//  Assignment oral mark and local mark should not be initialized with assignment, as this is per student 
//    the options appeat twice in some cases
    
    static Scanner input = new Scanner(System.in);
    private static final RealSchool school = new RealSchool();
    public static final Database db = new Database();

    public static void main(String[] args) {

        Printing.printWelcomeMessage();

        String option = null;

        do {
            Printing.printUserOptions();
            option = input.nextLine();
            switch (option) {
                case "-as":
                    school.addStudentToSchool();
                    break;
                case "-at":
                    school.addTrainerToSchool();
                    break;
                case "-aa":
                    school.addAssignmentToSchool();
                    break;
                case "-ac":
                    school.addCourseToSchool();
                    break;
                case "-ps":
                    school.printAllStudents();
                    break;
                case "-pt":
                    school.printAllTrainers();
                    break;
                case "-pa":
                    school.printAllAssignments();
                    break;
                case "-pc":
                    school.printAllCourses();
                    break;
                case "-asc":
                   school.addStudentToCourse();
                    break;
//                case "-aac":
//                    school.addAssignmentToCourse();
//                    break;
                case "-atc":
                    school.addTrainerToCourse();
                    break;
                case "-psc":
                    school.printStudentsInCourse();
                    break;
//                case "-ptc":
//                    school.printTrainersInCourse();
//                    break;
//                case "-pac":
//                    school.printAssignmentsInCourse();
//                    break;
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
