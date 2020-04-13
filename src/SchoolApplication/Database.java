package SchoolApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static final String DB_URL = "localhost:3306";
    private static final String FULL_DB_URL = "jdbc:mysql://" + DB_URL + "/PrivateSchool?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
//    TODO change user
    private static final String DB_USER = "root";
    private static final String DB_PASSWD = "password";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public Database() {
        getConnection();
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            return connection;
        } catch (SQLException ex) {
            System.out.println("Could not connect");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }

    public static void setResultSet(ResultSet aResultSet) {
        resultSet = aResultSet;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static ResultSet getResults(String query) {
        try {
            setStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }

    }

    public static boolean recordExists(Object o, String query) {
        ResultSet rs = getResults(query);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean tableIsNotEmpty(String query) {
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            int counter = rs.getInt("count(1)");
            if (counter != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void emptyDatabase() {
        try {
            String query = "DELETE FROM `PrivateSchool`.`students_in_courses`;";
            int rs = statement.executeUpdate(query);
            query = "DELETE FROM `PrivateSchool`.`assignments_in_courses`;";
            rs = statement.executeUpdate(query);
            query = "DELETE FROM `PrivateSchool`.`trainers_in_courses`;";
            rs = statement.executeUpdate(query);
            query = "DELETE FROM `PrivateSchool`.`students`;`;";
            rs = statement.executeUpdate(query);
            query = "DELETE FROM `PrivateSchool`.`assignments`;";
            rs = statement.executeUpdate(query);
            query = "DELETE FROM `PrivateSchool`.`assignments_in_courses`;";
            rs = statement.executeUpdate(query);
            query = "DELETE FROM `PrivateSchool`.`courses`;";    
            rs = statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
