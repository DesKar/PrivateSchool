
package SchoolApplication;

import java.util.ArrayList;
import java.util.Objects;

public class StudentsInCourse {
    private Course course;
    private ArrayList<Student> studentsInCourse;

    public StudentsInCourse(Course course, ArrayList<Student> listOfStudents) {
        this.course = course;
        this.studentsInCourse = listOfStudents;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Student> getStudentsInCourse() {
        return studentsInCourse;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.course);
        hash = 67 * hash + Objects.hashCode(this.studentsInCourse);
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
        final StudentsInCourse other = (StudentsInCourse) obj;
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.studentsInCourse, other.studentsInCourse)) {
            return false;
        }
        return true;
    }
    
    
    
}
