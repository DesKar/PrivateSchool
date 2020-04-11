package SchoolApplication;

import SchoolApplication.daos.AssignmentsInCoursesDAO;
import SchoolApplication.daos.CourseDAO;
import SchoolApplication.daos.TrainerDAO;
import SchoolApplication.daos.StudentDAO;
import SchoolApplication.daos.TrainersInCoursesDAO;
import SchoolApplication.daos.StudentsInCoursesDAO;
import SchoolApplication.daos.AssignmentDAO;
import SchoolApplication.models.Trainer;
import SchoolApplication.models.Student;
import SchoolApplication.models.Course;
import SchoolApplication.models.Assignment;
import java.time.LocalDate;
import java.util.ArrayList;

public class School {

    public static void printAllStudents() {
        ArrayList<Student> students = StudentDAO.readAllStudents();
        Printing.printListOfStudents(students);
    }

    public static void printAllTrainers() {
        ArrayList<Trainer> trainers = TrainerDAO.readAllTrainers();
        Printing.printListOfTrainers(trainers);

    }

    public static void printAllCourses() {
        ArrayList<Course> courses = CourseDAO.readAllCourses();
        Printing.printListOfCourses(courses);
    }

    public static void printAllAssignments() {
        ArrayList<Assignment> assignments = AssignmentDAO.readAllAssignments();
        Printing.printListOfAssignments(assignments);
    }

