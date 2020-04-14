package SchoolApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private final String DB_URL = "localhost:3306";
    private String DB_NAME = "";
    private String FULL_DB_URL = String.format("jdbc:mysql://%s/%s?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", DB_URL, DB_NAME);
    private String DB_USER = "";
    private String DB_PASSWD = "";

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public Database(String dbName, String username, String password) {
        this.DB_NAME = dbName;
        this.DB_USER = username;
        this.DB_PASSWD = password;
        getConnection();
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            connection.setCatalog(this.DB_NAME);
            return connection;
        } catch (SQLException ex) {
            System.out.println("Could not connect");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet aResultSet) {
        resultSet = aResultSet;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResults(String query) {
        try {
            setStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }

    }

    public boolean recordExists(Object o, String query) {
        ResultSet rs = getResults(query);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean tableIsNotEmpty(String query) {
        ResultSet rs = this.getResults(query);
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

}
