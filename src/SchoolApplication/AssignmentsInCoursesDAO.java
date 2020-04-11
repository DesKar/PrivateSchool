package SchoolApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssignmentsInCoursesDAO {

    public static int addAssignmentInCourse(Course selectedCourse, Assignment assignment, Database db) {
        int result = 0;
        String assignmentInCourseData = String.format("\"%s\", \"%s\"", assignment.getId(), selectedCourse.getId());
        String query = String.format("INSERT INTO `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)" + "VALUES(%s);", assignmentInCourseData);
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

    public static int readNumberOfCoursesWithAssignedAssignments(Database db) {
        int result = 0;
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`assignments_in_courses`;");
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                result += 1;
            } while (rs.next());
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static ArrayList<Course> readCoursesWithRegisteredAssignments(Database db) {
        ArrayList<Course> courses = new ArrayList();
        String query = String.format("SELECT DISTINCT(`courses`.`id`),`courses`.`title`, `courses`.`stream`, `courses`.`type`, `courses`.`start_date`, `courses`.`end_date`  "
                + "FROM `PrivateSchool`.`courses`, `PrivateSchool`.`assignments_in_courses`\n"
                + "WHERE `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`;");
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

    public static ArrayList<Assignment> readAssignmentsOfCourseWithCourseID(Course course, Database db) {
        ArrayList<Assignment> assignments = new ArrayList();
        int courseId = course.getId();
        String query = String.format("SELECT \n"
                + "    `assignments`.`id`,\n"
                + "    `assignments`.`title`,\n"
                + "    `assignments`.`description`,\n"
                + "    `assignments`.`sub_date`,\n"
                + "    `assignments`.`oral_mark`,\n"
                + "    `assignments`.`local_mark`\n"
                + "FROM\n"
                + "    `PrivateSchool`.`assignments`,\n"
                + "    `PrivateSchool`.`courses`,\n"
                + "    `PrivateSchool`.`assignments_in_courses`\n"
                + "WHERE\n"
                + "    `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`\n"
                + "        AND `PrivateSchool`.`assignments`.`id` = `PrivateSchool`.`assignments_in_courses`.`assignments_id`\n"
                + "        AND `PrivateSchool`.`courses`.`id` = '%s';", courseId);
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                LocalDate subDate = rs.getDate("sub_date").toLocalDate();
                int oralMark = rs.getInt("oral_mark");
                int localMark = rs.getInt("local_mark");
                Assignment assignment = new Assignment(id, title, description, subDate, oralMark, localMark);
                assignments.add(assignment);
            } while (rs.next());
        } catch (SQLException ex) {
            return assignments;
        }
        return assignments;
    }

    public static boolean assignmentExistsInCourse(Assignment assignment, Course course, Database db) {
        int assignmentId = assignment.getId();
        int courseID = course.getId();
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`assignments_in_courses`"
                + "WHERE `PrivateSchool`.`assignments_in_courses`.`assignments_id` = '%s'"
                + "AND `PrivateSchool`.`assignments_in_courses`.`courses_id` = '%s';", assignmentId, courseID);
        return Database.tableIsNotEmpty(db, query);
    }

}
