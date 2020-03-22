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

}
