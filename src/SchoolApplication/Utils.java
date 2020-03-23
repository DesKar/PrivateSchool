package SchoolApplication;

import java.util.ArrayList;

public class Utils {

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

}
