package SchoolApplication;

import java.time.LocalDate;
import java.util.ArrayList;

public class RealSchool extends School {

    public void addStudentToSchool() {
        String firstName = Utils.getStringWithMessage("Student first name: ");
        String lastName = Utils.getStringWithMessage("Student last name: ");
        LocalDate dateOfBirth = Utils.getDate("Student date of birth(YYYY-MM-DD): ");
        int tuitionFees = Utils.getIntNumber("Tuition fees: ", "Please provide a number bigger than 0: ", 0, Integer.MAX_VALUE);
        Student student = new Student(firstName, lastName, dateOfBirth, tuitionFees);
        super.addStudentInListOfStudents(student);
    }

    public void addTrainerToSchool() {
        String firstName = Utils.getStringWithMessage("Trainer first name: ");
        String lastName = Utils.getStringWithMessage("Trainer last name: ");
        String subject = Utils.getStringWithMessage("Trainer subject: ");
        Trainer trainer = new Trainer(firstName, lastName, subject);
        super.addTrainerInListOfTrainers(trainer);
    }

    public void addAssignmentToSchool() {
        String title = Utils.getStringWithMessage("Assignment title: ");
        String description = Utils.getStringWithMessage("Assignment description: ");
        LocalDate subDateTime = Utils.getDate("Assignment submission date (YYYY-MM-DD): ");
        int oralMark = Utils.getIntNumber("Oral Mark: ", "Please provide a number between 0-10: ", 0, 10);
        int localMark = Utils.getIntNumber("Local mark: ", "Please provide a number between 0-10: ", 0, 10);
        Assignment assignment = new Assignment(title, description, subDateTime, oralMark, localMark);
        if(!assignmentExists(assignment)){
        super.addAssignmentInListOfAssignments(assignment);
        }
    }

    public void addCourseToSchool() {
        String title = Utils.getStringWithMessage("Course title: ");
        String stream = Utils.getStringWithMessage("Course stream title: ");
        String type = Utils.getStringWithMessage("Course type: ");
        LocalDate startDate = Utils.getDate("Course starting date (YYYY-MM-DD): ");
        LocalDate endDate = Utils.getDate("Course ending date (YYYY-MM-DD): ");
        Course course = new Course(title, stream, type, startDate, endDate);
        if(!CourseExists(course)){
                    super.addSCourseInListOfCourses(course);
        }
    }

    private boolean assignmentExists(Assignment newAssignmnet) {
        ArrayList<Assignment> listOfAssignments = super.getListOfAssignments();
        for(Assignment assignment:listOfAssignments){
            if(newAssignmnet.equals(assignment)){
                return true;
            }
        }
        return false;
    }
    
     private boolean CourseExists(Course newCourse) {
        ArrayList<Course> listOfCourses = super.getListOfCourses();
        for(Course course:listOfCourses){
            if(newCourse.equals(course)){
                return true;
            }
        }
        return false;
    }
}
