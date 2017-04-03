CREATE TABLE roles (
    role_ID int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (role_ID)
);
CREATE TABLE users (
    user_ID int NOT NULL AUTO_INCREMENT,
    role_ID int NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    user_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    PRIMARY KEY (user_ID),
    FOREIGN KEY (role_ID) REFERENCES roles(role_ID)
);

CREATE TABLE presentations (
    presentation_ID int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
	user_ID int NOT NULL,
    creation_date datetime NOT NULL,
    PRIMARY KEY (presentation_ID),
	FOREIGN KEY (user_ID) REFERENCES users(user_ID)
);
CREATE TABLE slides (
    slide_ID int NOT NULL  AUTO_INCREMENT,
    presentation_ID int NOT NULL,
    name varchar(255) NOT NULL,
    position int NOT NULL,
    PRIMARY KEY (slide_ID),
    FOREIGN KEY (presentation_ID) REFERENCES presentations(presentation_ID)
);
CREATE TABLE contents (
    content_ID int NOT NULL  AUTO_INCREMENT,
    slide_ID int NOT NULL,
    position int NOT NULL,
    url varchar(2000),
    text varchar(2000),
    PRIMARY KEY (content_ID),
    FOREIGN KEY (slide_ID) REFERENCES slides(slide_ID)
);
CREATE TABLE backgrounds (
    background_ID int NOT NULL  AUTO_INCREMENT,
    slide_ID int NOT NULL,
    url varchar(2000),
    PRIMARY KEY (background_ID),
    FOREIGN KEY (slide_ID) REFERENCES slides(slide_ID)
);