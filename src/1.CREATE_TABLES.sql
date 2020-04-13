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