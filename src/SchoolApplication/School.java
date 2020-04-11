package SchoolApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class School {

    private final HashSet<Student> students = new HashSet();
    private final HashSet<Trainer> trainers = new HashSet();
    private final HashSet<Assignment> assignments = new HashSet();
    private final HashSet<Course> courses = new HashSet();

    private final HashSet<SchoolCourse> schoolCourses = new HashSet();

    public void addStudentToStudents(Student student) {
        this.students.add(student);
    }

    public void addTrainerToTrainers(Trainer trainer) {
        this.trainers.add(trainer);
    }

    public void addAssignmentToAssignments(Assignment assignment) {
        this.assignments.add(assignment);
    }

    public void addCourseToCourses(Course course) {
        this.courses.add(course);
    }

    public void addSchoolCourseToSchoolCourses(SchoolCourse schoolCourse) {
        this.schoolCourses.add(schoolCourse);
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public HashSet<Trainer> getTrainers() {
        return trainers;
    }

    public HashSet<Assignment> getAssignments() {
        return assignments;
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    public HashSet<SchoolCourse> getSchoolCourses() {
        return schoolCourses;
    }

    public void printAllStudents() {
        HashSet students = StudentDAO.readAllStudents(this.students);
        Printing.printListOfStudents(students);
    }

    public void printAllTrainers() {
        HashSet trainers = TrainerDAO.readAllTrainers(this.trainers);
        Printing.printListOfTrainers(trainers);

    }

    public void printAllCourses() {
        HashSet<Course> courses = CourseDAO.readAllCourses(this.courses);
        Printing.printListOfCourses(courses);
    }

    public void printAllAssignments() {
        HashSet<Assignment> assignments = AssignmentDAO.readAllAssignments(this.assignments);
        Printing.printListOfAssignments(assignments);
    }

    public void addStudentToCourse() {
        if (!CourseDAO.coursesExist(MainClass.db)) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (!StudentDAO.studentsExist(MainClass.db)) {
            System.out.println("There are no students. Please add a student to continue.");
        } else {
            Collection<Course> availableCourses = CourseDAO.readAllCourses(courses);
            Course selectedCourse = Utils.selectCourse(availableCourses);
            ArrayList<Student> selectedStudents = Utils.selectStudentsForCourse(this);

            for (Student student : selectedStudents) {
                if (!StudentsInCoursesDAO.studentExistsInCourse(student, selectedCourse, MainClass.db)) {
                    StudentsInCoursesDAO.addStudentInCourse(selectedCourse, student, MainClass.db);
                } else {
                    System.out.printf("\nStudent %s is already registered to the course\n", student.toString());
                }
            }
        }
    }

    public void addTrainerToCourse() {
        if (!CourseDAO.coursesExist(MainClass.db)) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (!TrainerDAO.trainersExist(MainClass.db)) {
            System.out.println("There are no trainers. Please add a trainer to continue.");
        } else {
            Collection<Course> availableCourses = CourseDAO.readAllCourses(courses);
            Course selectedCourse = Utils.selectCourse(availableCourses);
            ArrayList<Trainer> selectedTrainers = Utils.selectTrainersForCourse(this);

            for (Trainer trainer : selectedTrainers) {
                if (!TrainersInCoursesDAO.trainerExistsInCourse(trainer, selectedCourse, MainClass.db)) {
                    TrainersInCoursesDAO.addTrainerInCourse(selectedCourse, trainer, MainClass.db);
                } else {
                    System.out.printf("\nTrainer %s is already assigned to the course\n", trainer.toString());
                }
            }
        }
    }

    public void addAssignmentToCourse() {
        if (!CourseDAO.coursesExist(MainClass.db)) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (!AssignmentDAO.assignmentsExist(MainClass.db)) {
            System.out.println("There are no assignments. Please add an assignment to continue.");
        } else {
            Collection<Course> availableCourses = CourseDAO.readAllCourses(courses);
            Course selectedCourse = Utils.selectCourse(availableCourses);
            ArrayList<Assignment> selectedAssignments = Utils.selectAssignmentsForCourse(this);

            for (Assignment assignment : selectedAssignments) {
                if (!AssignmentsInCoursesDAO.assignmentExistsInCourse(assignment, selectedCourse, MainClass.db)) {
                    AssignmentsInCoursesDAO.addAssignmentInCourse(selectedCourse, assignment, MainClass.db);
                } else {
                    System.out.printf("\nAssignment %s is already assigned to the course\n", assignment.toString());
                }
            }
        }
    }

    public void printStudentsInCourse() {
        int number = StudentsInCoursesDAO.readNumberOfCoursesWithAssignedStudents(MainClass.db);

        if (number == 0) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {

            ArrayList<Course> coursesWithRegisteredStudents = StudentsInCoursesDAO.readCoursesWithRegisteredStudents(MainClass.db);
            Course selectedCourse = Utils.selectCourse(coursesWithRegisteredStudents);

            ArrayList<Student> students = StudentsInCoursesDAO.readStudentsOfCourseWithCourseID(selectedCourse, MainClass.db);
            Printing.printListOfStudents(students);
        }
    }

    public void printTrainersInCourse() {
        int number = TrainersInCoursesDAO.readNumberOfCoursesWithAssignedTrainers(MainClass.db);

        if (number == 0) {
            System.out.println("There are no trainers registered to courses. Please register trainers to a course first.");
        } else {

            ArrayList<Course> coursesWithRegisteredTrainers = TrainersInCoursesDAO.readCoursesWithRegisteredTrainers(MainClass.db);
            Course selectedCourse = Utils.selectCourse(coursesWithRegisteredTrainers);

            ArrayList<Trainer> trainers = TrainersInCoursesDAO.readTrainersOfCourseWithCourseID(selectedCourse, MainClass.db);
            Printing.printListOfTrainers(trainers);
        }
    }

    public void printAssignmentsInCourse() {
        int number = AssignmentsInCoursesDAO.readNumberOfCoursesWithAssignedAssignments(MainClass.db);

        if (number == 0) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {

            ArrayList<Course> coursesWithRegisteredAssignments = AssignmentsInCoursesDAO.readCoursesWithRegisteredAssignments(MainClass.db);
            Course selectedCourse = Utils.selectCourse(coursesWithRegisteredAssignments);

            ArrayList<Assignment> assignments = AssignmentsInCoursesDAO.readAssignmentsOfCourseWithCourseID(selectedCourse, MainClass.db);
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

    public void printStudentsInManyCourses() {
        ArrayList<Course> coursesWithRegisteredStudents = getCoursesWithRegisteredStudents();
        if (coursesWithRegisteredStudents.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {

            ArrayList<Student> studentsRegisteredToAllCourses = new ArrayList();

            for (SchoolCourse schoolCourse : schoolCourses) {
                studentsRegisteredToAllCourses.addAll(schoolCourse.getStudents());
            }

            HashSet<Student> singleEntryStudent = new HashSet();
            ArrayList<Student> studentsRegisteredToManyCourses = new ArrayList();

            for (Student student : studentsRegisteredToAllCourses) {
                if (singleEntryStudent.add(student) == false) {
                    studentsRegisteredToManyCourses.add(student);
                }
            }

            if (studentsRegisteredToManyCourses.isEmpty()) {
                System.out.println("All students are registered in only one course.");
            } else {
                Printing.printListOfStudents(studentsRegisteredToManyCourses);
            }
        }
    }

    public void printStudentsToDeliverWithinCW() {
        LocalDate date = Utils.getDate("Please provide a date to print the students that need to submit assignments in the same calendar week."
                + "\nPlease provide the date in the format YYYY-MM-DD: ");

        DayOfWeek selectedDayOfWeek = date.getDayOfWeek();
        LocalDate firstDayOfWeek = date;
        while (firstDayOfWeek.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstDayOfWeek = firstDayOfWeek.minusDays(1);
        }

        LocalDate lastDayOfWeek = firstDayOfWeek.plusDays(6);

        HashSet<Assignment> assingmentsToBeSubmittedInCW = new HashSet();

        for (Assignment assignment : assignments) {
            LocalDate submissionDate = assignment.getSubDateTime();
            boolean toBeSubmittedInCW = isSubmissionDateInCW(firstDayOfWeek, lastDayOfWeek, submissionDate);
            if (toBeSubmittedInCW) {
                assingmentsToBeSubmittedInCW.add(assignment);
            }
        }

        HashSet<Student> studentsToSubmitAssignmentsInCW = new HashSet();

        for (SchoolCourse schoolCourse : schoolCourses) {
            for (Assignment assignmentCandidate : schoolCourse.getAssignments()) {
                for (Assignment assignment : assingmentsToBeSubmittedInCW) {
                    if (assignmentCandidate.equals(assignment)) {
                        studentsToSubmitAssignmentsInCW.addAll(schoolCourse.getStudents());
                    }
                }
            }
        }

        if (studentsToSubmitAssignmentsInCW.isEmpty()) {
            System.out.println("No students need to submit assignments this week.");
        } else {

            System.out.println("The students that need to submit assignments this week are: ");
            Printing.printListOfStudents(studentsToSubmitAssignmentsInCW);

        }

    }

    private SchoolCourse createNewSchoolCourseIfNotExists(Course selectedCourse) {
        SchoolCourse schoolCourse = null;

        for (SchoolCourse schoolCourseCandidate : this.schoolCourses) {
            Course course = schoolCourseCandidate.getCourse();
            if (course.equals(selectedCourse)) {
                schoolCourse = schoolCourseCandidate;
            }
        }
        if (schoolCourse == null) {
            schoolCourse = new SchoolCourse(selectedCourse);
            addSchoolCourseToSchoolCourses(schoolCourse);
        }
        return schoolCourse;
    }

    private ArrayList<Course> getCoursesWithRegisteredStudents() {
        ArrayList<Course> coursesWithRegisteredStudents = new ArrayList();
        for (SchoolCourse schoolCourse : schoolCourses) {
            if (!schoolCourse.getStudents().isEmpty()) {
                Course course = schoolCourse.getCourse();
                coursesWithRegisteredStudents.add(course);
            }
        }
        return coursesWithRegisteredStudents;
    }

    private ArrayList<Course> getCoursesWithRegisteredTrainers() {
        ArrayList<Course> coursesWithRegisteredTrainers = new ArrayList();
        for (SchoolCourse schoolCourse : schoolCourses) {
            if (!schoolCourse.getTrainers().isEmpty()) {
                Course course = schoolCourse.getCourse();
                coursesWithRegisteredTrainers.add(course);
            }
        }
        return coursesWithRegisteredTrainers;
    }

    private ArrayList<Course> getCoursesWithRegisteredAssignments() {
        ArrayList<Course> coursesWithRegisteredAssignments = new ArrayList();
        for (SchoolCourse schoolCourse : schoolCourses) {
            if (!schoolCourse.getAssignments().isEmpty()) {
                Course course = schoolCourse.getCourse();
                coursesWithRegisteredAssignments.add(course);
            }
        }
        return coursesWithRegisteredAssignments;
    }

    private boolean isSubmissionDateInCW(LocalDate firstDayOfWeek, LocalDate lastDayOfWeek, LocalDate submissionDate) {
        boolean isAfterLastDate = submissionDate.isAfter(lastDayOfWeek);
        boolean isBeforeFirstDate = submissionDate.isBefore(firstDayOfWeek);
        return !(isAfterLastDate || isBeforeFirstDate);
    }
}
