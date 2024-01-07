CREATE TABLE if not exists users (
    id SERIAL              PRIMARY KEY,
    name varchar,
    email varchar UNIQUE NOT NULL ,
    password varchar NOT NULL
);

CREATE TABLE if not exists topic_verbs (
    id SERIAL        PRIMARY KEY,
    verb varchar NOT NULL UNIQUE
);

CREATE TABLE if not exists test_questions (
    id SERIAL              PRIMARY KEY,
    sentence varchar NOT NULL UNIQUE,
    topic_verb_id int NOT NULL
);

CREATE TABLE if not exists answers (
    id SERIAL              PRIMARY KEY,
    text varchar NOT NULL,
    test_question_id int
);

CREATE TABLE if not exists wrong_answers (
    id SERIAL              PRIMARY KEY,
    text varchar NOT NULL,
    test_questions_id int NOT NULL
);

CREATE TABLE if not exists tests (
    id SERIAL            PRIMARY KEY,
    name varchar,
    date bigint NOT NULL,
    question_total int NOT NULL,
    right_answers int NOT NULL,
    topic_verb_id int NOT NULL,
    user_id int NOT NULL
);

CREATE INDEX topic_verbs_idx ON topic_verbs(verb);

ALTER TABLE test_questions ADD CONSTRAINT fk_test_questions_topic_verbs FOREIGN KEY (topic_verb_id) REFERENCES topic_verbs(id);

ALTER TABLE answers ADD CONSTRAINT fk_answers_test_questions FOREIGN KEY (test_question_id) REFERENCES test_questions(id);

ALTER TABLE wrong_answers ADD CONSTRAINT fk_wrong_answers_tests FOREIGN KEY (test_questions_id) REFERENCES test_questions(id);

ALTER TABLE tests ADD CONSTRAINT fk_tests_topic_verbs FOREIGN KEY (topic_verb_id) REFERENCES topic_verbs(id);
ALTER TABLE tests ADD CONSTRAINT fk_tests_users FOREIGN KEY (user_id) REFERENCES users(id);

