-- Read assignment with ID (here id = 1)
SELECT 
    *
FROM
    `PrivateSchool`.`assignments`
WHERE
    `id` = '1';


-- Read assignment with title and submission date

SELECT 
    *
FROM
    `PrivateSchool`.`assignments`
WHERE
    `title` = 'Linear Algebra'
        AND `sub_date` = '2020-03-06';


-- read courses with registered assignment
SELECT DISTINCT
    (`courses`.`id`),
    `courses`.`title`,
    `courses`.`stream`,
    `courses`.`type`,
    `courses`.`start_date`,
    `courses`.`end_date`
FROM
    `PrivateSchool`.`courses`,
    `PrivateSchool`.`assignments_in_courses`
WHERE
    `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`;
    
-- read assignments Of course with courseID (here courseId:1)
SELECT 
    *
FROM
    `PrivateSchool`.`assignments`
        JOIN
    `PrivateSchool`.`assignments_in_courses` ON `PrivateSchool`.`assignments_in_courses`.`assignments_id` = `PrivateSchool`.`assignments`.`id`
        JOIN
    `PrivateSchool`.`courses` ON `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`assignments_in_courses`.`courses_id`
WHERE
    `PrivateSchool`.`courses`.`id` = '1';
        