package SchoolApplication;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Utils {
    
    public static boolean realSchoolIsEmpty(School s){
        return s.getListOfAssignments().isEmpty() && s.getListOfCourses().isEmpty() && s.getListOfStudents().isEmpty() && s.getListOfTrainers().isEmpty();
    }

    public static int chooseElementFromPrintout(String message, int lowerBound, int upperBound) {
        int number;
        do {
            System.out.print(message);
            while (!MainClass.input.hasNextInt()) {
                System.out.print(message);
                MainClass.input.next();
            }
            number = MainClass.input.nextInt();
        } while (number <= lowerBound || number > upperBound);
        return number - 1;
    }

    public static Course selectCourse(School school) {
        int lengthOfCourseList = school.getListOfCourses().size();
        int courseIndex = Utils.chooseElementFromPrintout("You can choose the course using its ID.\nCourse ID: ", 0, lengthOfCourseList);
        Course selectedCourse = school.getListOfCourses().get(courseIndex);
        return selectedCourse;
    }

    public static ArrayList selectAssignments(School school) {
        ArrayList<Assignment> selectedAssignments = new ArrayList();
        do {
            int lengthOfAssignmentsList = school.getListOfAssignments().size();
            int asignmentIndex = Utils.chooseElementFromPrintout("You can choose an assignment using its ID.\nAssignment ID: ", 0, lengthOfAssignmentsList);
            Assignment selectedAssignment = school.getListOfAssignments().get(asignmentIndex);
            selectedAssignments.add(selectedAssignment);
            System.out.println("Would you like to add another assignment? Y: Yes");
        } while ("Y".equals(MainClass.input.next()));
        return selectedAssignments;
    }

    public static ArrayList selectTrainers(School school) {
        ArrayList<Trainer> selectedTrainers = new ArrayList();
        do {
            int lengthOfTrainerList = school.getListOfTrainers().size();
            int trainerIndex = Utils.chooseElementFromPrintout("You can choose a trainer using his/her ID.\nTrainer ID: ", 0, lengthOfTrainerList);
            Trainer selectedTrainer = school.getListOfTrainers().get(trainerIndex);
            selectedTrainers.add(selectedTrainer);
            System.out.println("Would you like to add another trainer? Y: Yes");
        } while ("Y".equals(MainClass.input.next()));
        return selectedTrainers;
    }

    public static ArrayList selectStudents(School school) {
        ArrayList<Student> selectedStudents = new ArrayList();
        do {
            int lengthOfStudentList = school.getListOfStudents().size();
            int studentIndex = Utils.chooseElementFromPrintout("You can choose a student using his/her ID.\nStudent ID: ", 0, lengthOfStudentList);
            Student selectedStudent = school.getListOfStudents().get(studentIndex);
            selectedStudents.add(selectedStudent);
            System.out.println("Would you like to add another student? Y: Yes");
        } while ("Y".equals(MainClass.input.next()));
        return selectedStudents;
    }

    public static String getStringWithMessage(String message) {
        System.out.print(message);
        return MainClass.input.next();
    }

    public static LocalDate getDate(String message) {
        System.out.print(message);
        LocalDate localDate = null;
        while (localDate == null) {
            try {
                String date = MainClass.input.next();
                while (date.charAt(4) != '-' || date.charAt(7) != '-' || date.length() != 10) {
                    System.out.print("Please provide the date in the format YYYY-MM-DD: ");
                    date = MainClass.input.next();
                }
                String[] dateArray = date.split("-");
                int year = Integer.parseInt(dateArray[0]);
                int month = Integer.parseInt(dateArray[1]);
                int day = Integer.parseInt(dateArray[2]);
                localDate = LocalDate.of(year, month, day);
            } catch (NumberFormatException e) {
                System.out.print("Please provide the date in the format YYYY-MM-DD: ");
            } catch (DateTimeException e) {
                System.out.print("Please make sure you add the correct date:");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Please provide the date in the format YYYY-MM-DD: ");
            }
        }
        return localDate;
    }

    public static int getIntNumber(String message1, String message2, int lowerBound, int upperBound) {
        int number;
        do {
            System.out.print(message1);
            while (!MainClass.input.hasNextInt()) {
                System.out.print(message2);
                MainClass.input.next();
            }
            number = MainClass.input.nextInt();
        } while (number <= lowerBound || number >= upperBound);
        return number;
    }
}
