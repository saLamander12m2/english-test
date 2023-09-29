CREATE TABLE if not exists users (
    id int              PRIMARY KEY,
    name varchar,
    email varchar UNIQUE NOT NULL ,
    password varchar NOT NULL,
    test_id int NOT NULL,
    FOREIGN KEY (test_id) REFERENCES tests(id)
);

CREATE TABLE if not exists topic_verbs (
    id int            PRIMARY KEY,
    verb varchar NOT NULL,
    test_id int NOT NULL,
    test_questions_id int NOT NULL,
    FOREIGN KEY (test_id) REFERENCES tests(id),
    FOREIGN KEY (test_questions_id) REFERENCES test_questions(id)
);

CREATE TABLE if not exists test_questions (
    id int              PRIMARY KEY,
    sentence varchar NOT NULL,
    answer_id int,
    wrong_answer_id int NOT NULL,
    topic_verb_id int NOT NULL,
    FOREIGN KEY (answer_id) REFERENCES answers(id),
    FOREIGN KEY (wrong_answer_id) REFERENCES wrong_answers(id),
    FOREIGN KEY (topic_verb_id) REFERENCES topic_verbs(id)
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
    test_id int,
    FOREIGN KEY (test_id)
        REFERENCES test_questions(id)

);

CREATE TABLE if not exists tests (
    id int             PRIMARY KEY,
    user_id int,
    name varchar,
    date timestamp NOT NULL,
    question_total int NOT NULL,
    right_answers int NOT NULL,
    verbs_id int,
    FOREIGN KEY (verbs_id)
        REFERENCES topic_verbs(id),
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);

CREATE INDEX topic_verbs_idx ON topic_verbs(verb);
