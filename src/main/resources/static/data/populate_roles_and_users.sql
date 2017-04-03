INSERT INTO `my_prezi_test`.`roles`
(`role_ID`,
`name`)
VALUES
(1,
'admin');

INSERT INTO `my_prezi_test`.`roles`
(`role_ID`,
`name`)
VALUES
(2,
'viewer');

INSERT INTO `my_prezi_test`.`users`
(`user_ID`,
`role_ID`,
`first_name`,
`last_name`,
`user_name`,
`email`,
`password`)
VALUES
(1,
1,
'Iuliana',
'Danea',
'Iulia',
'danea.iuliana@gmail.com',
'parola');

INSERT INTO `my_prezi_test`.`users`
(`user_ID`,
`role_ID`,
`first_name`,
`last_name`,
`user_name`,
`email`,
`password`)
VALUES
(2,
2,
'Alexandru',
'Lesanu',
'Alex',
'lesanu.alexandru@gmail.com',
'parola');
