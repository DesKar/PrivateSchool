package SchoolApplication;

import java.util.ArrayList;

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

}