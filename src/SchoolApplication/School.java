package SchoolApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class School {

    private final ArrayList<Student> students = new ArrayList();
    private final ArrayList<Trainer> trainers = new ArrayList();
    private final ArrayList<Assignment> assignments = new ArrayList();
    private final ArrayList<Course> courses = new ArrayList();

    private final ArrayList<SchoolCourse> schoolCourses = new ArrayList();

    public void addStudenToStudents(Student student) {
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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<SchoolCourse> getSchoolCourses() {
        return schoolCourses;
    }

    public void printStudents() {
        Printing.printListOfStudents(students);
    }

    public void printTrainers() {
        Printing.printListOfTrainers(trainers);
    }

    public void printCourses() {
        Printing.printListOfCourses(courses);
    }

    public void printAssignments() {
        Printing.printListOfAssignments(assignments);
    }

    public void addStudentToCourse() {
        if (courses.isEmpty()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (students.isEmpty()) {
            System.out.println("There are no students. Please add a student to continue.");
        } else {
            Course selectedCourse = Utils.selectCourse(this);
            ArrayList<Student> selectedStudents = Utils.selectStudentsForCourse(this);

            SchoolCourse schoolCourse = createNewSchoolCourseIfNotExists(selectedCourse);
            schoolCourse.getStudents().addAll(selectedStudents);
        }
    }

    public void addTrainerToCourse() {
        if (courses.isEmpty()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (trainers.isEmpty()) {
            System.out.println("There are no trainers. Please add a trainer to continue.");
        } else {
            Course selectedCourse = Utils.selectCourse(this);
            ArrayList<Trainer> selectedTrainers = Utils.selectTrainersForCourse(this);

            SchoolCourse schoolCourse = createNewSchoolCourseIfNotExists(selectedCourse);
            schoolCourse.getTrainers().addAll(selectedTrainers);

        }
    }

    public void addAssignmentToCourse() {
        if (courses.isEmpty()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (assignments.isEmpty()) {
            System.out.println("There are no assignments. Please add a trainer to continue.");
        } else {
            Course selectedCourse = Utils.selectCourse(this);
            ArrayList<Assignment> selectedAssignments = Utils.selectAssignmentsForCourse(this);

            SchoolCourse schoolCourse = createNewSchoolCourseIfNotExists(selectedCourse);
            schoolCourse.getAssignments().addAll(selectedAssignments);

        }
    }

    public void printStudentsInCourse() {

        ArrayList<Course> coursesWithRegisteredStudents = getCoursesWithRegisteredStudents();

        if (coursesWithRegisteredStudents.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {

            Course selectedCourse = Utils.selectCourseFromListOfCourses(coursesWithRegisteredStudents, "Choose a course to print its registered students: ");

            for (SchoolCourse schoolCourse : schoolCourses) {
                if (schoolCourse.getCourse().equals(selectedCourse)) {
                    ArrayList<Student> studentsRegisteredToCourse = schoolCourse.getStudents();
                    System.out.println("The students of this course are: ");
                    Printing.printListOfStudents(studentsRegisteredToCourse);
                    break;
                }
            }

        }

    }

    public void printTrainersInCourse() {

        ArrayList<Course> coursesWithRegisteredTrainers = getCoursesWithRegisteredTrainers();

        if (coursesWithRegisteredTrainers.isEmpty()) {
            System.out.println("There are no trainers registered to courses. Please register trainers to a course first.");
        } else {

            Course selectedCourse = Utils.selectCourseFromListOfCourses(coursesWithRegisteredTrainers, "Choose a course to print its registered trainers: ");

            for (SchoolCourse schoolCourse : schoolCourses) {
                if (schoolCourse.getCourse().equals(selectedCourse)) {
                    ArrayList<Trainer> trainersRegisteredToCourse = schoolCourse.getTrainers();
                    System.out.println("The trainers of this course are: ");
                    Printing.printListOfTrainers(trainersRegisteredToCourse);
                    break;
                }
            }

        }
    }

    public void printAssignmentsInCourse() {

        ArrayList<Course> coursesWithRegisteredAssignments = getCoursesWithRegisteredAssignments();

        if (coursesWithRegisteredAssignments.isEmpty()) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {

            Course selectedCourse = Utils.selectCourseFromListOfCourses(coursesWithRegisteredAssignments, "Choose a course to print its registered assignments: ");

            for (SchoolCourse schoolCourse : schoolCourses) {
                if (schoolCourse.getCourse().equals(selectedCourse)) {
                    ArrayList<Assignment> assignmentsRegisteredToCourse = schoolCourse.getAssignments();
                    System.out.println("The assignments of this course are: ");
                    Printing.printListOfAssignments(assignmentsRegisteredToCourse);
                    break;
                }
            }

        }

    }

    public void printAssignmentsPerStudent() {
        ArrayList<Course> coursesWithRegisteredStudents = getCoursesWithRegisteredStudents();
        ArrayList<Course> coursesWithRegisteredAssignments = getCoursesWithRegisteredAssignments();

        if (coursesWithRegisteredStudents.isEmpty() && coursesWithRegisteredAssignments.isEmpty()) {
            System.out.println("There are no students and assignments registered to courses. Please register students and assignments to a course.");
        } else if (coursesWithRegisteredStudents.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else if (coursesWithRegisteredAssignments.isEmpty()) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {

            System.out.println("Please choose a student to see his/her assignments: ");
            Printing.printListOfStudents(students);

            int lengthOfStudentList = students.size();
            int studentIndex = Utils.chooseElementFromPrintout("Choose a students to print his/her assignments: ", 0, lengthOfStudentList);

            Student selectedStudent = students.get(studentIndex);

            HashSet<Assignment> assignmentsOfSelectedStudent = new HashSet();

            for (SchoolCourse schoolCourse : schoolCourses) {
                for (Student student : schoolCourse.getStudents()) {
                    if (student.equals(selectedStudent)) {
                        assignmentsOfSelectedStudent.addAll(schoolCourse.getAssignments());
                    }
                }
            }

            if (assignmentsOfSelectedStudent.isEmpty()) {
                System.out.println("The student has no assignments.");
            } else {
                System.out.println("The assignments of this student are: ");
                Printing.printListOfAssignments(assignmentsOfSelectedStudent);
            }
        }
    }

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
        if (isAfterLastDate || isBeforeFirstDate) {
            return false;
        } else {
            return true;
        }

    }

}
