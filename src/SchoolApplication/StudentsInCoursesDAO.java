package SchoolApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentsInCoursesDAO {

    public static int addStudentInCourse(Course selectedCourse, Student student) {
        int result = 0;
        String studentInCourseData = String.format("\"%s\", \"%s\"", student.getId(), selectedCourse.getId());
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
        ArrayList<Course> courses = new ArrayList();
        String query = String.format("SELECT DISTINCT(`courses`.`id`),`courses`.`title`, `courses`.`stream`, `courses`.`type`, `courses`.`start_date`, `courses`.`end_date`  "
                + "FROM `PrivateSchool`.`courses`, `PrivateSchool`.`students_in_courses`\n"
                + "WHERE `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`students_in_courses`.`courses_id`;");
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

    public static ArrayList<Student> readStudentsOfCourseWithCourseID(Course course) {
        ArrayList<Student> students = new ArrayList();
        int courseId = course.getId();
        String query = String.format("SELECT \n"
                + "    `students`.`id`,\n"
                + "    `students`.`first_name`,\n"
                + "    `students`.`last_name`,\n"
                + "    `students`.`date_of_birth`,\n"
                + "    `students`.`tuition_fees`\n"
                + "FROM\n"
                + "    `PrivateSchool`.`students`,\n"
                + "    `PrivateSchool`.`courses`,\n"
                + "    `PrivateSchool`.`students_in_courses`\n"
                + "WHERE\n"
                + "    `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`students_in_courses`.`courses_id`\n"
                + "        AND `PrivateSchool`.`students`.`id` = `PrivateSchool`.`students_in_courses`.`students_id`\n"
                + "        AND `PrivateSchool`.`courses`.`id` = '%s';", courseId);
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

    public static boolean studentExistsInCourse(Student student, Course course) {
        int studentID = student.getId();
        int courseID = course.getId();
        String query = String.format("SELECT count(1) FROM `PrivateSchool`.`students_in_courses`"
                + "WHERE `PrivateSchool`.`students_in_courses`.`students_id` = '%s'"
                + "AND `PrivateSchool`.`students_in_courses`.`courses_id` = '%s';", studentID, courseID);
        return Database.tableIsNotEmpty(query);
    }
}
