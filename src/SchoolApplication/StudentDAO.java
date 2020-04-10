package SchoolApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {

    public static int createRecordInStudents(Student student, Database db) {
        int result = 0;
        String studentData = String.format("\"%s\", \"%s\", \"%s\", \"%s\"", student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
        String query = String.format("INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`)" + "VALUES(%s);", studentData);
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

    public static HashSet<Student> readAllStudents(HashSet<Student> students) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`students`");
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();
                int tuitionFees = rs.getInt("tuition_fees");
                Student student = new Student(id, first_name, last_name, dateOfBirth, tuitionFees);
                students.add(student);
            } while (rs.next());
        } catch (SQLException ex) {
            return students;
        }
        return students;
    }

    public static Student readStudentWithID(int selectedStudentID) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`students` WHERE `id` = %s", selectedStudentID);
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();
            int tuitionFees = rs.getInt("tuition_fees");
            Student student = new Student(id, first_name, last_name, dateOfBirth, tuitionFees);
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean studentExists(Student student, Database db) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`students` WHERE `first_name` = \"%s\" AND `last_name` = \"%s\" AND `date_of_birth` = \"%s\" AND `tuition_fees` = \"%s\"", student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
        return Database.recordExists(student, db, query);
    }

    public static boolean studentsExist(Database db) {
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`students`;");
        return Database.tableIsNotEmpty(db, query);

    }

}
