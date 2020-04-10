package SchoolApplication;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentsInCoursesDAO {

    public static int addStudentInCourse(Course selectedCourse, Student student, Database db) {
        int result = 0;
        String studentInCourseData = String.format("\"%s\", \"%s\"", student.getId(), selectedCourse.getId());
        String query = String.format("INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)" + "VALUES(%s);", studentInCourseData);
        db.setStatement();
        Statement st = db.getStatement();
        try {
            result = st.executeUpdate(query);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

}
