USE `PrivateSchool`;

-- Read all data fom tables 
SELECT * FROM `students`;
SELECT * FROM `trainers`;
SELECT * FROM `assignments`;
SELECT * FROM `courses`;


-- Read all students per course (here: id = 1)
SELECT 
    *
FROM
    `students`
        JOIN
    `students_in_courses` ON `students_in_courses`.`students_id` = `students`.`id`
WHERE
    `students_in_courses`.`courses_id` = '1';


-- Read all trainers per course (here: id = 1)
SELECT 
    *
FROM
    `trainers`
        JOIN
    `trainers_in_courses` ON `trainers_in_courses`.`trainers_id` = `trainers`.`id`
WHERE
    `trainers_in_courses`.`courses_id` = '1';
 
 
--  Read all assignments per course(here: id = 1)
SELECT 
    *
FROM
    `assignments`
        JOIN
    `assignments_in_courses` ON `assignments_in_courses`.`assignments_id` = `assignments`.`id`
WHERE
    `assignments_in_courses`.`courses_id` = '1';



-- Read all studets that are registered to more than one courses
SELECT 
    *
FROM
    `students` AS S,
    (SELECT 
        `students_id`, COUNT(*) occurences
    FROM
        `students_in_courses`
    GROUP BY `students_id`
    HAVING COUNT(*) > 1) AS `T`
WHERE
    `T`.`students_id` = `S`.`id`;



-- Read all the assignments per course per student (here: course:2, student:1)
SELECT 
*
FROM
    `assignments`
        JOIN
    `assignments_in_courses` ON `assignments_in_courses`.`assignments_id` = `assignments`.`id`
        JOIN
    `students_in_courses` ON `students_in_courses`.`courses_id` = `assignments_in_courses`.`courses_id`
WHERE
    `assignments_in_courses`.`courses_id` = '2' and `students_in_courses`.`students_id` = '1';
    
    
-- read occurence of assignment with assignment id and course id (here 1)
SELECT 
    COUNT(1)
FROM
    `assignments_in_courses`
WHERE
    `assignments_in_courses`.`assignments_id` = '1'
AND `assignments_in_courses`.`courses_id` = '1';

