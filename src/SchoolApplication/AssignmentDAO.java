
package SchoolApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AssignmentDAO {

    public static int createRecordInAssignments(Assignment assignment, Database db) {
        int result = 0;
        String assingmentData = String.format("\"%s\", \"%s\", \"%s\", \"%s\", \"%s\"", assignment.getTitle(), assignment.getDescription(), assignment.getSubDateTime(), assignment.getOralMark(), assignment.getLocalMark());
        String query = String.format("INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)" + "VALUES(%s);", assingmentData);
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
    
        public static HashSet<Assignment> readAllAssignments(HashSet<Assignment> assignments) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`assignments`");
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                String title = rs.getString("title");
                String description = rs.getString("description");
                LocalDate subDate = rs.getDate("sub_date").toLocalDate();
                int oralMark = rs.getInt("oral_mark");
                int localMark = rs.getInt("local_mark");
                Assignment assignment = new  Assignment(title, description, subDate, oralMark, localMark);
                assignments.add(assignment);
            } while (rs.next());
        } catch (SQLException ex) {
            return assignments;
        }
        return assignments;
    }

    public static boolean assignmentExists(Assignment assignment, Database db) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`Assignments` WHERE `title` = \"%s\" AND `sub_date` = \"%s\"", assignment.getTitle(), assignment.getSubDateTime());
        return Database.recordExists(assignment, db, query);
    }
    
}