    public static void addStudentToCourse() {
        if (!CourseDAO.coursesExist()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (!StudentDAO.studentsExist()) {
            System.out.println("There are no students. Please add a student to continue.");
        } else {
            ArrayList<Course> availableCourses = CourseDAO.readAllCourses();
            Course selectedCourse = Utils.selectCourse(availableCourses);
            ArrayList<Student> selectedStudents = Utils.selectStudentsForCourse();

            for (Student student : selectedStudents) {
                if (!StudentsInCoursesDAO.studentExistsInCourse(student, selectedCourse)) {
                    StudentsInCoursesDAO.addStudentInCourse(selectedCourse, student);
                } else {
                    System.out.printf("\nStudent %s is already registered to the course\n", student.toString());
                }
            }
        }
    }

    public static void addTrainerToCourse() {
        if (!CourseDAO.coursesExist()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (!TrainerDAO.trainersExist()) {
            System.out.println("There are no trainers. Please add a trainer to continue.");
        } else {
            ArrayList<Course> availableCourses = CourseDAO.readAllCourses();
            Course selectedCourse = Utils.selectCourse(availableCourses);
            ArrayList<Trainer> selectedTrainers = Utils.selectTrainersForCourse();

            for (Trainer trainer : selectedTrainers) {
                if (!TrainersInCoursesDAO.trainerExistsInCourse(trainer, selectedCourse)) {
                    TrainersInCoursesDAO.addTrainerInCourse(selectedCourse, trainer);
                } else {
                    System.out.printf("\nTrainer %s is already assigned to the course\n", trainer.toString());
                }
            }
        }
    }

    public static void addAssignmentToCourse() {
        if (!CourseDAO.coursesExist()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (!AssignmentDAO.assignmentsExist()) {
            System.out.println("There are no assignments. Please add an assignment to continue.");
        } else {
            ArrayList<Course> availableCourses = CourseDAO.readAllCourses();
            Course selectedCourse = Utils.selectCourse(availableCourses);
            ArrayList<Assignment> selectedAssignments = Utils.selectAssignmentsForCourse();

            for (Assignment assignment : selectedAssignments) {
                if (!AssignmentsInCoursesDAO.assignmentExistsInCourse(assignment, selectedCourse)) {
                    AssignmentsInCoursesDAO.addAssignmentInCourse(selectedCourse, assignment);
                } else {
                    System.out.printf("\nAssignment %s is already assigned to the course\n", assignment.toString());
                }
            }
        }
    }

    public static void printStudentsInCourse() {
        int number = StudentsInCoursesDAO.readNumberOfCoursesWithAssignedStudents();

        if (number == 0) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {

            ArrayList<Course> coursesWithRegisteredStudents = StudentsInCoursesDAO.readCoursesWithRegisteredStudents();
            Course selectedCourse = Utils.selectCourse(coursesWithRegisteredStudents);

            ArrayList<Student> students = StudentsInCoursesDAO.readStudentsOfCourseWithCourseID(selectedCourse);
            Printing.printListOfStudents(students);
        }
    }

    public static void printTrainersInCourse() {
        int number = TrainersInCoursesDAO.readNumberOfCoursesWithAssignedTrainers();

        if (number == 0) {
            System.out.println("There are no trainers registered to courses. Please register trainers to a course first.");
        } else {

            ArrayList<Course> coursesWithRegisteredTrainers = TrainersInCoursesDAO.readCoursesWithRegisteredTrainers();
            Course selectedCourse = Utils.selectCourse(coursesWithRegisteredTrainers);

            ArrayList<Trainer> trainers = TrainersInCoursesDAO.readTrainersOfCourseWithCourseID(selectedCourse);
            Printing.printListOfTrainers(trainers);
        }
    }

    public static void printAssignmentsInCourse() {
        int number = AssignmentsInCoursesDAO.readNumberOfCoursesWithAssignedAssignments();

        if (number == 0) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {

            ArrayList<Course> coursesWithRegisteredAssignments = AssignmentsInCoursesDAO.readCoursesWithRegisteredAssignments();
            Course selectedCourse = Utils.selectCourse(coursesWithRegisteredAssignments);

            ArrayList<Assignment> assignments = AssignmentsInCoursesDAO.readAssignmentsOfCourseWithCourseID(selectedCourse);
            Printing.printListOfAssignments(assignments);
        }
    }
//    public void printAssignmentsPerStudent() {
//        ArrayList<Course> coursesWithRegisteredStudents = getCoursesWithRegisteredStudents();
//        ArrayList<Course> coursesWithRegisteredAssignments = getCoursesWithRegisteredAssignments();
//        
//        if (coursesWithRegisteredStudents.isEmpty() && coursesWithRegisteredAssignments.isEmpty()) {
//            System.out.println("There are no students and assignments registered to courses. Please register students and assignments to a course.");
//        } else if (coursesWithRegisteredStudents.isEmpty()) {
//            System.out.println("There are no students registered to courses. Please register students to a course first.");
//        } else if (coursesWithRegisteredAssignments.isEmpty()) {
//            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
//        } else {
//            
//            System.out.println("Please choose a student to see his/her assignments: ");
//            Printing.printListOfStudents(students);
//            
//            int lengthOfStudentList = students.size();
//            int studentIndex = Utils.chooseElementWithID("Choose a students to print his/her assignments: ", 0, lengthOfStudentList);
//            
//            Student selectedStudent = students.get(studentIndex);
//            
//            HashSet<Assignment> assignmentsOfSelectedStudent = new HashSet();
//            
//            for (SchoolCourse schoolCourse : schoolCourses) {
//                for (Student student : schoolCourse.getStudents()) {
//                    if (student.equals(selectedStudent)) {
//                        assignmentsOfSelectedStudent.addAll(schoolCourse.getAssignments());
//                    }
//                }
//            }
//            
//            if (assignmentsOfSelectedStudent.isEmpty()) {
//                System.out.println("The student has no assignments.");
//            } else {
//                System.out.println("The assignments of this student are: ");
//                Printing.printListOfAssignments(assignmentsOfSelectedStudent);
//            }
//        }
//    }

//    public static void printStudentsInManyCourses() {
//        ArrayList<Course> coursesWithRegisteredStudents = getCoursesWithRegisteredStudents();
//        if (coursesWithRegisteredStudents.isEmpty()) {
//            System.out.println("There are no students registered to courses. Please register students to a course first.");
//        } else {
//
//            ArrayList<Student> studentsRegisteredToAllCourses = new ArrayList();
//
//            for (SchoolCourse schoolCourse : schoolCourses) {
//                studentsRegisteredToAllCourses.addAll(schoolCourse.getStudents());
//            }
//
//            HashSet<Student> singleEntryStudent = new HashSet();
//            ArrayList<Student> studentsRegisteredToManyCourses = new ArrayList();
//
//            for (Student student : studentsRegisteredToAllCourses) {
//                if (singleEntryStudent.add(student) == false) {
//                    studentsRegisteredToManyCourses.add(student);
//                }
//            }
//
//            if (studentsRegisteredToManyCourses.isEmpty()) {
//                System.out.println("All students are registered in only one course.");
//            } else {
//                Printing.printListOfStudents(studentsRegisteredToManyCourses);
//            }
//        }
//    }

//    public static void printStudentsToDeliverWithinCW() {
//        LocalDate date = Utils.getDate("Please provide a date to print the students that need to submit assignments in the same calendar week."
//                + "\nPlease provide the date in the format YYYY-MM-DD: ");
//
//        DayOfWeek selectedDayOfWeek = date.getDayOfWeek();
//        LocalDate firstDayOfWeek = date;
//        while (firstDayOfWeek.getDayOfWeek() != DayOfWeek.MONDAY) {
//            firstDayOfWeek = firstDayOfWeek.minusDays(1);
//        }
//
//        LocalDate lastDayOfWeek = firstDayOfWeek.plusDays(6);
//
//        HashSet<Assignment> assingmentsToBeSubmittedInCW = new HashSet();
//
//        for (Assignment assignment : assignments) {
//            LocalDate submissionDate = assignment.getSubDateTime();
//            boolean toBeSubmittedInCW = isSubmissionDateInCW(firstDayOfWeek, lastDayOfWeek, submissionDate);
//            if (toBeSubmittedInCW) {
//                assingmentsToBeSubmittedInCW.add(assignment);
//            }
//        }
//
//        HashSet<Student> studentsToSubmitAssignmentsInCW = new HashSet();
//
//        for (SchoolCourse schoolCourse : schoolCourses) {
//            for (Assignment assignmentCandidate : schoolCourse.getAssignments()) {
//                for (Assignment assignment : assingmentsToBeSubmittedInCW) {
//                    if (assignmentCandidate.equals(assignment)) {
//                        studentsToSubmitAssignmentsInCW.addAll(schoolCourse.getStudents());
//                    }
//                }
//            }
//        }
//
//        if (studentsToSubmitAssignmentsInCW.isEmpty()) {
//            System.out.println("No students need to submit assignments this week.");
//        } else {
//
//            System.out.println("The students that need to submit assignments this week are: ");
//            Printing.printListOfStudents(studentsToSubmitAssignmentsInCW);
//
//        }
//
//    }

    private static boolean isSubmissionDateInCW(LocalDate firstDayOfWeek, LocalDate lastDayOfWeek, LocalDate submissionDate) {
        boolean isAfterLastDate = submissionDate.isAfter(lastDayOfWeek);
        boolean isBeforeFirstDate = submissionDate.isBefore(firstDayOfWeek);
        return !(isAfterLastDate || isBeforeFirstDate);
    }
}
