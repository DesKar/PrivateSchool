package SchoolApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);
    private static RealSchool realSchool = new RealSchool();
    private static SyntheticSchool syntheticSchool = new SyntheticSchool();

    public static void main(String[] args) {

        System.out.println("Welcome to the School Application!");
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

            Course selectedCourse = selectCourse();

            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
            System.out.println("Please choose students to add to the selected course.\n");
            printStudents();

            ArrayList<Student> selectedStudents = selectStudents();

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

            Course selectedCourse = selectCourse();

            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
            System.out.println("Please choose trainers to add to the selected course.\n");
            printTrainers();

            ArrayList<Trainer> selectedTrainers = selectTrainers();

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

            Course selectedCourse = selectCourse();

            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
            System.out.println("Please choose assignments to add to the selected course.\n");
            printAssignments();

            ArrayList<Assignment> selectedAssignments = selectAssignments();

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
        int selectedCourseIndex = chooseElementFromList("Choose a course to print its students:", 0, lengthOfCourseList);

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
        int selectedCourseIndex = chooseElementFromList("Choose a course to print its trainers:", 0, lengthOfCourseList);

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
        int selectedCourseIndex = chooseElementFromList("Choose a course to print its assignments:", 0, lengthOfCourseList);

        Course selectedCourse = coursesThatHaveAssignedAssignments.get(selectedCourseIndex).getCourse();

        System.out.println("");
        System.out.println("The course you have selected is ");
        System.out.println(selectedCourse.toString());
        System.out.println("");

        System.out.println("The assignments of this course are: ");
        ArrayList<Assignment> listOfAssignments = coursesThatHaveAssignedAssignments.get(selectedCourseIndex).getListOfAssignments();
        Printing.printListOfAssignments(listOfAssignments);

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

    public static ArrayList selectTrainers() {
        ArrayList<Trainer> selectedTrainers = new ArrayList();
        do {
            int lengthOfTrainerList = realSchool.getListOfTrainers().size();
            int trainerIndex = chooseElementFromList("You can choose a trainer using his/her ID.\nTrainer ID: ", 0, lengthOfTrainerList);
            Trainer selectedTrainer = realSchool.getListOfTrainers().get(trainerIndex);

            selectedTrainers.add(selectedTrainer);

            System.out.println("Would you like to add another trainer? Y: Yes");
        } while ("Y".equals(input.next()));

        return selectedTrainers;
    }

    public static ArrayList selectAssignments() {
        ArrayList<Assignment> selectedAssignments = new ArrayList();
        do {
            int lengthOfAssignmentsList = realSchool.getListOfAssignments().size();
            int asignmentIndex = chooseElementFromList("You can choose an assignment using its ID.\nAssignment ID: ", 0, lengthOfAssignmentsList);
            Assignment selectedAssignment = realSchool.getListOfAssignments().get(asignmentIndex);

            selectedAssignments.add(selectedAssignment);

            System.out.println("Would you like to add another assignment? Y: Yes");
        } while ("Y".equals(input.next()));

        return selectedAssignments;
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
        System.out.println("");
        System.out.println("Please type: ");
        System.out.println("-as to add a student"); //Done
        System.out.println("-at to add a trainer"); //Done
        System.out.println("-aa to add an assignment"); //Done
        System.out.println("-ac to add a course"); //Done
        System.out.println("");

        System.out.println("-ps to print all students"); //Done
        System.out.println("-pt to print all trainers"); //Done
        System.out.println("-pa to print all assignments"); //Done
        System.out.println("-pc to print all courses"); //Done
        System.out.println("");

        System.out.println("-asc to add a student to a course"); //Done
        System.out.println("-atc to add a trainer to a course"); //Doone
        System.out.println("-aac to add an assignment to a course"); //Done
        System.out.println("");

        System.out.println("-psc to print all students in a course"); //Done
        System.out.println("-ptc to print all trainers in a course"); //Done
        System.out.println("-pac to print all assignments in a course");
        System.out.println("");

        System.out.println("-paps to print all assignents per student");
        System.out.println("-pscs to print all students that belong to more than one course");
        System.out.println("");

        System.out.println("-q to exit\n");
    }
}
