package SchoolApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class School {

    private ArrayList<Student> students = new ArrayList();
    private ArrayList<Trainer> trainers = new ArrayList();
    private ArrayList<Assignment> assignments = new ArrayList();
    private ArrayList<Course> courses = new ArrayList();

    private ArrayList<StudentsInCourse> studentsInCourses = new ArrayList();
    private ArrayList<TrainersInCourse> trainersInCourses = new ArrayList();
    private ArrayList<AssignmentsInCourse> assignmentsInCourses = new ArrayList();

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

    public void addStudentsInCourseToStudentsInCourses(StudentsInCourse studentsInCourse) {
        this.studentsInCourses.add(studentsInCourse);
    }

    public void addTrainersInCourseToTrainersInCourses(TrainersInCourse trainersInCourse) {
        this.trainersInCourses.add(trainersInCourse);
    }

    public void addAssignmentsInCourseToAssignemntsInCourses(AssignmentsInCourse listOfAssignments) {
        this.assignmentsInCourses.add(listOfAssignments);
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

    public ArrayList<StudentsInCourse> getStudentsInCourse() {
        return studentsInCourses;
    }

    public ArrayList<TrainersInCourse> getTrainersInCourse() {
        return trainersInCourses;
    }

    public ArrayList<AssignmentsInCourse> getAssignmentsInCourse() {
        return assignmentsInCourses;
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

            ArrayList<StudentsInCourse> existingStudentsInCourses = this.getStudentsInCourse();
            boolean courseExists = false;
            for (StudentsInCourse studentsInCourse : existingStudentsInCourses) {
                Course course = studentsInCourse.getCourse();
                if (course.equals(selectedCourse)) {
                    studentsInCourse.getStudentsInCourse().addAll(selectedStudents);
                    courseExists = true;
                }
            }
            if (!courseExists) {
                StudentsInCourse studentsInCourse = new StudentsInCourse(selectedCourse, selectedStudents);
                addStudentsInCourseToStudentsInCourses(studentsInCourse);
            }
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

            ArrayList<TrainersInCourse> existingTrainersInCourses = this.getTrainersInCourse();
            boolean courseExists = false;
            for (TrainersInCourse trainersInCourse : existingTrainersInCourses) {
                Course course = trainersInCourse.getCourse();
                if (course.equals(selectedCourse)) {
                    trainersInCourse.getTrainersInCourse().addAll(selectedTrainers);
                    courseExists = true;
                }
            }
            if (!courseExists) {
                TrainersInCourse trainersInCourse = new TrainersInCourse(selectedCourse, selectedTrainers);
                addTrainersInCourseToTrainersInCourses(trainersInCourse);
            }

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

            ArrayList<AssignmentsInCourse> existingAssignmentsInCourses = this.getAssignmentsInCourse();
            boolean courseExists = false;
            for (AssignmentsInCourse assignmentsInCourse : existingAssignmentsInCourses) {
                Course course = assignmentsInCourse.getCourse();
                if (course.equals(selectedCourse)) {
                    assignmentsInCourse.getListOfAssignments().addAll(selectedAssignments);
                    courseExists = true;
                }
            }
            if (!courseExists) {
                AssignmentsInCourse assignmentsInCourse = new AssignmentsInCourse(selectedCourse, selectedAssignments);
                addAssignmentsInCourseToAssignemntsInCourses(assignmentsInCourse);
            }
        }
    }

    public void printStudentsInCourse() {
        if (studentsInCourses.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {
            ArrayList<Course> coursesWithRegisteredStudents = new ArrayList();
            for (StudentsInCourse studentsInCourse : studentsInCourses) {
                Course course = studentsInCourse.getCourse();
                coursesWithRegisteredStudents.add(course);
            }

            Course selectedCourse = Utils.selectCourseFromListOfCourses(coursesWithRegisteredStudents, "Choose a course to print its registered students: ");

            ArrayList<Student> StudentsRegisteredToCourse = new ArrayList();
            for (StudentsInCourse studentsInCourse : studentsInCourses) {
                if (studentsInCourse.getCourse().equals(selectedCourse)) {
                    StudentsRegisteredToCourse = studentsInCourse.getStudentsInCourse();
                }
            }
            System.out.println("The students of this course are: ");
            Printing.printListOfStudents(StudentsRegisteredToCourse);
        }

    }

    public void printTrainersInCourse() {
        if (trainersInCourses.isEmpty()) {
            System.out.println("There are no trainers registered to courses. Please register trainers to a course first.");
        } else {
            ArrayList<Course> courseswithRegisteredTrainers = new ArrayList();
            for (TrainersInCourse trainersInCourse : trainersInCourses) {
                Course course = trainersInCourse.getCourse();
                courseswithRegisteredTrainers.add(course);
            }

            Course selectedCourse = Utils.selectCourseFromListOfCourses(courseswithRegisteredTrainers, "Choose a course to print its registered trainers: ");

            ArrayList<Trainer> trainersRegisteredToCourse = new ArrayList();
            for (TrainersInCourse trainersInCourse : trainersInCourses) {
                if (trainersInCourse.getCourse().equals(selectedCourse)) {
                    trainersRegisteredToCourse = trainersInCourse.getTrainersInCourse();
                }
            }

            System.out.println("The trainers of this course are: ");
            Printing.printListOfTrainers(trainersRegisteredToCourse);

        }
    }

    public void printAssignmentsInCourse() {
        if (assignmentsInCourses.isEmpty()) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {
            ArrayList<Course> courseswithRegisteredAssignments = new ArrayList();
            for (AssignmentsInCourse assignmentInCourse : assignmentsInCourses) {
                Course course = assignmentInCourse.getCourse();
                courseswithRegisteredAssignments.add(course);
            }
            Course selectedCourse = Utils.selectCourseFromListOfCourses(courseswithRegisteredAssignments, "Choose a course to print its registered assignments: ");

            ArrayList<Assignment> assignmentsRegisteredToCourse = new ArrayList();
            for (AssignmentsInCourse assignmentInCourse : assignmentsInCourses) {
                if (assignmentInCourse.getCourse().equals(selectedCourse)) {
                    assignmentsRegisteredToCourse = assignmentInCourse.getListOfAssignments();
                }
            }

            System.out.println("The assignments of this course are: ");
            Printing.printListOfAssignments(assignmentsRegisteredToCourse);

        }

    }

    public void printAssignmentsPerStudent() {
        if (studentsInCourses.isEmpty() && assignmentsInCourses.isEmpty()) {
            System.out.println("There are no students and assignments registered to courses. Please register students and assignments to a course.");
        } else if (studentsInCourses.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else if (assignmentsInCourses.isEmpty()) {
            System.out.println("There are no assignments registered to courses. Please register assignments to a course first.");
        } else {

            System.out.println("Please choose a student to see his/her assignments: ");
            Printing.printListOfStudents(students);

            int lengthOfStudentList = students.size();
            int studentIndex = Utils.chooseElementFromPrintout("Choose a students to print his/her assignments: ", 0, lengthOfStudentList);

            Student selectedStudent = students.get(studentIndex);

            ArrayList<Course> coursesOfSelectedStudent = new ArrayList();

            for (StudentsInCourse studentsInCourse : studentsInCourses) {
                ArrayList<Student> students = studentsInCourse.getStudentsInCourse();
                for (Student student : students) {
                    if (student == selectedStudent) {
                        Course course = studentsInCourse.getCourse();
                        coursesOfSelectedStudent.add(course);
                    }
                }
            }

            HashSet<Assignment> assignmentsOfCourses = new HashSet();
            for (Course course : coursesOfSelectedStudent) {
                for (AssignmentsInCourse assignmentsInCourse : assignmentsInCourses) {
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
        if (studentsInCourses.isEmpty()) {
            System.out.println("There are no students registered to courses. Please register students to a course first.");
        } else {

            ArrayList studentsRegisteredToCourses = new ArrayList();
            ArrayList studentsRegisteredToManyCourses = new ArrayList();

            for (StudentsInCourse studentInCourse : studentsInCourses) {
                ArrayList<Student> students = studentInCourse.getStudentsInCourse();
                for (Student student : students) {
                    studentsRegisteredToCourses.add(student);
                }
            }

            for (int i = 0; i < studentsRegisteredToCourses.size(); i++) {
                for (int j = i + 1; j < studentsRegisteredToCourses.size(); j++) {
                    if (studentsRegisteredToCourses.get(i).equals(studentsRegisteredToCourses.get(j))) {
                        studentsRegisteredToManyCourses.add(studentsRegisteredToCourses.get(i));
                    }
                }
            }

            if (studentsRegisteredToManyCourses.isEmpty()) {
                System.out.println("All students are registered in only one course.");
            } else {
                Printing.printListOfStudents(studentsRegisteredToManyCourses);
            }

        }

    }

    public void printStudentsToBeDeliveredWithinTheWeek() {
        LocalDate date = Utils.getDate("Please provide a date to print the students that need to submit assignments on the same calendar week."
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
        
        
        ArrayList<Course> coursesOfAssignments = new ArrayList();
        
        for(AssignmentsInCourse assignmentsInCourse:assignmentsInCourses){
            ArrayList<Assignment> assignments  = assignmentsInCourse.getListOfAssignments();
            for(int i = 0; i < assignments.size(); i++)
                for(Assignment assingment: assingmentsToBeSubmittedInCW){
                    if(assignments.get(i).equals(assingment)){
                        coursesOfAssignments.add(assignmentsInCourse.getCourse());
                    }
            }
        }
        
        HashSet<Student> studentsToSubmitAssignmentsInCW = new HashSet();
           
        for(StudentsInCourse studentInCourse:studentsInCourses){
            ArrayList<Student> students = studentInCourse.getStudentsInCourse();
            for(Course course:coursesOfAssignments){
                if(studentInCourse.getCourse().equals(course)){
                    studentsToSubmitAssignmentsInCW.addAll(students);
                }
            }
        }
        
        ArrayList studentsToPrint = new ArrayList(studentsToSubmitAssignmentsInCW);
        Printing.printListOfStudents(studentsToPrint);
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
