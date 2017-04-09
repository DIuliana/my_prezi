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
'viwer');

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
(3,
1,
'Bogdan',
'Popescu',
'Bogdan',
'popescu.bogdan@gmail.com',
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

INSERT INTO `my_prezi_test`.`presentations`
(`presentation_ID`,
`name`,
`user_ID`,
`creation_date`)
VALUES
(1,
'test prez',
2,
CURRENT_TIMESTAMP);


INSERT INTO `my_prezi_test`.`presentations`
(`presentation_ID`,
`name`,
`user_ID`,
`creation_date`)
VALUES
(2,
'test prez 2',
2,
CURRENT_TIMESTAMP);

INSERT INTO `my_prezi_test`.`slides`
(`slide_ID`,
`presentation_ID`,
`name`,
`position`)
VALUES
(1,
2,
'introduction',
1);
INSERT INTO `my_prezi_test`.`slides`
(`slide_ID`,
`presentation_ID`,
`name`,
`position`)
VALUES
(2,
2,
'slide2',
2);

