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
                case "-atc":
                    addTrainerToCourse();
                    break;
                case "-psc":
                    printStudentsInCourse();
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

            realSchool.addStudentsInCourseToListOfStudentsInCourse(studentsInCourse);
        } else if (realSchool.getListOfCourses().isEmpty()) {
            System.out.println("There are no courses added. Please add a course to continue.");
        } else if (realSchool.getListOfStudents().isEmpty()) {
            System.out.println("There are no students added. Please add a student to continue.");
        }

    }
    
    public static void addTrainerToCourse(){
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

    public static void printStudentsInCourse() {
        ArrayList<StudentsInCourse> coursesThatHaveAssignedStudents;

        if (realSchool.getListOfCourses().isEmpty() || realSchool.getListOfStudents().isEmpty() || realSchool.getListOfStudentsInCourse().isEmpty()) {
            System.out.println("There are no courses or students in the school or there are no students assigned in the courses.");
            System.out.println("The synthetic date is going to be printed below:");
            coursesThatHaveAssignedStudents = syntheticSchool.getListOfStudentsInCourse();
        } else {
            coursesThatHaveAssignedStudents = realSchool.getListOfStudentsInCourse();
        }

        System.out.println("Courses with assgined students:");
        System.out.println("--------------------------------------------------Courses-------------------------------------------------");
        String header = String.format("|%-5s|%-25s|%-30s|%-13s|%-13s|%-13s|", "ID", "Title", "Stream", "Type", "Start Date", "End Date");
        System.out.println(header);

        int index = 1;
        for (StudentsInCourse courseThatHasAssignedStudents : coursesThatHaveAssignedStudents) {
            System.out.println(courseThatHasAssignedStudents.getCourse().print(index));
            index++;
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");

        int lengthOfCourseList = coursesThatHaveAssignedStudents.size();
        int selectedCourseIndex = chooseElementFromList("Choose a course to print its students:", 0, lengthOfCourseList);

        Course selectedCourse = coursesThatHaveAssignedStudents.get(selectedCourseIndex).getCourse();

        System.out.println("");
        System.out.println("The course you have selected is ");
        System.out.println(selectedCourse.toString());
        System.out.println("");

        System.out.println("The students of this course are: ");
        System.out.println("--------------------------------Students-------------------------------");
        header = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", "ID", "First name", "Last name", "Date of Birth", "Tuition Fees(€)");
        System.out.println(header);

        ArrayList<Student> listOfStudents = coursesThatHaveAssignedStudents.get(selectedCourseIndex).getListOfStudents();
        index = 1;
        for (Student student : listOfStudents) {
            System.out.println(student.print(index));
            index++;
        }
        System.out.println("-----------------------------------------------------------------------");
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
    
    public static ArrayList selectTrainers(){
         ArrayList<Trainer> selectedTrainers = new ArrayList();
        do {
            int lengthOfTrainerList = realSchool.getListOfTrainers().size();
            int trainerIndex = chooseElementFromList("You can choose a student using his/her ID.\nStudent ID: ", 0, lengthOfTrainerList);
            Trainer selectedTrainer = realSchool.getListOfTrainers().get(trainerIndex);

            selectedTrainers.add(selectedTrainer);

            System.out.println("Would you like to add another student? Y: Yes");
        } while ("Y".equals(input.next()));

        return selectedTrainers;
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

        System.out.println("-asc to add a student in a course"); //Done
        System.out.println("-atc to add a trainer in a course");
        System.out.println("-aac to add an assignment in a course");
        System.out.println("");

        System.out.println("-psc to print all students in a course"); //Done
        System.out.println("-ptc to print all trainers in a course");
        System.out.println("-pac to print all assignments in a course");
        System.out.println("");

        System.out.println("-paps to print all assignents per student");
        System.out.println("-pscs to print all students that belong to more than one course");
        System.out.println("");

        System.out.println("-q to exit\n");
    }
}
