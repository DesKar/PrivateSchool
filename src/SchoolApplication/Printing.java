package SchoolApplication;

import java.util.ArrayList;

public class Printing {
//TODO improve welcome message with a banner

    public static void printWelcomeMessage() {
        System.out.println(" _    _        _                               \n"
                + "| |  | |      | |                              \n"
                + "| |  | |  ___ | |  ___   ___   _ __ ___    ___ \n"
                + "| |/\\| | / _ \\| | / __| / _ \\ | '_ ` _ \\  / _ \\\n"
                + "\\  /\\  /|  __/| || (__ | (_) || | | | | ||  __/\n"
                + " \\/  \\/  \\___||_| \\___| \\___/ |_| |_| |_| \\___|\n"
                + "                                               ");
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
        System.out.println("-pac to print all assignments in a course"); //Done
        System.out.println("");

        System.out.println("-paps to print all assignents per student");
        System.out.println("-pscs to print all students that belong to more than one course");
        System.out.println("");

        System.out.println("-q to exit\n");
    }

    public static void printListOfStudents(ArrayList<Student> listOfStudents) {
        System.out.println("--------------------------------Students-------------------------------");
        String header = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", "ID", "First name", "Last name", "Date of Birth", "Tuition Fees(€)");
        System.out.println(header);
        int index = 1;
        for (Student student : listOfStudents) {
            String content = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", index, student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
            System.out.println(content);
            index++;
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void printListOfTrainers(ArrayList<Trainer> listOfTrainers) {
        System.out.println("----------------Trainers---------------");
        String header = String.format("|%-5s|%-15s|%-15s|", "ID", "First Name", "Last Name");
        System.out.println(header);
        int index = 1;
        for (Trainer trainer : listOfTrainers) {
            String content = String.format("|%-5s|%-15s|%-15s|", index, trainer.getFirstName(), trainer.getLastName());
            System.out.println(content);
            index++;
        }
        System.out.println("---------------------------------------");
    }

    public static void printListOfAssignments(ArrayList<Assignment> listOfAssignments) {
        System.out.println("-------------------------------------------------------Assignments-------------------------------------------------------");
        String header = String.format("|%-5s|%-25s|%-40s|%-18s|%-13s|%-13s|", "ID", "Title", "Description", "Submission Date", "Oral Mark", "Local Mark");
        System.out.println(header);
        int index = 1;
        for (Assignment assignment : listOfAssignments) {
            String content = String.format("|%-5s|%-25s|%-40s|%-18s|%-13d|%-13d|", index, assignment.getTitle(), assignment.getDescription(), assignment.getSubDateTime(), assignment.getOralMark(), assignment.getLocalMark());
            System.out.println(content);
            index++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

    }

    public static void printListOfCourses(ArrayList<Course> listOfCourses) {
        System.out.println("--------------------------------------------------Courses-------------------------------------------------");
        String header = String.format("|%-5s|%-25s|%-30s|%-13s|%-13s|%-13s|", "ID", "Title", "Stream", "Type", "Start Date", "End Date");
        System.out.println(header);
        int index = 1;
        for (Course course : listOfCourses) {
            String content = String.format("|%-5s|%-25s|%-30s|%-13s|%-13s|%-13s|", index, course.getTitle(), course.getStream(), course.getType(), course.getStartDate(), course.getEndDate());
            System.out.println(content);
            index++;
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

}
