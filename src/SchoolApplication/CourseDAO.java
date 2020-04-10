package SchoolApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAO {

    public static int createRecordInCourses(Course course, Database db) {
        int result = 0;
        String CourseData = String.format("\"%s\", \"%s\", \"%s\", \"%s\", \"%s\"", course.getTitle(), course.getStream(), course.getType(), course.getStartDate(), course.getEndDate());
        String query = String.format("INSERT INTO `PrivateSchool`.`Courses`(`title`, `stream`, `type`, `start_date`, `end_date`)" + "VALUES(%s);", CourseData);
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

    public static HashSet<Course> readAllCourses(HashSet<Course> courses) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`Courses`");
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                String title = rs.getString("title");
                String string = rs.getString("stream");
                String type = rs.getString("type");
                LocalDate startDate = rs.getDate("start_date").toLocalDate();
                LocalDate endDate = rs.getDate("end_date").toLocalDate();
                Course course = new  Course(title,string, type, startDate, endDate);
                courses.add(course);
            } while (rs.next());
        } catch (SQLException ex) {
            return courses;
        }
        return courses;
    }

    public static boolean courseExists(Course course, Database db) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`Courses` WHERE `title` = \"%s\" AND `stream` = \"%s\" AND `type` = \"%s\" AND `start_date` = \"%s\" AND `end_date` = \"%s\"", course.getTitle(), course.getStream(), course.getType(), course.getStartDate(), course.getEndDate());
        return Database.recordExists(course, db, query);
    }

}
