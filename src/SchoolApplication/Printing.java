package SchoolApplication;

import SchoolApplication.models.Trainer;
import SchoolApplication.models.Student;
import SchoolApplication.models.Course;
import SchoolApplication.models.Assignment;
import java.util.Collection;

public class Printing {

    public static void printWelcomeMessage() {
        System.out.println(" _    _        _                               \n"
                + "| |  | |      | |                              \n"
                + "| |  | |  ___ | |  ___   ___   _ __ ___    ___ \n"
                + "| |/\\| | / _ \\| | / __| / _ \\ | '_ ` _ \\  / _ \\\n"
                + "\\  /\\  /|  __/| || (__ | (_) || | | | | ||  __/\n"
                + " \\/  \\/  \\___||_| \\___| \\___/ |_| |_| |_| \\___|\n"
                + "                                               "
                + "\nThis is the Private School Application!\n\n"
                + "You can manage the students, trainers, courses and assingments of your school\n"
                + "or use demo data to explore the application.");
    }

    public static void printDbMenu() {
        System.out.println("");
        System.out.println("Would you like to load the demo database or the real data?");
        System.out.println("");
        System.out.println("Select: ");
        System.out.println(" 1:  Demo Database");
        System.out.println(" 2:  Real Data");
        System.out.println("-q:  Exit");
    }

    public static void printOptionsL1() {
        System.out.println("");
        System.out.println("Choose what you would like to do: ");
        System.out.println(" 1: Add data");
        System.out.println(" 2: Combine data");
        System.out.println(" 3: Print data");
        System.out.println("-q: Exit");
    }

    public static void printUserOptionsAddData() {
        System.out.println("");
        System.out.println("Select: ");
        System.out.println(" 1:  Add a student");
        System.out.println(" 2:  Add a trainer");
        System.out.println(" 3:  Add an assignment");
        System.out.println(" 4:  Add a course");
        System.out.println("-1:  Go back to Main Menu");
        System.out.println("");
    }

    public static void printUserOptionsCombineData() {
        System.out.println("");
        System.out.println("Select: ");
        System.out.println(" 1:  Add a student to a course");
        System.out.println(" 2:  Add a trainer to a course");
        System.out.println(" 3:  Add an assignment to a course");
        System.out.println("-1:  Go back to Main Menu");
        System.out.println("");
    }

    public static void printUserOptionsPrintData() {
        System.out.println("");
        System.out.println("Select: ");
        System.out.println(" 1:  Print all students");
        System.out.println(" 2:  Print all trainers");
        System.out.println(" 3:  Print all assignments");
        System.out.println(" 4:  Print all courses");
        System.out.println(" 5:  Print all students in a course");
        System.out.println(" 6:  Print all trainers in a course");
        System.out.println(" 7:  Print all assignments in a course");
        System.out.println(" 8:  Print all assignents per course per student");
        System.out.println(" 9:  Print all students that belong to more than one courses");
        System.out.println("-1:  Go back to Main Menu");
        System.out.println("");
    }

    public static void printListOfStudents(Collection<Student> students) {
        if (students.isEmpty()) {
            System.out.println("There are no students in the School.");
        } else {
            System.out.println("--------------------------------Students-------------------------------");
            String header = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", "ID", "First name", "Last name", "Date of Birth", "Tuition Fees(€)");
            System.out.println(header);
            int index = 1;
            for (Student student : students) {
                String content = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", student.getId(), student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
                System.out.println(content);
                index++;
            }
            System.out.println("-----------------------------------------------------------------------");
        }

    }

    public static void printListOfTrainers(Collection<Trainer> trainers) {
        if (trainers.isEmpty()) {
            System.out.println("There are no trainers in the School.");
        } else {
            System.out.println("----------------Trainers---------------");
            String header = String.format("|%-5s|%-15s|%-15s|", "ID", "First Name", "Last Name");
            System.out.println(header);
            int index = 1;
            for (Trainer trainer : trainers) {
                String content = String.format("|%-5s|%-15s|%-15s|", trainer.getId(), trainer.getFirstName(), trainer.getLastName());
                System.out.println(content);
                index++;
            }
            System.out.println("---------------------------------------");
        }
    }

    public static void printListOfAssignments(Collection<Assignment> assignments) {
        if (assignments.isEmpty()) {
            System.out.println("There are no assignments in the School.");
        } else {
            System.out.println("-------------------------------------------------------Assignments-------------------------------------------------------");
            String header = String.format("|%-5s|%-25s|%-40s|%-18s|%-13s|%-13s|", "ID", "Title", "Description", "Submission Date", "Oral Mark", "Local Mark");
            System.out.println(header);
            int index = 1;
            for (Assignment assignment : assignments) {
                String content = String.format("|%-5s|%-25s|%-40s|%-18s|%-13d|%-13d|", assignment.getId(), assignment.getTitle(), assignment.getDescription(), assignment.getSubDateTime(), assignment.getOralMark(), assignment.getLocalMark());
                System.out.println(content);
                index++;
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public static void printListOfCourses(Collection<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("There are no courses in the School.");
        } else {
            System.out.println("--------------------------------------------------Courses-------------------------------------------------");
            String header = String.format("|%-5s|%-25s|%-30s|%-13s|%-13s|%-13s|", "ID", "Title", "Stream", "Type", "Start Date", "End Date");
            System.out.println(header);
            int index = 1;
            for (Course course : courses) {
                String content = String.format("|%-5s|%-25s|%-30s|%-13s|%-13s|%-13s|", course.getId(), course.getTitle(), course.getStream(), course.getType(), course.getStartDate(), course.getEndDate());
                System.out.println(content);
                index++;
            }
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
    }

}
