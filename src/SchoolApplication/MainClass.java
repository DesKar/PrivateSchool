package SchoolApplication;

import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {

    static Scanner input = new Scanner(System.in);
    private static RealSchool realSchool = new RealSchool();
    private static SyntheticSchool syntheticSchool = new SyntheticSchool();

    public static void main(String[] args) {

        Printing.printWelcomeMessage();

        String option = null;

        do {
            Printing.printUserOptions();
            option = input.next();
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
                case "-asc":
                    addStudentToCourse();
                    break;
                case "-aac":
                    addAssignmentToCourse();
                    break;
                case "-atc":
                    addTrainerToCourse();
                    break;
                case "-psc":
                    printStudentsInCourse();
                    break;
                case "-ptc":
                    printTrainersInCourse();
                    break;
                case "-pac":
                    printAssignmentsInCourse();
                    break;
                case "-paps":
                    printAsignemntsPerStudent();
                    break;
                case "-q":
                    System.out.println("Thank you for using the School Application!");
                    break;
                default:
                    break;
            }

        } while (!option.equals("-q"));

    }

    public static void printStudents() {
        ArrayList<Student> listOfStudentsInRealSchool = realSchool.getListOfStudents();
        if (listOfStudentsInRealSchool.isEmpty()) {
            Printing.printListOfStudents(syntheticSchool.getListOfStudents());
        } else {
            Printing.printListOfStudents(realSchool.getListOfStudents());
        }

    }

    public static void printTrainers() {
        ArrayList<Trainer> listOfTrainersInRealSchool = realSchool.getListOfTrainers();
        if (listOfTrainersInRealSchool.isEmpty()) {
            Printing.printListOfTrainers(syntheticSchool.getListOfTrainers());
        } else {
            Printing.printListOfTrainers(realSchool.getListOfTrainers());
        }

    }

    public static void printAssignments() {
        ArrayList<Assignment> listOfAssignmentsInRealSchool = realSchool.getListOfAssignments();
        if (listOfAssignmentsInRealSchool.isEmpty()) {
            Printing.printListOfAssignments(syntheticSchool.getListOfAssignments());
        } else {
            Printing.printListOfAssignments(realSchool.getListOfAssignments());
        }
    }

    public static void printCourses() {
        ArrayList<Course> listOfCoursesInRealSchool = realSchool.getListOfCourses();
        if (listOfCoursesInRealSchool.isEmpty()) {
            Printing.printListOfCourses(syntheticSchool.getListOfCourses());
        } else {
            Printing.printListOfCourses(realSchool.getListOfCourses());

        }

    }

    public static void addStudentToCourse() {
        if (!realSchool.getListOfCourses().isEmpty() && !realSchool.getListOfStudents().isEmpty()) {
            System.out.println("Please choose a course from the list below:");
            printCourses();

            Course selectedCourse = Utils.selectCourse(realSchool);

            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
            System.out.println("Please choose students to add to the selected course.\n");
            printStudents();

            ArrayList<Student> selectedStudents = Utils.selectStudents(realSchool);

            StudentsInCourse studentsInCourse = new StudentsInCourse(selectedCourse, selectedStudents);
            realSchool.addStudentsInCourseToListOfStudentsInCourse(studentsInCourse);

        } else if (realSchool.getListOfCourses().isEmpty()) {
            System.out.println("There are no courses added. Please add a course to continue.");
        } else if (realSchool.getListOfStudents().isEmpty()) {
            System.out.println("There are no students added. Please add a student to continue.");
        }

    }

    public static void addTrainerToCourse() {
        if (!realSchool.getListOfCourses().isEmpty() && !realSchool.getListOfTrainers().isEmpty()) {
            System.out.println("Please choose a course from the list below:");
            printCourses();

            Course selectedCourse = Utils.selectCourse(realSchool);

            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
            System.out.println("Please choose trainers to add to the selected course.\n");
            printTrainers();

            ArrayList<Trainer> selectedTrainers = Utils.selectTrainers(realSchool);

            TrainersInCourse trainersInCourse = new TrainersInCourse(selectedCourse, selectedTrainers);
            realSchool.addTrainersInCourseToListOfTrainersInCourse(trainersInCourse);

        } else if (realSchool.getListOfCourses().isEmpty()) {
            System.out.println("There are no courses added. Please add a course to continue.");
        } else if (realSchool.getListOfTrainers().isEmpty()) {
            System.out.println("There are no trainers added. Please add a trainer to continue.");
        }

    }

    public static void addAssignmentToCourse() {
        if (!realSchool.getListOfCourses().isEmpty() && !realSchool.getListOfAssignments().isEmpty()) {
            System.out.println("Please choose a course from the list below:");
            printCourses();

            Course selectedCourse = Utils.selectCourse(realSchool);

            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
            System.out.println("Please choose assignments to add to the selected course.\n");
            printAssignments();

            ArrayList<Assignment> selectedAssignments = Utils.selectAssignments(realSchool);

            AssignmentsInCourse assignmentsInCourse = new AssignmentsInCourse(selectedCourse, selectedAssignments);
            realSchool.addAssignmentsInCourseToListOfAssignmentsInCourse(assignmentsInCourse);

        } else if (realSchool.getListOfCourses().isEmpty()) {
            System.out.println("There are no courses added. Please add a course to continue.");
        } else if (realSchool.getListOfAssignments().isEmpty()) {
            System.out.println("There are no assignments added. Please add an assignment to continue.");
        }
    }

    public static void printStudentsInCourse() {
        ArrayList<StudentsInCourse> coursesThatHaveAssignedStudents;
        ArrayList<Course> coursesToBePrinted = new ArrayList();

        if (realSchool.getListOfCourses().isEmpty() || realSchool.getListOfStudents().isEmpty() || realSchool.getListOfStudentsInCourse().isEmpty()) {
            System.out.println("There are no courses or students in the school or there are no students assigned in the courses.");
            System.out.println("The synthetic data is going to be printed below:");
            coursesThatHaveAssignedStudents = syntheticSchool.getListOfStudentsInCourse();
        } else {
            coursesThatHaveAssignedStudents = realSchool.getListOfStudentsInCourse();
        }

        for (StudentsInCourse studentsInCourse : coursesThatHaveAssignedStudents) {
            Course course = studentsInCourse.getCourse();
            coursesToBePrinted.add(course);
        }

        Printing.printListOfCourses(coursesToBePrinted);

        int lengthOfCourseList = coursesThatHaveAssignedStudents.size();
        int selectedCourseIndex = Utils.chooseElementFromPrintout("Choose a course to print its students:", 0, lengthOfCourseList);

        Course selectedCourse = coursesThatHaveAssignedStudents.get(selectedCourseIndex).getCourse();

        System.out.println("");
        System.out.println("The course you have selected is ");
        System.out.println(selectedCourse.toString());
        System.out.println("");

        ArrayList<Student> listOfStudents = coursesThatHaveAssignedStudents.get(selectedCourseIndex).getListOfStudents();
        System.out.println("The students of this course are: ");
        Printing.printListOfStudents(listOfStudents);
    }

    public static void printTrainersInCourse() {
        ArrayList<TrainersInCourse> coursesThatHaveAssignedTrainers;
        ArrayList<Course> coursesToBePrinted = new ArrayList();

        if (realSchool.getListOfCourses().isEmpty() || realSchool.getListOfTrainers().isEmpty() || realSchool.getListOfTrainersInCourse().isEmpty()) {
            System.out.println("There are no courses or trainers in the school or there are no trainers assigned in the courses.");
            System.out.println("The synthetic data is going to be printed below:");
            coursesThatHaveAssignedTrainers = syntheticSchool.getListOfTrainersInCourse();
        } else {
            coursesThatHaveAssignedTrainers = realSchool.getListOfTrainersInCourse();
        }

        for (TrainersInCourse trainersInCourse : coursesThatHaveAssignedTrainers) {
            Course course = trainersInCourse.getCourse();
            coursesToBePrinted.add(course);
        }

        Printing.printListOfCourses(coursesToBePrinted);

        int lengthOfCourseList = coursesThatHaveAssignedTrainers.size();
        int selectedCourseIndex = Utils.chooseElementFromPrintout("Choose a course to print its trainers:", 0, lengthOfCourseList);

        Course selectedCourse = coursesThatHaveAssignedTrainers.get(selectedCourseIndex).getCourse();

        System.out.println("");
        System.out.println("The course you have selected is ");
        System.out.println(selectedCourse.toString());
        System.out.println("");

        System.out.println("The trainers of this course are: ");
        ArrayList<Trainer> listOfTrainers = coursesThatHaveAssignedTrainers.get(selectedCourseIndex).getListOfTrainers();
        Printing.printListOfTrainers(listOfTrainers);

    }

    public static void printAssignmentsInCourse() {
        ArrayList<AssignmentsInCourse> coursesThatHaveAssignedAssignments;
        ArrayList<Course> coursesToBePrinted = new ArrayList();

        if (realSchool.getListOfCourses().isEmpty() || realSchool.getListOfAssignments().isEmpty() || realSchool.getListOfAssignmentsInCourse().isEmpty()) {
            System.out.println("There are no courses or assignments in the school or there are no assignments assigned in the courses.");
            System.out.println("The synthetic data is going to be printed below:");
            coursesThatHaveAssignedAssignments = syntheticSchool.getListOfAssignmentsInCourse();
        } else {
            coursesThatHaveAssignedAssignments = realSchool.getListOfAssignmentsInCourse();
        }

        for (AssignmentsInCourse assignments : coursesThatHaveAssignedAssignments) {
            Course course = assignments.getCourse();
            coursesToBePrinted.add(course);
        }

        Printing.printListOfCourses(coursesToBePrinted);

        int lengthOfCourseList = coursesThatHaveAssignedAssignments.size();
        int selectedCourseIndex = Utils.chooseElementFromPrintout("Choose a course to print its assignments:", 0, lengthOfCourseList);

        Course selectedCourse = coursesThatHaveAssignedAssignments.get(selectedCourseIndex).getCourse();

        System.out.println("");
        System.out.println("The course you have selected is ");
        System.out.println(selectedCourse.toString());
        System.out.println("");

        System.out.println("The assignments of this course are: ");
        ArrayList<Assignment> listOfAssignments = coursesThatHaveAssignedAssignments.get(selectedCourseIndex).getListOfAssignments();
        Printing.printListOfAssignments(listOfAssignments);

    }

    public static void printAsignemntsPerStudent() {

        ArrayList<Student> listOfStudents = syntheticSchool.getListOfStudents(); //to be extended to realSchool

        System.out.println("Please choose a student to see his/her assignments: ");
        Printing.printListOfStudents(listOfStudents);

        int lengthOfStudentList = syntheticSchool.getListOfStudents().size();
        int studentIndex = Utils.chooseElementFromPrintout("You can choose a student using his/her ID.\nStudent ID: ", 0, lengthOfStudentList);

        Student selectedStudent = syntheticSchool.getListOfStudents().get(studentIndex);

        ArrayList<Course> listOfCoursesTheStudentIsAssignedTo = new ArrayList();
        

        for (StudentsInCourse studentsInCourse : syntheticSchool.getListOfStudentsInCourse()) {
            ArrayList<Student> listOfStudentsInCourse = studentsInCourse.getListOfStudents();
            for (Student student : listOfStudentsInCourse) {
                if (student == selectedStudent) {
                    listOfCoursesTheStudentIsAssignedTo.add(studentsInCourse.getCourse());
                }

            }
        }
       Printing.printListOfCourses(listOfCoursesTheStudentIsAssignedTo);

        ArrayList<Assignment> listOfAssignmentsToPrint = new ArrayList();
        for (Course course : listOfCoursesTheStudentIsAssignedTo) {
            for (AssignmentsInCourse assignmentInCourse : syntheticSchool.getListOfAssignmentsInCourse()) {
                if (course == assignmentInCourse.getCourse()) {
                    ArrayList<Assignment> listOfAssigments = assignmentInCourse.getListOfAssignments();
                    for (Assignment assignment : listOfAssigments) {
                        listOfAssignmentsToPrint.add(assignment);
                    }
                }

            }
        }

        Printing.printListOfAssignments(listOfAssignmentsToPrint);
    }

}
