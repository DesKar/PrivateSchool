package SchoolApplication;

import java.util.ArrayList;

public class SchoolCourse {

    private final Course course;
    private final ArrayList<Student> students = new ArrayList();
    private final ArrayList<Trainer> trainers = new ArrayList();
    private final ArrayList<Assignment> assignments = new ArrayList();

    public SchoolCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
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

}
