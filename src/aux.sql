       
        
-- Read courses with registered assignments


-- Select students that have registered to a course with course ID REFACTOR
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



