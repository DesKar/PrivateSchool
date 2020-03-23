package SchoolApplication;

import java.util.ArrayList;
import java.util.Objects;

public class TrainersInCourse {

    private Course course;
    private ArrayList<Trainer> listOfTrainers;

    public TrainersInCourse(Course course, ArrayList<Trainer> listOfTrainers) {
        this.course = course;
        this.listOfTrainers = listOfTrainers;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Trainer> getListOfTrainers() {
        return listOfTrainers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.course);
        hash = 59 * hash + Objects.hashCode(this.listOfTrainers);
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
        final TrainersInCourse other = (TrainersInCourse) obj;
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.listOfTrainers, other.listOfTrainers)) {
            return false;
        }
        return true;
    }

}
