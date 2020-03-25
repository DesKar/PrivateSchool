package SchoolApplication;

import java.util.ArrayList;
import java.util.Objects;

public class AssignmentsInCourse {

    private Course course;
    private ArrayList<Assignment> assignments;

    public AssignmentsInCourse(Course course, ArrayList<Assignment> listOfAssignments) {
        this.course = course;
        this.assignments = listOfAssignments;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Assignment> getListOfAssignments() {
        return assignments;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.course);
        hash = 79 * hash + Objects.hashCode(this.assignments);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssignmentsInCourse other = (AssignmentsInCourse) obj;
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.assignments, other.assignments)) {
            return false;
        }
        return true;
    }
    
    

}
