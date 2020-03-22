package SchoolApplication;

import java.util.ArrayList;

public class AssignmentsInCourse {

    private Course course;
    private ArrayList<Assignment> listOfAssignments;

    public AssignmentsInCourse(Course course, ArrayList<Assignment> listOfAssignments) {
        this.course = course;
        this.listOfAssignments = listOfAssignments;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Assignment> getListOfAssignments() {
        return listOfAssignments;
    }

}
