
package SchoolApplication;

import java.util.ArrayList;

public class StudentsInCourse {
    private Course course;
    private ArrayList<Student> listOfStudents;

    public StudentsInCourse(Course course, ArrayList<Student> listOfStudents) {
        this.course = course;
        this.listOfStudents = listOfStudents;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }
    
    
    
}
