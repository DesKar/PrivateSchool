CREATE SCHEMA IF NOT EXISTS `PrivateSchool`;
USE `PrivateSchool`;

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`courses` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(30) NOT NULL,
    `stream` VARCHAR(30) NOT NULL,
    `type` VARCHAR(30) NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`students` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(15) NOT NULL,
    `last_name` VARCHAR(15) NOT NULL,
    `date_of_birth` DATE NOT NULL,
    `tuition_fees` INT NOT NULL
);
    
CREATE TABLE IF NOT EXISTS `PrivateSchool`.`trainers` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(15) NOT NULL,
    `last_name` VARCHAR(15) NOT NULL,
    `subject` VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`assignments` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(30) NOT NULL,
    `description` VARCHAR(100) NOT NULL,
    `sub_date` DATE NOT NULL,
    `oral_mark` INT NOT NULL,
    `local_mark` INT NOT NULL
);

CREATE TABLE IF NOT EXISTS `students_in_courses` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `students_id` INT NOT NULL,
    `courses_id` INT NOT NULL,
    CONSTRAINT `fk_students_id__students_in_courses_students_id` FOREIGN KEY (`students_id`)
        REFERENCES `students` (`id`),
    CONSTRAINT `fk_courses_id__students_in_courses_courses_id` FOREIGN KEY (`courses_id`)
        REFERENCES `courses` (`id`)
);

CREATE TABLE IF NOT EXISTS `trainers_in_courses` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `trainers_id` INT NOT NULL,
    `courses_id` INT NOT NULL,
    CONSTRAINT `fk_trainers_id__trainers_in_courses_trainers_id` FOREIGN KEY (`trainers_id`)
        REFERENCES `trainers` (`id`),
    CONSTRAINT `fk_courses_id__trainers_in_courses_courses_id` FOREIGN KEY (`courses_id`)
        REFERENCES `courses` (`id`)
);

CREATE TABLE IF NOT EXISTS `assignments_in_courses` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `assignments_id` INT NOT NULL,
    `courses_id` INT NOT NULL,
    CONSTRAINT `fk_assignments_id__assignments_in_courses_assignments_id` FOREIGN KEY (`assignments_id`)
        REFERENCES `assignments` (`id`),
    CONSTRAINT `fk_courses_id__assignments_in_courses_courses_id` FOREIGN KEY (`courses_id`)
        REFERENCES `courses` (`id`)
);

SELECT 
    *
FROM
    `PrivateSchool`.`courses`;

SELECT 
    *
FROM
    `PrivateSchool`.`students`;

SELECT 
    *
FROM
    `PrivateSchool`.`trainers`;

SELECT 
    *
FROM
    `PrivateSchool`.`assignments`;

SELECT 
    *
FROM
    `PrivateSchool`.`students_in_courses`;

SELECT 
    `id`
FROM
    `PrivateSchool`.`courses`;

SELECT DISTINCT
    (`courses`.`id`),
    `courses`.`title`,
    `courses`.`stream`,
    `courses`.`type`,
    `courses`.`start_date`,
    `courses`.`end_date`
FROM
    `PrivateSchool`.`courses`,
    `PrivateSchool`.`students_in_courses`
WHERE
    `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`students_in_courses`.`courses_id`;


SELECT 
    `students`.`id`,
    `students`.`first_name`,
    `students`.`last_name`,
    `students`.`date_of_birth`,
    `students`.`tuition_fees`
FROM
    `PrivateSchool`.`students`,
    `PrivateSchool`.`courses`,
    `PrivateSchool`.`students_in_courses`
WHERE
    `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`students_in_courses`.`courses_id`
        AND `PrivateSchool`.`students`.`id` = `PrivateSchool`.`students_in_courses`.`students_id`
        AND `PrivateSchool`.`courses`.`id` = '2';

-- student exists in course 
SELECT * FROM `PrivateSchool`.`students_in_courses`
WHERE `PrivateSchool`.`students_in_courses`.`students_id` = "1" and `PrivateSchool`.`students_in_courses`.`courses_id` = "2";




