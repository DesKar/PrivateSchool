package SchoolApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainersInCoursesDAO {

    public static int addTrainerInCourse(Course selectedCourse, Trainer trainer, Database db) {
        int result = 0;
        String trainerInCourseData = String.format("\"%s\", \"%s\"", trainer.getId(), selectedCourse.getId());
        String query = String.format("INSERT INTO `PrivateSchool`.`trainers_in_courses`(`trainers_id`, `courses_id`)" + "VALUES(%s);", trainerInCourseData);
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

    public static int readNumberOfCoursesWithAssignedTrainers(Database db) {
        int result = 0;
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`trainers_in_courses`;");
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

    public static ArrayList<Course> readCoursesWithRegisteredTrainers(Database db) {
        ArrayList<Course> courses = new ArrayList();
        String query = String.format("SELECT DISTINCT(`courses`.`id`),`courses`.`title`, `courses`.`stream`, `courses`.`type`, `courses`.`start_date`, `courses`.`end_date`  "
                + "FROM `PrivateSchool`.`courses`, `PrivateSchool`.`trainers_in_courses`\n"
                + "WHERE `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`trainers_in_courses`.`courses_id`;");
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String string = rs.getString("stream");
                String type = rs.getString("type");
                LocalDate startDate = rs.getDate("start_date").toLocalDate();
                LocalDate endDate = rs.getDate("end_date").toLocalDate();
                Course course = new Course(id, title, string, type, startDate, endDate);
                courses.add(course);
            } while (rs.next());
        } catch (SQLException ex) {
            return courses;
        }
        return courses;
    }

    public static ArrayList<Trainer> readTrainersOfCourseWithCourseID(Course course, Database db) {
        ArrayList<Trainer> trainers = new ArrayList();
        int courseId = course.getId();
        String query = String.format("SELECT \n"
                + "    `trainers`.`id`,\n"
                + "    `trainers`.`first_name`,\n"
                + "    `trainers`.`last_name`,\n"
                + "    `trainers`.`subject`\n"
                + "FROM\n"
                + "    `PrivateSchool`.`trainers`,\n"
                + "    `PrivateSchool`.`courses`,\n"
                + "    `PrivateSchool`.`trainers_in_courses`\n"
                + "WHERE\n"
                + "    `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`trainers_in_courses`.`courses_id`\n"
                + "        AND `PrivateSchool`.`trainers`.`id` = `PrivateSchool`.`trainers_in_courses`.`trainers_id`\n"
                + "        AND `PrivateSchool`.`courses`.`id` = '%s';", courseId);
        ResultSet rs = Database.getResults(query);
        try {
            rs.first();
            do {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String subject = rs.getString("subject");
                Trainer trainer = new Trainer(id, first_name, last_name, subject);
                trainers.add(trainer);
            } while (rs.next());
        } catch (SQLException ex) {
            return trainers;
        }
        return trainers;
    }

    public static boolean trainerExistsInCourse(Trainer trainer, Course course, Database db) {
        int courseID = course.getId();
        int trainerID = trainer.getId();
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`trainers_in_courses`"
                + "WHERE `PrivateSchool`.`trainers_in_courses`.`trainers_id` = '%s'"
                + "AND `PrivateSchool`.`trainers_in_courses`.`courses_id` = '%s';", trainerID, courseID);
        return Database.tableIsNotEmpty(db, query);
    }

}
