package SchoolApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainerDAO {

    public static int createRecordInTrainers(Trainer trainer, Database db) {
        int result = 0;
        String trainerData = String.format("\"%s\", \"%s\", \"%s\"", trainer.getFirstName(), trainer.getLastName(), trainer.getSubject());
        String query = String.format("INSERT INTO `PrivateSchool`.`trainers`(`first_name`, `last_name`, `subject`)" + "VALUES(%s);", trainerData);
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

    public static HashSet<Trainer> readAllTrainers(HashSet<Trainer> trainers) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`trainers`");
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String subject = rs.getString("subject");
               Trainer trainer = new Trainer(first_name, last_name, subject);
                trainers.add(trainer);
            } while (rs.next());
        } catch (SQLException ex) {
            return trainers;
        }
        return trainers;
    }

    public static boolean recordExists(Trainer trainer, Database db) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`Trainers` WHERE `first_name` = \"%s\" AND `last_name` = \"%s\" AND `subject` = \"%s\"", trainer.getFirstName(), trainer.getLastName(), trainer.getSubject());
        return Database.recordExists(trainer, db, query);
    }

}
