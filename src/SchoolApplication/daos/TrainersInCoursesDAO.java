package SchoolApplication.daos;

import SchoolApplication.MainClass;
import static SchoolApplication.daos.CourseDAO.createCourseListFromResultSet;
import static SchoolApplication.daos.TrainerDAO.createTrainerListFromResultSet;
import SchoolApplication.models.Trainer;
import SchoolApplication.models.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainersInCoursesDAO {

    public static int addTrainerInCourse(Course selectedCourse, Trainer trainer) {
        int result = 0;
        String trainerInCourseData = String.format("'%s', '%s'", trainer.getId(), selectedCourse.getId());
        String query = String.format("INSERT INTO `trainers_in_courses`(`trainers_id`, `courses_id`)" + "VALUES(%s);", trainerInCourseData);
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

    public static int readNumberOfCoursesWithAssignedTrainers() {
        int result = 0;
        String query = String.format("SELECT count(1) FROM `trainers_in_courses`;");
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

    public static ArrayList<Course> readCoursesWithRegisteredTrainers() {
        String query = String.format(""
                + "SELECT DISTINCT(`courses`.`id`),"
                + "                 `courses`.`title`, "
                + "                 `courses`.`stream`, "
                + "                 `courses`.`type`, "
                + "                 `courses`.`start_date`, "
                + "                 `courses`.`end_date`  "
                + "FROM "
                + "         `courses`, `trainers_in_courses`"
                + "WHERE"
                + "         `courses`.`id` = `trainers_in_courses`.`courses_id`;");
        ResultSet rs = MainClass.db.getResults(query);
        return createCourseListFromResultSet(rs);
    }

    public static ArrayList<Trainer> readTrainersOfCourseWithCourseID(Course course) {
        int courseId = course.getId();
        String query = String.format(""
                + "SELECT *" 
                + "FROM `trainers`"
                + "JOIN" 
                + "    `trainers_in_courses` "
                + " ON `trainers`.`id` = `trainers_in_courses`.`trainers_id`" 
                + "JOIN" 
                + "    `courses` "
                + " ON `courses`.`id` = `trainers_in_courses`.`courses_id`" 
                +"WHERE" 
                +"    `courses`.`id` = '%s';", courseId);
        ResultSet rs = MainClass.db.getResults(query);
        return createTrainerListFromResultSet(rs);

    }

    public static boolean trainerExistsInCourse(Trainer trainer, Course course) {
        int courseID = course.getId();
        int trainerID = trainer.getId();
        String query = String.format(""
                + "SELECT count(1) "
                + "FROM `trainers_in_courses`"
                + "WHERE "
                + "     `trainers_in_courses`.`trainers_id` = '%s'"
                + "     AND `trainers_in_courses`.`courses_id` = '%s';", 
                trainerID, courseID);
        return MainClass.db.tableIsNotEmpty(query);
    }

}
