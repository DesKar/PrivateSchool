package SchoolApplication;

import java.util.ArrayList;

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

    public void PrintStudents() {
        Printing.printListOfStudents(listOfStudents);
    }

    public void PrintTrainers() {
        Printing.printListOfTrainers(listOfTrainers);
    }

    public void PrintCourses() {
        Printing.printListOfCourses(listOfCourses);
    }

    public void PrintAssignments() {
        Printing.printListOfAssignments(listOfAssignments);
    }

    public void addStudentToCourse() {
        if (listOfCourses.isEmpty()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (listOfStudents.isEmpty()) {
            System.out.println("There are no students. Please add a student to continue.");
        } else {
            System.out.println("Please choose a course from the list below:");
            PrintCourses();

            Course selectedCourse = Utils.selectCourse(this);
            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));

            System.out.println("Please choose students to add to the selected course.\n");
            PrintStudents();

            ArrayList<Student> selectedStudents = Utils.selectStudents(this);

            StudentsInCourse studentsInCourse = new StudentsInCourse(selectedCourse, selectedStudents);
            addStudentsInCourseToListOfStudentsInCourse(studentsInCourse);
        }

    }

    public void addTrainerToCourse() {
        if (listOfCourses.isEmpty()) {
            System.out.println("There are no courses. Please add a course to continue.");
        } else if (listOfTrainers.isEmpty()) {
            System.out.println("There are no trainers. Please add a trainer to continue.");
        } else {
            System.out.println("Please choose a course from the list below:");
            PrintCourses();

            Course selectedCourse = Utils.selectCourse(this);
            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));

            System.out.println("Please choose trainers to add to the selected course.\n");
            PrintTrainers();
            ArrayList<Trainer> selectedTrainers = Utils.selectTrainers(this);

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
            System.out.println("Please choose a course from the list below:");
            PrintCourses();

            Course selectedCourse = Utils.selectCourse(this);

            System.out.printf("Selected course: %s.\n", (selectedCourse.toString()));
            System.out.println("Please choose assignments to add to the selected course.\n");
            PrintAssignments();

            ArrayList<Assignment> selectedAssignments = Utils.selectAssignments(this);

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

            Printing.printListOfCourses(coursesWithRegisteredStudents);

            int lengthOfCourseList = listOfStudentsInCourse.size(); //assuming that the list has only one occurence per course
            int selectedCourseIndex = Utils.chooseElementFromPrintout("Choose a course to print its registered students: ", 0, lengthOfCourseList);

            Course selectedCourse = coursesWithRegisteredStudents.get(selectedCourseIndex);

            System.out.println("\nThe course you have selected is: \n");
            System.out.println(selectedCourse.toString());

            ArrayList<Student> listOfStudentsRegisteredToCourse = new ArrayList();
            for (StudentsInCourse studentsInCourse : listOfStudentsInCourse) {
                if (studentsInCourse.getCourse().equals(selectedCourse)) {
                    listOfStudentsRegisteredToCourse = studentsInCourse.getListOfStudents();
                }
            }
            System.out.println("The students of this course are: ");
            Printing.printListOfStudents(listOfStudentsRegisteredToCourse);

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

            Printing.printListOfCourses(courseswithRegisteredTrainers);

            int lengthOfCourseList = listOfTrainersInCourse.size();
            int selectedCourseIndex = Utils.chooseElementFromPrintout("Choose a course to print its registered trainers: ", 0, lengthOfCourseList);

            Course selectedCourse = courseswithRegisteredTrainers.get(selectedCourseIndex);

            System.out.println("\nThe course you have selected is: \n");
            System.out.println(selectedCourse.toString());

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

            Printing.printListOfCourses(courseswithRegisteredAssignments);

            int lengthOfCourseList = listOfTrainersInCourse.size();
            int selectedCourseIndex = Utils.chooseElementFromPrintout("Choose a course to print its registered assignments: ", 0, lengthOfCourseList);

            Course selectedCourse = courseswithRegisteredAssignments.get(selectedCourseIndex);

            System.out.println("\nThe course you have selected is: \n");
            System.out.println(selectedCourse.toString());

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
                ArrayList<Student> students = studentsInCourse.getListOfStudents();
                for (Student student : students) {
                    if (student == selectedStudent) {
                        Course course = studentsInCourse.getCourse();
                        coursesOfSelectedStudent.add(course);
                    }
                }

            }

            Printing.printListOfCourses(coursesOfSelectedStudent);

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

}
