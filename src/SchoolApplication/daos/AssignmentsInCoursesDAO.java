package SchoolApplication.daos;

import SchoolApplication.Database;
import SchoolApplication.MainClass;
import static SchoolApplication.daos.CourseDAO.createCourseListFromResultSet;
import SchoolApplication.models.Course;
import SchoolApplication.models.Assignment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssignmentsInCoursesDAO {

    public static int addAssignmentInCourse(Course selectedCourse, Assignment assignment) {
        int result = 0;
        String assignmentInCourseData = String.format("\"%s\", \"%s\"", assignment.getId(), selectedCourse.getId());
        String query = String.format("INSERT INTO `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)" + "VALUES(%s);", assignmentInCourseData);
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

    public static int readNumberOfCoursesWithAssignedAssignments() {
        int result = 0;
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`assignments_in_courses`;");
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

    public static ArrayList<Course> readCoursesWithRegisteredAssignments() {
        String query = String.format("SELECT DISTINCT(`courses`.`id`),`courses`.`title`, `courses`.`stream`, `courses`.`type`, `courses`.`start_date`, `courses`.`end_date`  "
                + "FROM `PrivateSchool`.`courses`, `PrivateSchool`.`assignments_in_courses`\n"
                + "WHERE `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`;");
        ResultSet rs = Database.getResults(query);
        return createCourseListFromResultSet(rs);
    }

    public static ArrayList<Assignment> readAssignmentsOfCourseWithCourseID(Course course) {
        int courseId = course.getId();
        String query = String.format("SELECT \n"
                + "    `assignments`.`id`,\n"
                + "    `assignments`.`title`,\n"
                + "    `assignments`.`description`,\n"
                + "    `assignments`.`sub_date`,\n"
                + "    `assignments`.`oral_mark`,\n"
                + "    `assignments`.`local_mark`\n"
                + "FROM\n"
                + "    `PrivateSchool`.`assignments`,\n"
                + "    `PrivateSchool`.`courses`,\n"
                + "    `PrivateSchool`.`assignments_in_courses`\n"
                + "WHERE\n"
                + "    `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`\n"
                + "        AND `PrivateSchool`.`assignments`.`id` = `PrivateSchool`.`assignments_in_courses`.`assignments_id`\n"
                + "        AND `PrivateSchool`.`courses`.`id` = '%s';", courseId);
        ResultSet rs = Database.getResults(query);
        return AssignmentDAO.createAssignmentListFromResultSet(rs);
    }
    
    public static ArrayList<Assignment> readAssignmentsPerStudentPerCourse(int courseID, int studentID){
        String query = String.format("SELECT `PrivateSchool`.`assignments`.`id`,\n" 
                +"      `PrivateSchool`.`assignments`.`title`,\n" 
                +"      `PrivateSchool`.`assignments`.`description`,\n" 
                +"      `PrivateSchool`.`assignments`.`sub_date`,\n" 
                +"      `PrivateSchool`.`assignments`.`oral_mark`,\n" 
                +"      `PrivateSchool`.`assignments`.`local_mark`\n" 
                +"FROM\n" 
                +"      `PrivateSchool`.`assignments`\n" 
                +"JOIN `PrivateSchool`.`assignments_in_courses` "
                +"      ON  `PrivateSchool`.`assignments_in_courses`.`assignments_id` = `PrivateSchool`.`assignments`.`id`\n" 
                +"JOIN `PrivateSchool`.`students_in_courses` "
                +"      ON `PrivateSchool`.`students_in_courses`.`courses_id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`\n"
                +"WHERE `PrivateSchool`.`assignments_in_courses`.`courses_id` = '%s' "
                +"      and `PrivateSchool`.`students_in_courses`.`students_id` = '%s';", courseID, studentID);
        ResultSet rs = Database.getResults(query);
        return AssignmentDAO.createAssignmentListFromResultSet(rs);
    }

    public static boolean assignmentExistsInCourse(Assignment assignment, Course course) {
        int assignmentId = assignment.getId();
        int courseID = course.getId();
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`assignments_in_courses`"
                + "WHERE `PrivateSchool`.`assignments_in_courses`.`assignments_id` = '%s'"
                + "AND `PrivateSchool`.`assignments_in_courses`.`courses_id` = '%s';", assignmentId, courseID);
        return Database.tableIsNotEmpty(query);
    }

}
