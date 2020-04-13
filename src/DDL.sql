CREATE SCHEMA IF NOT EXISTS `PrivateSchool`;

-- Create tables for main entities 
CREATE TABLE IF NOT EXISTS `PrivateSchool`.`courses` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(50) NOT NULL,
    `stream` VARCHAR(50) NOT NULL,
    `type` VARCHAR(50) NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`students` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `date_of_birth` DATE NOT NULL,
    `tuition_fees` INT NOT NULL
);
    
CREATE TABLE IF NOT EXISTS `PrivateSchool`.`trainers`(
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `subject` VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`assignments`(
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(50) NOT NULL,
    `description` VARCHAR(100) NOT NULL,
    `sub_date` DATE NOT NULL,
    `oral_mark` INT NOT NULL,
    `local_mark` INT NOT NULL
);

-- Create tables for N-N cardinalities 
CREATE TABLE IF NOT EXISTS `PrivateSchool`.`students_in_courses`(
    `students_id` INT NOT NULL,
    `courses_id` INT NOT NULL,
    PRIMARY KEY (`students_id`, `courses_id`),
    CONSTRAINT `fk_students_id__students_in_courses_students_id` 
		FOREIGN KEY(`students_id`) 
		REFERENCES `students`(`id`),
	CONSTRAINT `fk_courses_id__students_in_courses_courses_id` 
		FOREIGN KEY(`courses_id`) 
		REFERENCES `courses`(`id`)
);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`assignments_in_courses`(
    `assignments_id` INT NOT NULL,
    `courses_id` INT NOT NULL,
    PRIMARY KEY (`assignments_id`, `courses_id`),
    CONSTRAINT `fk_assignments_id__assignments_in_courses_assignments_id` 
		FOREIGN KEY(`assignments_id`) 
		REFERENCES `assignments`(`id`),
	CONSTRAINT `fk_assignments_id__assignments_in_courses_courses_id` 
		FOREIGN KEY(`courses_id`) 
		REFERENCES `courses`(`id`)
);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`trainers_in_courses`(
    `trainers_id` INT NOT NULL,
    `courses_id` INT NOT NULL,
    PRIMARY KEY (`trainers_id`, `courses_id`),
    CONSTRAINT `fk_trainers_id__trainers_in_courses_trainers_id` 
		FOREIGN KEY(`trainers_id`) 
		REFERENCES `trainers`(`id`),
	CONSTRAINT `fk_trainers_id__trainers_in_courses_courses_id` 
		FOREIGN KEY(`courses_id`) 
		REFERENCES `courses`(`id`)
);



-- Insert Data into tables

-- Students 
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("John", "Doe", "1988-02-03", "1850");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Ada", "Lovelace", "1983-01-23", "1500");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Jane", "Doe", "1983-06-19", "2000");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Markus", "Miller", "1993-08-25", "2000");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Mary", "Smith", "1975-08-01", "1500");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Sam", "Mendes", "1994-12-03", "0");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Ana", "Johnson", "1975-09-16", "2000");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("Maria", "Sanchez", "1986-11-23", "1850");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("George", "Stevenson", "1987-03-03", "1500");
INSERT INTO `PrivateSchool`.`students`(`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) 
VALUES("John", "Papadopoulos", "1988-05-03", "1500");

-- Courses
INSERT INTO `PrivateSchool`.`courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Mathematics", "Technology", "Lab", "2020-01-08", "2020-06-05");
INSERT INTO `PrivateSchool`.`courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Algorithms", "Technology", "Lab", "2020-04-03", "2020-06-05");
INSERT INTO `PrivateSchool`.`courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Art History", "Humanistics", "Seminar", "2020-05-10", "2020-06-15");
INSERT INTO `PrivateSchool`.`courses`(`title`, `stream`,`type`, `start_date`, `end_date`)
VALUES("Cooking", "Home economics", "Lab", "2020-05-01", "2020-05-15");

-- Trainers
INSERT INTO `PrivateSchool`.`trainers`(`first_name`, `last_name`,`subject`)
VALUES("Marianne","Uriol","Art");
INSERT INTO `PrivateSchool`.`trainers`(`first_name`, `last_name`,`subject`)
VALUES("Zoe","Kraft","Physics");
INSERT INTO `PrivateSchool`.`trainers`(`first_name`, `last_name`,`subject`)
VALUES("Helen","Moss","Computer Science");
INSERT INTO `PrivateSchool`.`trainers`(`first_name`, `last_name`,`subject`)
VALUES("John","Oliver","Science");
INSERT INTO `PrivateSchool`.`trainers`(`first_name`, `last_name`,`subject`)
VALUES("Martin","Nusli","House Economics");

-- Assignments
INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Linear Algebra","Individual assingment","2020-03-06","10","10");
INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Essay on El Greco","Bibliographic research","2020-12-12","5","5");
INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Binary Search algorithm","Implementation in Java","2020-04-08","10","10");
INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Basic recipes","Collect basic recipes","2020-05-15","5","5");
INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Buchberger's algorithm","Implementation in Java","2020-04-28","10","10");
INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Marc Chagall","Summary of life and work","2020-11-25","5","5");
INSERT INTO `PrivateSchool`.`assignments`(`title`, `description`, `sub_date`, `oral_mark`, `local_mark`)
VALUES("Linear Algebra","Individual assignment","2020-03-15","10","10");


-- Register students to courses
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("1", "1");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("3", "1");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("7", "1");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("1", "2");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("2", "2");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("4", "3");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("6", "3");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("5", "4");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("8", "4");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("7", "2");
INSERT INTO `PrivateSchool`.`students_in_courses`(`students_id`, `courses_id`)
VALUES ("2", "4");


-- Assign trainers to courses
INSERT INTO `PrivateSchool`.`trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("3","1");
INSERT INTO `PrivateSchool`.`trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("1","2");
INSERT INTO `PrivateSchool`.`trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("2","3");
INSERT INTO `PrivateSchool`.`trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("5","4");
INSERT INTO `PrivateSchool`.`trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("4","4");
INSERT INTO `PrivateSchool`.`trainers_in_courses`(`trainers_id`, `courses_id`)
VALUE("1","3");

-- Assign assignments to courses
INSERT INTO  `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("1","1");
INSERT INTO  `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("7","1");
INSERT INTO  `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("2","3");
INSERT INTO  `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("3","2");
INSERT INTO  `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("4","4");
INSERT INTO  `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("5","2");
INSERT INTO  `PrivateSchool`.`assignments_in_courses`(`assignments_id`, `courses_id`)
VALUES("6","3");


-- Read all data fom tables 
SELECT * FROM `PrivateSchool`.`students`;

SELECT * FROM `PrivateSchool`.`trainers`;

SELECT * FROM `PrivateSchool`.`assignments`;

SELECT * FROM `PrivateSchool`.`courses`;


-- Read all students per course (here: id = 1)
SELECT 
    *
FROM
    `PrivateSchool`.`students`
        JOIN
    `PrivateSchool`.`students_in_courses` ON `students_in_courses`.`students_id` = `PrivateSchool`.`students`.`id`
WHERE
    `PrivateSchool`.`students_in_courses`.`courses_id` = '1';


-- Read all trainers per course (here: id = 1)
SELECT 
    *
FROM
    `PrivateSchool`.`trainers`
        JOIN
    `PrivateSchool`.`trainers_in_courses` ON `trainers_in_courses`.`trainers_id` = `PrivateSchool`.`trainers`.`id`
WHERE
    `PrivateSchool`.`trainers_in_courses`.`courses_id` = '1';
 
 
--  Read all assignments per course(here: id = 1)
SELECT 
    *
FROM
    `PrivateSchool`.`assignments`
        JOIN
    `PrivateSchool`.`assignments_in_courses` ON `assignments_in_courses`.`assignments_id` = `PrivateSchool`.`assignments`.`id`
WHERE
    `PrivateSchool`.`assignments_in_courses`.`courses_id` = '1';


-- Read all studets that are registered to more than one course 
SELECT 
    *
FROM
    `PrivateSchool`.`students` AS S,
    (SELECT 
        `students_id`, COUNT(*) occurences
    FROM
        `PrivateSchool`.`students_in_courses`
    GROUP BY `students_id`
    HAVING COUNT(*) > 1) AS `T`
WHERE
    `T`.`students_id` = `S`.`id`;




-- Delete data from tables 
DELETE FROM `PrivateSchool`.`students_in_courses`;
DELETE FROM `PrivateSchool`.`assignments_in_courses`;
DELETE FROM `PrivateSchool`.`trainers_in_courses`;
DELETE FROM `PrivateSchool`.`students`;
DELETE FROM `PrivateSchool`.`trainers`;
DELETE FROM `PrivateSchool`.`assignments`;
DELETE FROM `PrivateSchool`.`courses`;
















-- Select students that have registered to a course with course ID 
SELECT 
    *
FROM
    `PrivateSchool`.`students` AS S,
    (SELECT 
        `students_id`
    FROM
        `PrivateSchool`.`students_in_courses`
    WHERE
        `students_in_courses`.`courses_id` = '1') AS `T`
WHERE
    `T`.`students_id` = `S`.`id`;
    
SELECT * FROM `PrivateSchool`.`students`
JOIN `PrivateSchool`.`students_in_courses` ON `PrivateSchool`.`students_in_courses`.`students_id` = `PrivateSchool`.`students`.`id`
WHERE `PrivateSchool`.`students_in_courses`.`courses_id` = '2';
    
-- assignemnts per student for course 1 and student 2
SELECT 
    `PrivateSchool`.`assignments`.`id`,
    `PrivateSchool`.`assignments`.`title`,
    `PrivateSchool`.`assignments`.`description`,
    `PrivateSchool`.`assignments`.`sub_date`,
    `PrivateSchool`.`assignments`.`oral_mark`,
    `PrivateSchool`.`assignments`.`local_mark`
FROM
    `PrivateSchool`.`assignments`
        JOIN
    `PrivateSchool`.`assignments_in_courses` ON `PrivateSchool`.`assignments_in_courses`.`assignments_id` = `PrivateSchool`.`assignments`.`id`
        JOIN
    `PrivateSchool`.`students_in_courses` ON `PrivateSchool`.`students_in_courses`.`courses_id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`
WHERE
    `PrivateSchool`.`assignments_in_courses`.`courses_id` = '2' and `PrivateSchool`.`students_in_courses`.`students_id` = '4';
 
