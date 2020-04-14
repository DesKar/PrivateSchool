USE `PrivateSchoolDemo`;
-- Insert Data into tables

-- Students 
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("John", "Doe", "1988-02-03", "1850");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Ada", "Lovelace", "1983-01-23", "1500");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Jane", "Doe", "1983-06-19", "2000");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Markus", "Miller", "1993-08-25", "2000");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Mary", "Smith", "1975-08-01", "1500");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Sam", "Mendes", "1994-12-03", "0");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Ana", "Johnson", "1975-09-16", "2000");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Maria", "Sanchez", "1986-11-23", "1850");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("George", "Stevenson", "1987-03-03", "1500");
INSERT INTO `students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("John", "Papadopoulos", "1988-05-03", "1500");

-- Courses
INSERT INTO `courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Mathematics", "Technology", "Lab", "2020-01-08", "2020-06-05");
INSERT INTO `courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Algorithms", "Technology", "Lab", "2020-04-03", "2020-06-05");
INSERT INTO `courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Art History", "Humanistics", "Seminar", "2020-05-10", "2020-06-15");
INSERT INTO `courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Cooking", "Home economics", "Lab", "2020-05-01", "2020-05-15");

-- Trainers
INSERT INTO `trainers`(`first_name`, `last_name`,`subject`)
VALUES("Marianne","Uriol","Art");
INSERT INTO `trainers`(`first_name`, `last_name`,`subject`)
VALUES("Zoe","Kraft","Physics");
INSERT INTO `trainers`(`first_name`, `last_name`,`subject`)
VALUES("Helen","Moss","Computer Science");
INSERT INTO `trainers`(`first_name`, `last_name`,`subject`)
VALUES("John","Oliver","Science");
INSERT INTO `trainers`(`first_name`, `last_name`,`subject`)
VALUES("Martin","Nusli","House Economics");

-- Assignments
INSERT INTO `assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Linear Algebra","Individual assingment","2020-03-06","10","10");
INSERT INTO `assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Essay on El Greco","Bibliographic research","2020-12-12","5","5");
INSERT INTO `assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Binary Search algorithm","Implementation in Java","2020-04-08","10","10");
INSERT INTO `assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Basic recipes","Collect basic recipes","2020-05-15","5","5");
INSERT INTO `assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Buchberger's algorithm","Implementation in Java","2020-04-28","10","10");
INSERT INTO `assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Marc Chagall","Summary of life and work","2020-11-25","5","5");
INSERT INTO `assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Linear Algebra","Individual assignment","2020-03-15","10","10");


-- Register students to courses
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("1", "1");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("3", "1");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("7", "1");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("1", "2");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("2", "2");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("4", "3");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("6", "3");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("5", "4");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("8", "4");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("7", "2");
INSERT INTO `students_in_courses`(`students_id`, `courses_id`)
VALUES ("2", "4");


-- Assign trainers to courses
INSERT INTO `trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("3","1");
INSERT INTO `trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("1","2");
INSERT INTO `trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("2","3");
INSERT INTO `trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("5","4");
INSERT INTO `trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("4","4");
INSERT INTO `trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("1","3");

-- Assign assignments to courses
INSERT INTO  `assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("1","1");
INSERT INTO  `assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("7","1");
INSERT INTO  `assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("2","3");
INSERT INTO  `assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("3","2");
INSERT INTO  `assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("4","4");
INSERT INTO  `assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("5","2");
INSERT INTO  `assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("6","3");

