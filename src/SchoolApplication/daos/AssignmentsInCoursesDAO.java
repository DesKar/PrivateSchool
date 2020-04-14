package SchoolApplication.daos;

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
        String assignmentInCourseData = String.format("'%s', '%s'", assignment.getId(), selectedCourse.getId());
        String query = String.format("INSERT INTO `assignments_in_courses`(`assignments_id`, `courses_id`)" + "VALUES(%s);", assignmentInCourseData);
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

    public static int readNumberOfCoursesWithAssignedAssignments() {
        int result = 0;
        String query = String.format("SELECT count(1) FROM `assignments_in_courses`;");
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

    public static ArrayList<Course> readCoursesWithRegisteredAssignments() {
        String query = String.format(""
                + "SELECT DISTINCT(`courses`.`id`)," 
                +"    `courses`.`title`," 
                +"    `courses`.`stream`," 
                +"    `courses`.`type`," 
                +"    `courses`.`start_date`," 
                +"    `courses`.`end_date`" 
                +"FROM" 
                +"    `courses`, `assignments_in_courses`" 
                +"WHERE" 
                +"    `courses`.`id` = `assignments_in_courses`.`courses_id`;");
        ResultSet rs = MainClass.db.getResults(query);
        return createCourseListFromResultSet(rs);
    }

    public static ArrayList<Assignment> readAssignmentsOfCourseWithCourseID(Course course) {
        int courseId = course.getId();
        String query = String.format(""
                +"SELECT *" 
                +"FROM `assignments`" 
                +"JOIN" 
                +"    `assignments_in_courses` "
                +"  ON `assignments_in_courses`.`assignments_id` = `assignments`.`id`" 
                +"JOIN" 
                +"    `courses` "
                +" ON `courses`.`id` = `assignments_in_courses`.`courses_id`" 
                +"WHERE" 
                +"    `courses`.`id` = '%s';", courseId);
        ResultSet rs = MainClass.db.getResults(query);
        return AssignmentDAO.createAssignmentListFromResultSet(rs);
    }
    
    public static ArrayList<Assignment> readAssignmentsPerStudentPerCourse(int courseID, int studentID){
        String query = String.format(""
                +"SELECT *" 
                +"FROM `assignments`" 
                +"JOIN" 
                +"    `assignments_in_courses` "
                +"  ON `assignments_in_courses`.`assignments_id` = `assignments`.`id`" 
                +"JOIN" 
                +"    `students_in_courses` "
                +"  ON `students_in_courses`.`courses_id` = `assignments_in_courses`.`courses_id`" 
                +"WHERE" 
                +"    `assignments_in_courses`.`courses_id` = '%s' "
                +"AND `students_in_courses`.`students_id` = '%s';", courseID, studentID);
        ResultSet rs = MainClass.db.getResults(query);
        return AssignmentDAO.createAssignmentListFromResultSet(rs);
    }

    public static boolean assignmentExistsInCourse(Assignment assignment, Course course) {
        int assignmentId = assignment.getId();
        int courseID = course.getId();
        String query = String.format(""
                +"SELECT COUNT(1)" 
                +"FROM `assignments_in_courses`" 
                +"WHERE `assignments_in_courses`.`assignments_id` = '%s'" 
                +"      AND `assignments_in_courses`.`courses_id` = '%s';", 
                assignmentId, courseID);
        return MainClass.db.tableIsNotEmpty(query);
    }

}
