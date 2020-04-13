-- read courses with registered students
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

-- read students of course with course id (here 1)
SELECT 
    *
FROM
    `PrivateSchool`.`students`
        JOIN
    `PrivateSchool`.`students_in_courses` ON `PrivateSchool`.`students`.`id` = `PrivateSchool`.`students_in_courses`.`students_id`
        JOIN
    `PrivateSchool`.`courses` ON `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`students_in_courses`.`courses_id`
WHERE
    `PrivateSchool`.`courses`.`id` = '1';