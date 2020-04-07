package SchoolApplication;

import java.util.ArrayList;
import java.util.HashSet;

public class SchoolCourse {

    private final Course course;
    private final HashSet<Student> students = new HashSet();
    private final HashSet<Trainer> trainers = new HashSet();
    private final HashSet<Assignment> assignments = new HashSet();

    public SchoolCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
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

}
