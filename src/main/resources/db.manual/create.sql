CREATE TABLE if not exists users (
    id int              PRIMARY KEY,
    name varchar,
    email varchar UNIQUE NOT NULL ,
    password varchar NOT NULL
);

CREATE TABLE if not exists verbs (
                                     id int            PRIMARY KEY,
                                     verbs varchar UNIQUE NOT NULL
);

CREATE TABLE if not exists test_questions (
    id int              PRIMARY KEY,
    sentence varchar NOT NULL,
--     verbs_id int CONSTRAINT test_questions_verbs_id,
    verbs_id int,
    FOREIGN KEY (verbs_id) REFERENCES verbs(id)
);

CREATE TABLE if not exists answers (
    id int              PRIMARY KEY,
    text varchar NOT NULL,
    question_id int,
    FOREIGN KEY (question_id)
        REFERENCES test_questions(id)
);

CREATE TABLE if not exists wrong_answers (
    id int              PRIMARY KEY,
    text varchar NOT NULL,
    question_id int,
    FOREIGN KEY (question_id)
        REFERENCES test_questions (id)
);

CREATE TABLE if not exists tests (
    id int              PRIMARY KEY,
    user_id int,
    name varchar,
    date timestamp NOT NULL,
    question_total int NOT NULL,
    right_answers int NOT NULL,
    verbs_id int,
    FOREIGN KEY (verbs_id)
        REFERENCES verbs(id),
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);

CREATE INDEX verbs_id ON test_questions (verbs_id);
