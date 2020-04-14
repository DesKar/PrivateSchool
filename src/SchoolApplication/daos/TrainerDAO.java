package SchoolApplication.daos;

import SchoolApplication.MainClass;
import SchoolApplication.models.Trainer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainerDAO {

    public static int createRecordInTrainers(Trainer trainer) {
        int result = 0;
        String trainerData = String.format("'%s', '%s', '%s'", trainer.getFirstName(), trainer.getLastName(), trainer.getSubject());
        String query = String.format("INSERT INTO `trainers`(`first_name`, `last_name`, `subject`)" + "VALUES(%s);", trainerData);
        MainClass.db.setStatement();
        Statement st = MainClass.db.getStatement();
        try {
            result = st.executeUpdate(query);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static ArrayList<Trainer> readAllTrainers() {
        String query = String.format("SELECT * FROM `trainers`;");
        ResultSet rs = MainClass.db.getResults(query);
        return createTrainerListFromResultSet(rs);
    }

    public static ArrayList<Integer> readAllTrainersIds() {
        String query = String.format("SELECT `id` FROM `trainers`;");
        ResultSet rs = MainClass.db.getResults(query);
        ArrayList<Integer> trainersIds = new ArrayList();
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                trainersIds.add(id);
            } while (rs.next());
            return trainersIds;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Trainer readTrainerWithID(int selectedTrainerID) {
        String query = String.format(""
                + "SELECT * FROM `trainers` "
                + "WHERE `id` = %s;", selectedTrainerID);
        ResultSet rs = MainClass.db.getResults(query);
        try {
            rs.first();
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String subject = rs.getString("subject");
            Trainer trainer = new Trainer(id, first_name, last_name, subject);
            return trainer;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean trainerExists(Trainer trainer) {
        String query = String.format(""
                + "SELECT * FROM `trainers` "
                + "WHERE `first_name` = '%s' "
                + "     AND `last_name` = '%s' "
                + "     AND `subject` = '%s';", 
                trainer.getFirstName(), trainer.getLastName(), trainer.getSubject());
        return MainClass.db.recordExists(trainer, query);
    }

    public static boolean trainersExist() {
        String query = String.format("SELECT count(1) FROM `trainers`;");
        return MainClass.db.tableIsNotEmpty(query);
    }

    public static ArrayList<Trainer> createTrainerListFromResultSet(ResultSet rs) {
        ArrayList<Trainer> trainers = new ArrayList();
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String subject = rs.getString("subject");
                Trainer trainer = new Trainer(id, first_name, last_name, subject);
                trainers.add(trainer);
            } while (rs.next());
        } catch (SQLException ex) {
            return trainers;
        }
        return trainers;

    }
}
