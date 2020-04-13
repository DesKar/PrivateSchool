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



-- Read all studets that are registered to more than one courses
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



-- Read all the assignments per course per student (here: course:2, student:1)
SELECT 
*
FROM
    `PrivateSchool`.`assignments`
        JOIN
    `PrivateSchool`.`assignments_in_courses` ON `PrivateSchool`.`assignments_in_courses`.`assignments_id` = `PrivateSchool`.`assignments`.`id`
        JOIN
    `PrivateSchool`.`students_in_courses` ON `PrivateSchool`.`students_in_courses`.`courses_id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`
WHERE
    `PrivateSchool`.`assignments_in_courses`.`courses_id` = '2' and `PrivateSchool`.`students_in_courses`.`students_id` = '1';
    
    
-- read occurence of assignment with assignment id and course id (here 1)
SELECT 
    COUNT(1)
FROM
    `PrivateSchool`.`assignments_in_courses`
WHERE
    `PrivateSchool`.`assignments_in_courses`.`assignments_id` = '1'
AND `PrivateSchool`.`assignments_in_courses`.`courses_id` = '1';

