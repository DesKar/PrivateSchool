package SchoolApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class School {

    private ArrayList<Student> listOfStudents = new ArrayList();
    private ArrayList<Trainer> listOfTrainers = new ArrayList();
    private ArrayList<Assignment> listOfAssignments = new ArrayList();
    private ArrayList<Course> listOfCourses = new ArrayList();

    private ArrayList<StudentsInCourse> listOfStudentsInCourse = new ArrayList();
    private ArrayList<TrainersInCourse> listOfTrainersInCourse = new ArrayList();
    private ArrayList<AssignmentsInCourse> listOfAssignmentsInCourse = new ArrayList();

    public void addStudentInListOfStudents(Student student) {
        this.listOfStudents.add(student);
    }

    public void addTrainerInListOfTrainers(Trainer trainer) {
        this.listOfTrainers.add(trainer);
    }

    public void addAssignmentInListOfAssignments(Assignment assignment) {
        this.listOfAssignments.add(assignment);
    }

    public void addSCourseInListOfCourses(Course course) {
        this.listOfCourses.add(course);
    }

    public void addStudentsInCourseToListOfStudentsInCourse(StudentsInCourse studentsInCourse) {
        this.listOfStudentsInCourse.add(studentsInCourse);
    }

    public void addTrainersInCourseToListOfTrainersInCourse(TrainersInCourse trainersInCourse) {
        this.listOfTrainersInCourse.add(trainersInCourse);
    }

    public void addAssignmentsInCourseToListOfAssignmentsInCourse(AssignmentsInCourse listOfAssignments) {
        this.listOfAssignmentsInCourse.add(listOfAssignments);
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public ArrayList<Trainer> getListOfTrainers() {
        return listOfTrainers;
    }

    public ArrayList<Assignment> getListOfAssignments() {
        return listOfAssignments;
    }

    public ArrayList<Course> getListOfCourses() {
        return listOfCourses;
    }

    public ArrayList<StudentsInCourse> getListOfStudentsInCourse() {
        return listOfStudentsInCourse;
    }

    public ArrayList<TrainersInCourse> getListOfTrainersInCourse() {
        return listOfTrainersInCourse;
    }

    public ArrayList<AssignmentsInCourse> getListOfAssignmentsInCourse() {
        return listOfAssignmentsInCourse;
    }

    public void printStudents() {
        Printing.printListOfStudents(listOfStudents);
    }

    public void printTrainers() {
        Printing.printListOfTrainers(listOfTrainers);
    }

    public void printCourses() {
        Printing.printListOfCourses(listOfCourses);
    }

    public void printAssignments() {
        Printing.printListOfAssignments(listOfAssignments);
    }

    public void addStudentToCourse() {
        if (listOfCourses.isEmpty()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (listOfStudents.isEmpty()) {
            System.out.println("There are no students. Please add a student to continue.");
        } else {
            Course selectedCourse = Utils.selectCourse(this);
            HashSet<Student> selectedStudents = Utils.selectStudentsForCourse(this);

            ArrayList<StudentsInCourse> exisitingStudentsInCourse = this.getListOfStudentsInCourse();
            boolean courseExists = false;
            for (StudentsInCourse studentInCourse : exisitingStudentsInCourse) {
                Course course = studentInCourse.getCourse();
                if (course.equals(selectedCourse)) {
                    studentInCourse.getListOfStudents().addAll(selectedStudents);
                    courseExists = true;
                }
            }
            if (!courseExists) {
                StudentsInCourse studentsInCourse = new StudentsInCourse(selectedCourse, selectedStudents);
                addStudentsInCourseToListOfStudentsInCourse(studentsInCourse);
            }
        }
    }

    public void addTrainerToCourse() {
        if (listOfCourses.isEmpty()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (listOfTrainers.isEmpty()) {
            System.out.println("There are no trainers. Please add a trainer to continue.");
        } else {
            Course selectedCourse = Utils.selectCourse(this);
            ArrayList<Trainer> selectedTrainers = Utils.selectTrainersForCourse(this);

            TrainersInCourse trainersInCourse = new TrainersInCourse(selectedCourse, selectedTrainers);
            addTrainersInCourseToListOfTrainersInCourse(trainersInCourse);
        }

    }

    public void addAssignmentToCourse() {
        if (listOfCourses.isEmpty()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (listOfAssignments.isEmpty()) {
            System.out.println("There are no assignments. Please add a trainer to continue.");
        } else {
            Course selectedCourse = Utils.selectCourse(this);
            ArrayList<Assignment> selectedAssignments = Utils.selectAssignmentsForCourse(this);

            AssignmentsInCourse assignmentsInCourse = new AssignmentsInCourse(selectedCourse, selectedAssignments);
            addAssignmentsInCourseToListOfAssignmentsInCourse(assignmentsInCourse);
        }
    }

    public void printStudentsInCourse() {
        if (listOfStudentsInCourse.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {
            ArrayList<Course> coursesWithRegisteredStudents = new ArrayList();
            for (StudentsInCourse studentsInCourse : listOfStudentsInCourse) {
                Course course = studentsInCourse.getCourse();
                coursesWithRegisteredStudents.add(course);
            }

            Course selectedCourse = Utils.selectCourseFromListOfCourses(coursesWithRegisteredStudents, "Choose a course to print its registered students: ");

            HashSet<Student> setOfStudentsRegisteredToCourse = new HashSet();
            for (StudentsInCourse studentsInCourse : listOfStudentsInCourse) {
                if (studentsInCourse.getCourse().equals(selectedCourse)) {
                    setOfStudentsRegisteredToCourse = studentsInCourse.getListOfStudents();
                }
            }
            System.out.println("The students of this course are: ");
            Printing.printListOfStudents(setOfStudentsRegisteredToCourse);
        }

    }

    public void printTrainersInCourse() {
        if (listOfTrainersInCourse.isEmpty()) {
            System.out.println("There are no trainers registered to courses. Please register trainers to a course first.");
        } else {
            ArrayList<Course> courseswithRegisteredTrainers = new ArrayList();
            for (TrainersInCourse trainersInCourse : listOfTrainersInCourse) {
                Course course = trainersInCourse.getCourse();
                courseswithRegisteredTrainers.add(course);
            }

            Course selectedCourse = Utils.selectCourseFromListOfCourses(courseswithRegisteredTrainers, "Choose a course to print its registered trainers: ");

            ArrayList<Trainer> listOfTrainersRegisteredToCourse = new ArrayList();
            for (TrainersInCourse trainersInCourse : listOfTrainersInCourse) {
                if (trainersInCourse.getCourse().equals(selectedCourse)) {
                    listOfTrainersRegisteredToCourse = trainersInCourse.getListOfTrainers();
                }
            }

            System.out.println("The trainers of this course are: ");
            Printing.printListOfTrainers(listOfTrainersRegisteredToCourse);

        }
    }

    public void printAssignmentsInCourse() {
        if (listOfAssignmentsInCourse.isEmpty()) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {
            ArrayList<Course> courseswithRegisteredAssignments = new ArrayList();
            for (AssignmentsInCourse assignmentInCourse : listOfAssignmentsInCourse) {
                Course course = assignmentInCourse.getCourse();
                courseswithRegisteredAssignments.add(course);
            }
            Course selectedCourse = Utils.selectCourseFromListOfCourses(courseswithRegisteredAssignments, "Choose a course to print its registered assignments: ");

            ArrayList<Assignment> listOfAssignmentsRegistereToCourse = new ArrayList();
            for (AssignmentsInCourse assignmentInCourse : listOfAssignmentsInCourse) {
                if (assignmentInCourse.getCourse().equals(selectedCourse)) {
                    listOfAssignmentsRegistereToCourse = assignmentInCourse.getListOfAssignments();
                }
            }

            System.out.println("The assignments of this course are: ");
            Printing.printListOfAssignments(listOfAssignmentsRegistereToCourse);

        }

    }

    public void printAsignemntsPerStudent() {
        if (listOfStudentsInCourse.isEmpty() && listOfAssignmentsInCourse.isEmpty()) {
            System.out.println("There are no students and assignments registered to courses. Please register students and assignments to a course.");
        } else if (listOfStudentsInCourse.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else if (listOfAssignmentsInCourse.isEmpty()) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {

            System.out.println("Please choose a student to see his/her assignments: ");
            Printing.printListOfStudents(listOfStudents);

            int lengthOfStudentList = listOfStudents.size();
            int studentIndex = Utils.chooseElementFromPrintout("Choose a students to print his/her assignments: ", 0, lengthOfStudentList);

            Student selectedStudent = listOfStudents.get(studentIndex);

            ArrayList<Course> coursesOfSelectedStudent = new ArrayList();

            for (StudentsInCourse studentsInCourse : listOfStudentsInCourse) {
                HashSet<Student> students = studentsInCourse.getListOfStudents();
                for (Student student : students) {
                    if (student == selectedStudent) {
                        Course course = studentsInCourse.getCourse();
                        coursesOfSelectedStudent.add(course);
                    }
                }

            }

            ArrayList<Assignment> assignmentsOfCourses = new ArrayList();
            for (Course course : coursesOfSelectedStudent) {
                for (AssignmentsInCourse assignmentsInCourse : listOfAssignmentsInCourse) {
                    if (course.equals(assignmentsInCourse.getCourse())) {
                        assignmentsOfCourses.addAll(assignmentsInCourse.getListOfAssignments());
                    }
                }
            }

            System.out.println("The assignments of this student are: ");
            Printing.printListOfAssignments(assignmentsOfCourses);
        }
    }

    public void printStudentsInManyCourses() {
        if (listOfStudentsInCourse.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {

            ArrayList listOfAllStudentsRegisteredToCourses = new ArrayList();
            ArrayList listOfStudentsRegisteredToManyCourses = new ArrayList();

            for (StudentsInCourse studentInCourse : listOfStudentsInCourse) {
                HashSet<Student> students = studentInCourse.getListOfStudents();
                for (Student student : students) {
                    listOfAllStudentsRegisteredToCourses.add(student);
                }
            }

            for (int i = 0; i < listOfAllStudentsRegisteredToCourses.size(); i++) {
                for (int j = i + 1; j < listOfAllStudentsRegisteredToCourses.size(); j++) {
                    if (listOfAllStudentsRegisteredToCourses.get(i).equals(listOfAllStudentsRegisteredToCourses.get(j))) {
                        listOfStudentsRegisteredToManyCourses.add(listOfAllStudentsRegisteredToCourses.get(i));
                    }
                }

            }
            if (listOfAllStudentsRegisteredToCourses.isEmpty()) {
                System.out.println("All students are registered in only one course.");
            } else {
                Printing.printListOfStudents(listOfStudentsRegisteredToManyCourses);
            }

        }

    }

    public void printStudentsToBeDeliveredWithinTheWeek() {
        //        Lastly, the program should ask from the user a date and it should output a list of
//students who need to submit one or more assignments on the same calendar week
//as the given date [15 marks].
        LocalDate date = Utils.getDate("Please provide a date to print the students that need to submit assignments on the same calendar week.");

        DayOfWeek selectedDayOfWeek = date.getDayOfWeek();
        LocalDate firstDayOfWeek = date;
        while (firstDayOfWeek.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstDayOfWeek = firstDayOfWeek.minusDays(1);
        }

        LocalDate lastDayOfWeek = firstDayOfWeek.plusDays(4);
        System.out.println("week starts on " + firstDayOfWeek + " ends on " + lastDayOfWeek);

        HashSet<Student> studentsToSubmitAssignments = new HashSet();

        for (Assignment assignment : listOfAssignments) {
            LocalDate submissionDate = assignment.getSubDateTime();
            boolean isit = isSubmissionDateInCW(firstDayOfWeek, lastDayOfWeek, submissionDate);
            System.out.println(isit);
        }

    }

    private boolean isSubmissionDateInCW(LocalDate firstDayOfWeek, LocalDate lastDayOfWeek, LocalDate submissionDate) {
        int compareWithLastDate = submissionDate.compareTo(lastDayOfWeek);
        int compareWithFirstDate = submissionDate.compareTo(firstDayOfWeek);
        if ((Math.abs(compareWithLastDate) + Math.abs(compareWithFirstDate)) == 4) {
            System.out.println("compareWithLastDate" + compareWithLastDate);
            System.out.println("compareWithFirstDate" + compareWithFirstDate);
            return true;
        } else {
            return false;
        }

    }

}
