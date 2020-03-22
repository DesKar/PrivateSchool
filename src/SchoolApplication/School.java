package SchoolApplication;

import java.util.ArrayList;

public class School {

    private ArrayList<Student> listOfStudents = new ArrayList();
    private ArrayList<Trainer> listOfTrainers = new ArrayList();
    private ArrayList<Assignment> listOfAssignments = new ArrayList();
    private ArrayList<Course> listOfCourses = new ArrayList();
    
    private ArrayList<StudentsInCourse> listOfStudentsInCourse = new ArrayList();

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
   
    public void addStudentsInCourse(StudentsInCourse studentsInCourse){
        this.listOfStudentsInCourse.add(studentsInCourse);
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
    

    public void printListOfStudents() {
        System.out.println("--------------------------------Students-------------------------------");
        String header = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", "ID", "First name", "Last name", "Date of Birth", "Tuition Fees(€)");
        System.out.println(header);
        for (Student student : listOfStudents) {
            String content = String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", listOfStudents.indexOf(student) + 1, student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
            System.out.println(content);
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public void printListOfTrainers() {
        System.out.println("----------------Trainers---------------");
        String header = String.format("|%-5s|%-15s|%-15s|", "ID", "First Name", "Last Name");
        System.out.println(header);
        for (Trainer trainer : listOfTrainers) {
            String content = String.format("|%-5s|%-15s|%-15s|", listOfTrainers.indexOf(trainer) + 1, trainer.getFirstName(), trainer.getLastName());
            System.out.println(content);
        }
        System.out.println("---------------------------------------");
    }

    public void printListOfAssignments() {
        System.out.println("-------------------------------------------------------Assignments-------------------------------------------------------");
        String header = String.format("|%-5s|%-25s|%-40s|%-18s|%-13s|%-13s|", "ID", "Title", "Description", "Submission Date", "Oral Mark", "Local Mark");
        System.out.println(header);
        for (Assignment assignment : listOfAssignments) {
            String content = String.format("|%-5s|%-25s|%-40s|%-18s|%-13d|%-13d|", listOfAssignments.indexOf(assignment) + 1, assignment.getTitle(), assignment.getDescription(), assignment.getSubDateTime(), assignment.getOralMark(), assignment.getLocalMark());
            System.out.println(content);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

    }

    public void printListOfCourses() {
        System.out.println("--------------------------------------------------Courses-------------------------------------------------");
        String header = String.format("|%-5s|%-25s|%-30s|%-13s|%-13s|%-13s|", "ID", "Title", "Stream", "Type", "Start Date", "End Date");
        System.out.println(header);
        for (Course course : listOfCourses) {
            String content = String.format("|%-5s|%-25s|%-30s|%-13s|%-13s|%-13s|", listOfCourses.indexOf(course) + 1, course.getTitle(), course.getStream(), course.getType(), course.getStartDate(), course.getEndDate());
            System.out.println(content);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }
}
