
package SchoolApplication;

import java.util.HashSet;
import java.util.Objects;

public class StudentsInCourse {
    private Course course;
    private HashSet<Student> listOfStudents;

    public StudentsInCourse(Course course, HashSet<Student> listOfStudents) {
        this.course = course;
        this.listOfStudents = listOfStudents;
    }

    public Course getCourse() {
        return course;
    }

    public HashSet<Student> getListOfStudents() {
        return listOfStudents;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.course);
        hash = 67 * hash + Objects.hashCode(this.listOfStudents);
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
        if (!Objects.equals(this.listOfStudents, other.listOfStudents)) {
            return false;
        }
        return true;
    }
    
    
    
}
