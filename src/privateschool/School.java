package privateschool;

import java.util.ArrayList;

public class School {

    private ArrayList<Student> listOfStudents = new ArrayList();
    private ArrayList<Trainer> listOfTrainers = new ArrayList();
    private ArrayList<Assignment> listOfAssignments = new ArrayList();
    private ArrayList<Course> listOfCourses = new ArrayList();

    public void setListOfStudents(Student student) {
        this.listOfStudents.add(student);
    }

    public void setListOfTrainers(Trainer trainer) {
        this.listOfTrainers.add(trainer);
    }

    public void setListOfAssignments(Assignment assignment) {
        this.listOfAssignments.add(assignment);
    }

    public void setListOfCourses(Course course) {
        this.listOfCourses.add(course);
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

    public void printListOfStudents() {
        String header = String.format("|%-15s|%-15s|%-15s|%-15s|", "First name", "Last name", "Date of Birth", "Tuition Fees");
        System.out.println(header);
        for (Student student : listOfStudents) {
            String content = String.format("|%-15s|%-15s|%-15s|%-15s|", student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
            System.out.println(content);
        }
    }

    public void printListOfTrainers() {
        String header = String.format("|%-15s|%-15s|", "First Name", "Last Name");
        System.out.println(header);
        for (Trainer trainer : listOfTrainers) {
            String content = String.format("|%-15s|%-15s|", trainer.getFirstName(), trainer.getLastName());
            System.out.println(content);
        }
    }

    public void printListOfAssignments() {
        String header = String.format("|%-25s|%-40s|%-18s|%-13s|%-13s|", "Title", "Description", "Submission Date", "Oral Mark", "Local Mark");
        System.out.println(header);
        for (Assignment assignment : listOfAssignments) {
            String content = String.format("|%-25s|%-40s|%-18s|%-13d|%-13d|", assignment.getTitle(), assignment.getDescription(), assignment.getSubDateTime(), assignment.getOralMark(), assignment.getLocalMark());
            System.out.println(content);
        }
    }

    public void printListOfCourses() {
        String header = String.format("|%-25s|%-30s|%-13s|%-13s|%-13s|", "Title", "Stream", "Type", "Start Date", "End Date");
        System.out.println(header);
        for (Course course : listOfCourses) {
            String content = String.format("|%-25s|%-30s|%-13s|%-13s|%-13s|", course.getTitle(), course.getStream(), course.getType(), course.getStartDate(), course.getEndDate());
            System.out.println(content);
        }

    }
}
