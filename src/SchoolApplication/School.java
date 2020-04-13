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

    public static void printAssignmentsPerCoursePerStudent() {
        int numberOfCoursesWithAssignments = AssignmentsInCoursesDAO.readNumberOfCoursesWithAssignedAssignments();
        int numberOfStudentsInCourses = StudentsInCoursesDAO.readNumberOfCoursesWithAssignedStudents();

        if (numberOfStudentsInCourses == 0 && numberOfCoursesWithAssignments == 0) {
            System.out.println("There are no students and assignments registered to courses. Please register students and assignments to a course.");
        } else if (numberOfStudentsInCourses == 0) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else if (numberOfCoursesWithAssignments == 0) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {

            ArrayList<Course> coursesWithRegisteredStudents = StudentsInCoursesDAO.readCoursesWithRegisteredStudents();
            Course selectedCourse = Utils.selectCourse(coursesWithRegisteredStudents);

            ArrayList<Student> students = StudentsInCoursesDAO.readStudentsRegisteredToCourse(selectedCourse.getId());
            Student selectedStudent = Utils.selectStudent(students);

            ArrayList<Assignment> assignments = AssignmentsInCoursesDAO.readAssignmentsPerStudentPerCourse(selectedCourse.getId(), selectedStudent.getId());
            Printing.printListOfAssignments(assignments);
        }
    }

    public static void printStudentsInManyCourses() {
        int number = StudentsInCoursesDAO.readNumberOfCoursesWithAssignedStudents();
        if (number == 0) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {

            ArrayList<Student> students = StudentsInCoursesDAO.readStudentsRegisteredToManyCorses();
            Printing.printListOfStudents(students);
        }
    }
}
