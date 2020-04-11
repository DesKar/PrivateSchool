package SchoolApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssignmentDAO {

    public static int createRecordInAssignments(Assignment assignment) {
        int result = 0;
        String assingmentData = String.format("\"%s\", \"%s\", \"%s\", \"%s\", \"%s\"", assignment.getTitle(), assignment.getDescription(), assignment.getSubDateTime(), assignment.getOralMark(), assignment.getLocalMark());
        String query = String.format("INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)" + "VALUES(%s);", assingmentData);
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

    public static ArrayList<Assignment> readAllAssignments() {
        ArrayList<Assignment> assignments = new ArrayList();
        String query = String.format("SELECT * FROM `PrivateSchool`.`assignments`");
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

    public static Assignment readAssignmentWithID(int selectedAssignmentID) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`assignments` WHERE `id` = %s", selectedAssignmentID);
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            LocalDate subDate = rs.getDate("sub_date").toLocalDate();
            int oralMark = rs.getInt("oral_mark");
            int localMark = rs.getInt("local_mark");
            Assignment assignment = new Assignment(id, title, description, subDate, oralMark, localMark);
            return assignment;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ArrayList<Integer> readAllAssignmentsIds() {
        String query = String.format("SELECT `id` FROM `PrivateSchool`.`assignments`;");
        ResultSet rs = Database.getResults(query);
        ArrayList<Integer> assignmentsIds = new ArrayList();
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                assignmentsIds.add(id);
            } while (rs.next());
            return assignmentsIds;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean assignmentExists(Assignment assignment) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`assignments` WHERE `title` = \"%s\" AND `sub_date` = \"%s\"", assignment.getTitle(), assignment.getSubDateTime());
        return Database.recordExists(assignment, query);
    }

    public static boolean assignmentsExist() {
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`assignments`;");
        return Database.tableIsNotEmpty(query);
    }

}
