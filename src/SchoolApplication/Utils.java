package SchoolApplication;

import SchoolApplication.daos.CourseDAO;
import SchoolApplication.daos.TrainerDAO;
import SchoolApplication.daos.StudentDAO;
import SchoolApplication.daos.AssignmentDAO;
import SchoolApplication.models.Trainer;
import SchoolApplication.models.Student;
import SchoolApplication.models.Course;
import SchoolApplication.models.Assignment;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Utils {

    public static int chooseElementWithID(String message, ArrayList<Integer> ids) {
        int number;
        do {
            System.out.print(message);
            while (!MainClass.input.hasNextInt()) {
                System.out.print(message);
                MainClass.input.nextLine();
            }
            number = MainClass.input.nextInt();
        } while (!ids.contains(number));
        return number;
    }

    public static Course selectCourse(Collection<Course> courses) {
        System.out.println("Please choose a course from the list below: ");
        Printing.printListOfCourses(courses);

        ArrayList<Integer> courseIds = getCoursesIds(courses);
        int selectedCourseId = Utils.chooseElementWithID("You can choose the course using its ID.\nCourse ID: ", courseIds);
        Course selectedCourse = CourseDAO.readCourseWithID(selectedCourseId);

        System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
        return selectedCourse;
    }

    public static Student selectStudent(Collection<Student> students) {
        System.out.println("Please choose a student from the list below: ");
        Printing.printListOfStudents(students);

        ArrayList<Integer> studentIds = getStudentsIds(students);
        int selectedStudentId = Utils.chooseElementWithID("You can choose the course using its ID.\nCourse ID: ", studentIds);
        Student selectedStudent = StudentDAO.readStudentWithID(selectedStudentId);

        System.out.printf("Selected student: %s.\n", (selectedStudent.toString()));
        return selectedStudent;
    }

    public static ArrayList selectAssignmentsForCourse() {
        ArrayList<Assignment> selectedAssignments = new ArrayList();
        System.out.println("Please choose assignments to add to the selected course.\n");
        School.printAllAssignments();
        boolean addAnotherAssignment;
        do {
            ArrayList<Integer> assignmentIds = AssignmentDAO.readAllAssignmentsIds();
            int selectedAssignmentID = Utils.chooseElementWithID("You can choose an assignment using its ID.\nAssignment ID: ", assignmentIds);

            Assignment selectedAssignment = AssignmentDAO.readAssignmentWithID(selectedAssignmentID);
            if (selectedAssignments.contains(selectedAssignment)) {
                System.out.println("Assignment is already selected. Please type any letter to choose another assignment or Q to exit.");
                addAnotherAssignment = !"Q".equals(MainClass.input.next());
            } else {
                selectedAssignments.add(selectedAssignment);
                System.out.println("Would you like to add another assignment? Y: Yes");
                addAnotherAssignment = "Y".equals(MainClass.input.next());
            }
        } while (addAnotherAssignment);
        return selectedAssignments;
    }

    public static ArrayList selectTrainersForCourse() {
        ArrayList<Trainer> selectedTrainers = new ArrayList();
        System.out.println("Please choose trainers to add to the selected course.\n");
        School.printAllTrainers();
        boolean addAnotherTrainer;
        do {
            ArrayList<Integer> trainerIds = TrainerDAO.readAllTrainersIds();
            int selectedTrainerID = Utils.chooseElementWithID("You can choose a trainer using his/her ID.\nTrainer ID: ", trainerIds);
            Trainer selectedTrainer = TrainerDAO.readTrainerWithID(selectedTrainerID);
            if (selectedTrainers.contains(selectedTrainer)) {
                System.out.println("Trainer is already selected. Please type any letter to choose another trainer or Q to exit.");
                addAnotherTrainer = !"Q".equals(MainClass.input.next());
            } else {
                selectedTrainers.add(selectedTrainer);
                System.out.println("Would you like to add another trainer? Y: Yes");
                addAnotherTrainer = "Y".equals(MainClass.input.next());
            }
        } while (addAnotherTrainer);
        return selectedTrainers;
    }

    public static ArrayList<Student> selectStudentsForCourse() {
        ArrayList<Student> selectedStudents = new ArrayList();
        System.out.println("Please choose students to add to the selected course.\n");
        School.printAllStudents();
        boolean addAnotherStudent;
        do {
            ArrayList<Integer> studentIds = StudentDAO.readAllStudentsIds();
            int selectedStudentID = Utils.chooseElementWithID("You can choose a student using his/her ID.\nStudent ID: ", studentIds);
            Student selectedStudent = StudentDAO.readStudentWithID(selectedStudentID);
            if (selectedStudents.contains(selectedStudent)) {
                System.out.println("Student is already selected. Please type any letter to choose another student or Q to exit.");
                addAnotherStudent = !"Q".equals(MainClass.input.next());
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
        return MainClass.input.nextLine();
    }

    public static LocalDate getDate(String message) {
        System.out.print(message);
        LocalDate localDate = null;
        while (localDate == null) {
            try {
                String date = MainClass.input.nextLine();
                while (date.charAt(4) != '-' || date.charAt(7) != '-' || date.length() != 10) {
                    System.out.print("Please provide the date in the format YYYY-MM-DD: ");
                    date = MainClass.input.nextLine();
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

    public static LocalDate getDate(String message, LocalDate startDate) {
        LocalDate endDate;
        boolean isEndDateAfterStartDate;
        do {
            endDate = getDate(message);
            isEndDateAfterStartDate = endDate.isAfter(startDate);
            if (!isEndDateAfterStartDate) {
                System.out.println("The ending date should be after the starting date.");
            }
        } while (!isEndDateAfterStartDate);
        return endDate;
    }

    public static int getIntNumber(String message1, String message2, int lowerBound, int upperBound) {
        int number;
        System.out.print(message1);
        boolean numberIsWithinBounds = false;
        do {

            while (!MainClass.input.hasNextInt()) {
                System.out.print(message2);
                MainClass.input.nextLine();
            }
            number = MainClass.input.nextInt();
            if (number < lowerBound || number > upperBound) {
                numberIsWithinBounds = false;
                System.out.println(message2);
            } else {
                numberIsWithinBounds = true;
            }
        } while (!numberIsWithinBounds);
        return number;
    }

    private static ArrayList<Integer> getCoursesIds(Collection<Course> courses) {
        ArrayList<Integer> coursesIds = new ArrayList();
        for (Course course : courses) {
            coursesIds.add(course.getId());
        }
        return coursesIds;
    }

    private static ArrayList<Integer> getStudentsIds(Collection<Student> students) {
        ArrayList<Integer> studentsIds = new ArrayList();
        for (Student course : students) {
            studentsIds.add(course.getId());
        }
        return studentsIds;
    }
}
