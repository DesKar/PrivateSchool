
package SchoolApplication;

import java.util.ArrayList;


public class Printing {
    
    public static void printListOfStudents(ArrayList<Student> listOfStudents) {
        System.out.println("--------------------------------Students-------------------------------");
        String header = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", "ID", "First name", "Last name", "Date of Birth", "Tuition Fees(€)");
        System.out.println(header);
        int index = 1;
        for (Student student : listOfStudents) {
            String content = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|",index, student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
            System.out.println(content);
            index++;
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void printListOfTrainers(ArrayList<Trainer> listOfTrainers){
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
