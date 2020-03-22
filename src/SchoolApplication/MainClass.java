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
        if (listOfStudentsInRealSchool.isEmpty()) {
            syntheticSchool.printListOfStudents();
        } else {
            realSchool.printListOfStudents();
        }

    }

    public static void printTrainers() {
        ArrayList<Trainer> listOfTrainersInRealSchool = realSchool.getListOfTrainers();
        if (listOfTrainersInRealSchool.isEmpty()) {
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
        if (!realSchool.getListOfCourses().isEmpty() && !realSchool.getListOfStudents().isEmpty()) {
            System.out.println("Please choose a course from the list below:");
            printCourses();

            Course selectedCourse = selectCourse();

            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
            System.out.println("Please choose students to add to the selected course.\n");
            printStudents();

            ArrayList<Student> selectedStudents = selectStudents();

            StudentsInCourse studentsInCourse = new StudentsInCourse(selectedCourse, selectedStudents);

            realSchool.addStudentsInCourseInListOfStudentsInCourse(studentsInCourse);
        } else if (realSchool.getListOfCourses().isEmpty()) {
            System.out.println("There are no courses added. Please add a course to continue.");
        } else if (realSchool.getListOfStudents().isEmpty()) {
            System.out.println("There are no students added. Please add a course to continue.");
        }

    }

    public static Course selectCourse() {

        int lengthOfCourseList = realSchool.getListOfCourses().size();
        int courseIndex = chooseElementFromList("You can choose the course using its ID.\nCourse ID: ", 0, lengthOfCourseList);
        Course selectedCourse = realSchool.getListOfCourses().get(courseIndex);
        return selectedCourse;

    }

    public static ArrayList selectStudents() {
        ArrayList<Student> selectedStudents = new ArrayList();
        do {
            int lengthOfStudentList = realSchool.getListOfStudents().size();
            int studentIndex = chooseElementFromList("You can choose a student using his/her ID.\nStudent ID: ", 0, lengthOfStudentList);
            Student selectedStudent = realSchool.getListOfStudents().get(studentIndex);

            selectedStudents.add(selectedStudent);

            System.out.println("Would you like to add another student? Y: Yes");
        } while ("Y".equals(input.next()));

        return selectedStudents;
    }

    public static int chooseElementFromList(String message, int lowerBound, int upperBound) {
        int number;
        do {
            System.out.print(message);
            while (!input.hasNextInt()) {
                System.out.print(message);
                input.next();
            }
            number = input.nextInt();
        } while (number <= lowerBound || number > upperBound);
        return number - 1;
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
