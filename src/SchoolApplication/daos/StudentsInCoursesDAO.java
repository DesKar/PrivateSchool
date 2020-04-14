package SchoolApplication.daos;

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
        String query = String.format("INSERT INTO `students_in_courses`(`students_id`, `courses_id`)" + "VALUES(%s);", studentInCourseData);
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

    public static int readNumberOfCoursesWithAssignedStudents() {
        int result = 0;
        String query = String.format("SELECT count(1) FROM `students_in_courses`;");
        ResultSet rs = MainClass.db.getResults(query);
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
                + "    `courses`," 
                + "    `students_in_courses`" 
                + "WHERE" 
                + "    `courses`.`id` = `students_in_courses`.`courses_id`;");
        ResultSet rs = MainClass.db.getResults(query);
        return createCourseListFromResultSet(rs);
    }

    public static ArrayList<Student> readStudentsOfCourseWithCourseID(Course course) {
        int courseId = course.getId();
        String query = String.format(""
                + "SELECT *" 
                + "FROM `students`" 
                + "JOIN `students_in_courses` "
                + "     ON `students`.`id` = `students_in_courses`.`students_id`" 
                + "JOIN `courses` "
                + "     ON `courses`.`id` = `students_in_courses`.`courses_id`" 
                + "WHERE" 
                + "    `courses`.`id` = '%s';", courseId);
        ResultSet rs = MainClass.db.getResults(query);
        return StudentDAO.createStudentListFromResultSet(rs);
    }

    public static ArrayList<Student> readStudentsRegisteredToManyCorses() {
        String query = String.format(""
                + "SELECT * "
                + "FROM `students` AS S,"
                + "    (SELECT `students_id`, COUNT(*) occurences"
                + "         FROM `students_in_courses`"
                + "     GROUP BY `students_id`"
                + "     HAVING COUNT(*) > 1) AS `T`"
                + "WHERE `T`.`students_id` = `S`.`id`;");
        ResultSet rs = MainClass.db.getResults(query);
        return StudentDAO.createStudentListFromResultSet(rs);
    }
    
    public static ArrayList<Student> readStudentsRegisteredToCourse(int courseID){
        String query = String.format(""
                + "SELECT * "
                + "FROM `students`" 
                + "JOIN `students_in_courses`"
                + "     ON `students_in_courses`.`students_id` = `students`.`id`" 
                +"WHERE `students_in_courses`.`courses_id` ='%s';", courseID);
        ResultSet rs = MainClass.db.getResults(query);
        return StudentDAO.createStudentListFromResultSet(rs);
        
    }

    public static boolean studentExistsInCourse(Student student, Course course) {
        int studentID = student.getId();
        int courseID = course.getId();
        String query = String.format(""
                + "SELECT count(1) FROM `students_in_courses`"
                + "WHERE `students_in_courses`.`students_id` = '%s'"
                + "     AND `students_in_courses`.`courses_id` = '%s';", studentID, courseID);
        return MainClass.db.tableIsNotEmpty(query);
    }

}
