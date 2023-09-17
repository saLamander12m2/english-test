CREATE TABLE if not exists users (
    id int PRIMARY KEY,
    name varchar,
    email varchar,
    password varchar
);

CREATE TABLE if not exists test_questions (
    id int PRIMARY KEY,
    sentence varchar
);

CREATE TABLE if not exists answers (
    id int PRIMARY KEY,
    text varchar,
    question_id int PRIMARY KEY,
    FOREIGN KEY (question_id)
        REFERENCES test_questions(id)
);

CREATE TABLE if not exists wrong_answers (
    id int PRIMARY KEY,
    text varchar,
    question_id int PRIMARY KEY,
    FOREIGN KEY (question_id)
        REFERENCES test_questions (id)
);

CREATE TABLE if not exists tests (
    id int PRIMARY KEY,
    user_id int PRIMARY KEY,
    name varchar,
    date timestamp,
    question_total int,
    right_answers int,
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);

INSERT INTO tests(question_total) values (50);