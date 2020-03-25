package SchoolApplication;

import java.util.Scanner;

public class MainClass {
//    TODO consider cases when I add more same elements like students, trainers, courses, etc
//    TODO consider cases when I add more than once elements to course, for example many times students to course

    static Scanner input = new Scanner(System.in);
    private static RealSchool realSchool = new RealSchool();
    private static SyntheticSchool syntheticSchool = new SyntheticSchool();

    public static void main(String[] args) {

        Printing.printWelcomeMessage();

        String option = null;

        do {
            Printing.printUserOptions();
            option = input.next();
            School school;
            if (Utils.realSchoolIsEmpty(realSchool)) {
                school = syntheticSchool;
            } else {
                school = realSchool;
            }
            switch (option) {
                case "-as":
                    realSchool.addStudentToSchool();
                    break;
                case "-at":
                    realSchool.addTrainerToSchool();
                    break;
                case "-aa":
                    realSchool.addAssignmentToSchool();
                    break;
                case "-ac":
                    realSchool.addCourseToSchool();
                    break;
                case "-ps":
                    school.printStudents();
                    break;
                case "-pt":
                    school.printTrainers();
                    break;
                case "-pa":
                    school.printAssignments();
                    break;
                case "-pc":
                    school.printCourses();
                    break;
                case "-asc":
                    school.addStudentToCourse();
                    break;
                case "-aac":
                    school.addAssignmentToCourse();
                    break;
                case "-atc":
                    school.addTrainerToCourse();
                    break;
                case "-psc":
                    school.printStudentsInCourse();
                    break;
                case "-ptc":
                    school.printTrainersInCourse();
                    break;
                case "-pac":
                    school.printAssignmentsInCourse();
                    break;
                case "-paps":
                    school.printAsignemntsPerStudent();
                    break;
                case "-psmc":
                    school.printStudentsInManyCourses();
                    break;
                case "-pscw":
                    school.printStudentsToBeDeliveredWithinTheWeek();
                    break;
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
