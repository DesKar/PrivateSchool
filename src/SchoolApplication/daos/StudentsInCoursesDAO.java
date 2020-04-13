package SchoolApplication.daos;

import SchoolApplication.Database;
import SchoolApplication.MainClass;
import static SchoolApplication.daos.CourseDAO.createCourseListFromResultSet;
import SchoolApplication.models.Student;
import SchoolApplication.models.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentsInCoursesDAO {

    public static int addStudentInCourse(Course selectedCourse, Student student) {
        int result = 0;
        String studentInCourseData = String.format("'%s', '%s'", student.getId(), selectedCourse.getId());
        String query = String.format("INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)" + "VALUES(%s);", studentInCourseData);
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

    public static int readNumberOfCoursesWithAssignedStudents() {
        int result = 0;
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`students_in_courses`;");
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

    public static ArrayList<Course> readCoursesWithRegisteredStudents() {
        String query = String.format(""
                + "SELECT DISTINCT(`courses`.`id`)," 
                + "    `courses`.`title`," 
                + "    `courses`.`stream`," 
                + "    `courses`.`type`," 
                + "    `courses`.`start_date`,"
                + "    `courses`.`end_date`" 
                + "FROM" 
                + "    `PrivateSchool`.`courses`," 
                + "    `PrivateSchool`.`students_in_courses`" 
                + "WHERE" 
                + "    `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`students_in_courses`.`courses_id`;");
        ResultSet rs = Database.getResults(query);
        return createCourseListFromResultSet(rs);
    }

    public static ArrayList<Student> readStudentsOfCourseWithCourseID(Course course) {
        int courseId = course.getId();
        String query = String.format(""
                + "SELECT *" 
                + "FROM `PrivateSchool`.`students`" 
                + "JOIN `PrivateSchool`.`students_in_courses` "
                + "     ON `PrivateSchool`.`students`.`id` = `PrivateSchool`.`students_in_courses`.`students_id`" 
                + "JOIN `PrivateSchool`.`courses` "
                + "     ON `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`students_in_courses`.`courses_id`" 
                + "WHERE" 
                + "    `PrivateSchool`.`courses`.`id` = '%s';", courseId);
        ResultSet rs = Database.getResults(query);
        return StudentDAO.createStudentListFromResultSet(rs);
    }

    public static ArrayList<Student> readStudentsRegisteredToManyCorses() {
        String query = String.format(""
                + "SELECT * "
                + "FROM `PrivateSchool`.`students` AS S,"
                + "    (SELECT `students_id`, COUNT(*) occurences"
                + "         FROM `PrivateSchool`.`students_in_courses`"
                + "     GROUP BY `students_id`"
                + "     HAVING COUNT(*) > 1) AS `T`"
                + "WHERE `T`.`students_id` = `S`.`id`;");
        ResultSet rs = Database.getResults(query);
        return StudentDAO.createStudentListFromResultSet(rs);
    }
    
    public static ArrayList<Student> readStudentsRegisteredToCourse(int courseID){
        String query = String.format(""
                + "SELECT * "
                + "FROM `PrivateSchool`.`students`" 
                + "JOIN `PrivateSchool`.`students_in_courses`"
                + "     ON `PrivateSchool`.`students_in_courses`.`students_id` = `PrivateSchool`.`students`.`id`" 
                +"WHERE `PrivateSchool`.`students_in_courses`.`courses_id` ='%s';", courseID);
        ResultSet rs = Database.getResults(query);
        return StudentDAO.createStudentListFromResultSet(rs);
        
    }

    public static boolean studentExistsInCourse(Student student, Course course) {
        int studentID = student.getId();
        int courseID = course.getId();
        String query = String.format(""
                + "SELECT count(1) FROM `PrivateSchool`.`students_in_courses`"
                + "WHERE `PrivateSchool`.`students_in_courses`.`students_id` = '%s'"
                + "     AND `PrivateSchool`.`students_in_courses`.`courses_id` = '%s';", studentID, courseID);
        return Database.tableIsNotEmpty(query);
    }

}
