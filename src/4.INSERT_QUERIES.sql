-- Insert a student
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("John", "Doe", "1988-02-03", "1850");

-- Insert a trainer
INSERT INTO `PrivateSchool`.`trainers`(`first_name`, `last_name`,`subject`)
VALUES("Marianne","Uriol","Art");

-- Insert an assignment
INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Linear Algebra","Individual assingment","2020-03-06","10","10");

-- Insert a course
INSERT INTO `PrivateSchool`.`courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Mathematics", "Technology", "Lab", "2020-01-08", "2020-06-05");

-- Insert a student in course
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("1", "1");

-- Insert a trainer in course
INSERT INTO `PrivateSchool`.`trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("3","1");

-- Insert an assignment in course
INSERT INTO  `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("1","1");

-- Insert assignment in student in course
-- Assuming that an assignment is only registered to one course, a student gets all the assignments of the course he/she is registered in.
-- Therefore, this insert translates to an insert student in course.
-- This would be different if we wanted a student to have a mark per assignment, which is not asked here. 
-- Due to lack of time, this was not implemented in this part B. It could be an extension of the project.
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("1", "1");

