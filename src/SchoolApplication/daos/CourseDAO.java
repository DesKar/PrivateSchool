package SchoolApplication.daos;

import SchoolApplication.Database;
import SchoolApplication.MainClass;
import SchoolApplication.models.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAO {

    public static int createRecordInCourses(Course course) {
        int result = 0;
        String CourseData = String.format("\"%s\", \"%s\", \"%s\", \"%s\", \"%s\"", course.getTitle(), course.getStream(), course.getType(), course.getStartDate(), course.getEndDate());
        String query = String.format("INSERT INTO `PrivateSchool`.`courses`(`title`, `stream`, `type`, `start_date`, `end_date`)" + "VALUES(%s);", CourseData);
        Database.setStatement();
        Statement st = Database.getStatement();
        try {
            result = st.executeUpdate(query);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static ArrayList<Course> readAllCourses() {
        ArrayList<Course> courses = new ArrayList();
        String query = String.format("SELECT * FROM `PrivateSchool`.`courses`");
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String string = rs.getString("stream");
                String type = rs.getString("type");
                LocalDate startDate = rs.getDate("start_date").toLocalDate();
                LocalDate endDate = rs.getDate("end_date").toLocalDate();
                Course course = new Course(id, title, string, type, startDate, endDate);
                courses.add(course);
            } while (rs.next());
        } catch (SQLException ex) {
            return courses;
        }
        return courses;
    }

    public static Course readCourseWithID(int selectedCourseID) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`courses` WHERE `id` = %s", selectedCourseID);
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String string = rs.getString("stream");
            String type = rs.getString("type");
            LocalDate startDate = rs.getDate("start_date").toLocalDate();
            LocalDate endDate = rs.getDate("end_date").toLocalDate();
            Course course = new Course(id, title, string, type, startDate, endDate);
            return course;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ArrayList<Integer> readAllCoursesIds(){
        String query = String.format("SELECT `id` FROM `PrivateSchool`.`courses`;");
        ResultSet rs = Database.getResults(query);
        ArrayList<Integer> coursesIds = new ArrayList();
        try {
            rs.first();
             do {
                 int id = rs.getInt("id");
                 coursesIds.add(id);
            } while (rs.next());
             return coursesIds;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean courseExists(Course course) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`courses` WHERE `title` = \"%s\" AND `stream` = \"%s\" AND `type` = \"%s\" AND `start_date` = \"%s\" AND `end_date` = \"%s\"", course.getTitle(), course.getStream(), course.getType(), course.getStartDate(), course.getEndDate());
        return Database.recordExists(course, query);
    }

    public static boolean coursesExist( ) {
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`courses`;");
        return Database.tableIsNotEmpty(query);

    }

}
