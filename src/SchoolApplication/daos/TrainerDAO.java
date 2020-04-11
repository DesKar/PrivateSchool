package SchoolApplication.daos;

import SchoolApplication.Database;
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
        String trainerData = String.format("\"%s\", \"%s\", \"%s\"", trainer.getFirstName(), trainer.getLastName(), trainer.getSubject());
        String query = String.format("INSERT INTO `PrivateSchool`.`trainers`(`first_name`, `last_name`, `subject`)" + "VALUES(%s);", trainerData);
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

    public static ArrayList<Trainer> readAllTrainers() {
        ArrayList<Trainer> trainers = new ArrayList();
        String query = String.format("SELECT * FROM `PrivateSchool`.`trainers`");
        ResultSet rs = Database.getResults(query);
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

    public static ArrayList<Integer> readAllTrainersIds() {
        String query = String.format("SELECT `id` FROM `PrivateSchool`.`trainers`;");
        ResultSet rs = Database.getResults(query);
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
        String query = String.format("SELECT * FROM `PrivateSchool`.`trainers` WHERE `id` = %s", selectedTrainerID);
        ResultSet rs = Database.getResults(query);
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
        String query = String.format("SELECT * FROM `PrivateSchool`.`trainers` WHERE `first_name` = \"%s\" AND `last_name` = \"%s\" AND `subject` = \"%s\"", trainer.getFirstName(), trainer.getLastName(), trainer.getSubject());
        return Database.recordExists(trainer, query);
    }

    public static boolean trainersExist() {
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`trainers`;");
        return Database.tableIsNotEmpty(query);
    }

}
