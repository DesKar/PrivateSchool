package SchoolApplication.daos;

import SchoolApplication.Database;
import SchoolApplication.MainClass;
import SchoolApplication.models.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {

    public static int createRecordInStudents(Student student) {
        int result = 0;
        String studentData = String.format("'%s', '%s', '%s', '%s'", student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
        String query = String.format("INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`)" + "VALUES(%s);", studentData);
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

    public static ArrayList<Student> readAllStudents() {
        String query = String.format("SELECT * FROM `PrivateSchool`.`students`;");
        ResultSet rs = Database.getResults(query);
        return createStudentListFromResultSet(rs);
    }

    public static Student readStudentWithID(int selectedStudentID) {
        String query = String.format("SELECT * FROM `PrivateSchool`.`students` WHERE `id` = '%s'", selectedStudentID);
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

    public static ArrayList<Integer> readAllStudentsIds() {
        String query = String.format("SELECT `id` FROM `PrivateSchool`.`students`;");
        ResultSet rs = Database.getResults(query);
        ArrayList<Integer> studentsIds = new ArrayList();
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                studentsIds.add(id);
            } while (rs.next());
            return studentsIds;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean studentExists(Student student) {
        String query = String.format(""
                + "SELECT * "
                + "FROM `PrivateSchool`.`students` "
                + "WHERE `first_name` = '%s' "
                + "     AND `last_name` = '%s' "
                + "     AND `date_of_birth` = '%s' "
                + "     AND `tuition_fees` = '%s';", 
                student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getTuitionFees());
        return Database.recordExists(student, query);
    }

    public static boolean studentsExist() {
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`students`;");
        return Database.tableIsNotEmpty(query);
    }

    public static ArrayList<Student> createStudentListFromResultSet(ResultSet rs) {
        ArrayList<Student> students = new ArrayList();
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

}
