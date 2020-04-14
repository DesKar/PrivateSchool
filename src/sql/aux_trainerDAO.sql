-- select trainers of course with course id (here 1)

SELECT 
    *
FROM
    `PrivateSchool`.`trainers`
        JOIN
    `PrivateSchool`.`trainers_in_courses` ON `PrivateSchool`.`trainers`.`id` = `PrivateSchool`.`trainers_in_courses`.`trainers_id`
        JOIN
    `PrivateSchool`.`courses` ON `PrivateSchool`.`courses`.`id` = `PrivateSchool`.`trainers_in_courses`.`courses_id`
WHERE
    `PrivateSchool`.`courses`.`id` = '1';