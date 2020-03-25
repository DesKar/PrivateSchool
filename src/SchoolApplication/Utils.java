package SchoolApplication;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Utils {

    public static boolean realSchoolIsEmpty(School s) {
        return s.getAssignments().isEmpty() && s.getCourses().isEmpty() && s.getStudents().isEmpty() && s.getTrainers().isEmpty();
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
        System.out.println("Please choose a course from the list below: ");
        school.printCourses();
        int lengthOfCourseList = school.getCourses().size();
        int courseIndex = Utils.chooseElementFromPrintout("You can choose the course using its ID.\nCourse ID: ", 0, lengthOfCourseList);
        Course selectedCourse = school.getCourses().get(courseIndex);
        System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
        return selectedCourse;
    }

    public static Course selectCourseFromListOfCourses(ArrayList<Course> listOfCourses, String message) {

        Printing.printListOfCourses(listOfCourses);

        int lengthOfCourseList = listOfCourses.size(); //assuming that the list has only one occurence per course
        int selectedCourseIndex = Utils.chooseElementFromPrintout(message, 0, lengthOfCourseList);

        Course selectedCourse = listOfCourses.get(selectedCourseIndex);

        System.out.println("\nThe course you have selected is: \n");
        System.out.println(selectedCourse.toString());

        return selectedCourse;
    }

    public static ArrayList selectAssignmentsForCourse(School school) {
//        TODO check if selection has already assignment
        ArrayList<Assignment> selectedAssignments = new ArrayList();
        System.out.println("Please choose assignments to add to the selected course.\n");
        school.printAssignments();

        do {
            int lengthOfAssignmentsList = school.getAssignments().size();
            int asignmentIndex = Utils.chooseElementFromPrintout("You can choose an assignment using its ID.\nAssignment ID: ", 0, lengthOfAssignmentsList);
            Assignment selectedAssignment = school.getAssignments().get(asignmentIndex);
            selectedAssignments.add(selectedAssignment);
            System.out.println("Would you like to add another assignment? Y: Yes");
        } while ("Y".equals(MainClass.input.next()));
        return selectedAssignments;
    }

    public static ArrayList selectTrainersForCourse(School school) {
//        TODO check if selection has already trainer
        ArrayList<Trainer> selectedTrainers = new ArrayList();
        System.out.println("Please choose trainers to add to the selected course.\n");
        school.printTrainers();
        do {
            int lengthOfTrainerList = school.getTrainers().size();
            int trainerIndex = Utils.chooseElementFromPrintout("You can choose a trainer using his/her ID.\nTrainer ID: ", 0, lengthOfTrainerList);
            Trainer selectedTrainer = school.getTrainers().get(trainerIndex);
            selectedTrainers.add(selectedTrainer);
            System.out.println("Would you like to add another trainer? Y: Yes");
        } while ("Y".equals(MainClass.input.next()));
        return selectedTrainers;
    }

    public static ArrayList<Student> selectStudentsForCourse(School school) {
        ArrayList<Student> selectedStudents = new ArrayList();
        System.out.println("Please choose students to add to the selected course.\n");
        school.printStudents();
        boolean addAnotherStudent = true;
        do {
            int lengthOfStudentList = school.getStudents().size();
            int studentIndex = Utils.chooseElementFromPrintout("You can choose a student using his/her ID.\nStudent ID: ", 0, lengthOfStudentList);
            Student selectedStudent = school.getStudents().get(studentIndex);
            if (selectedStudents.contains(selectedStudent)) {
                System.out.println("Student is already selected. Please choose another student.");
                addAnotherStudent = true;
            } else {
                selectedStudents.add(selectedStudent);
                System.out.println("Would you like to add another student? Y: Yes");
                addAnotherStudent = "Y".equals(MainClass.input.next());
            }
        } while (addAnotherStudent);
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
