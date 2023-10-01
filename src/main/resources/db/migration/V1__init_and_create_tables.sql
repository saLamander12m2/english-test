CREATE TABLE if not exists users (
    id int              PRIMARY KEY,
    name varchar,
    email varchar UNIQUE NOT NULL ,
    password varchar NOT NULL,
    test_id int
);

CREATE TABLE if not exists topic_verbs (
    id int            PRIMARY KEY,
    verb varchar NOT NULL,
    test_id int,
    test_questions_id int
);

CREATE TABLE if not exists test_questions (
    id int              PRIMARY KEY,
    sentence varchar NOT NULL,
    answer_id int,
    wrong_answer_id int,
    topic_verb_id int NOT NULL
);

CREATE TABLE if not exists answers (
    id int              PRIMARY KEY,
    text varchar NOT NULL,
    test_question_id int
);

CREATE TABLE if not exists wrong_answers (
    id int              PRIMARY KEY,
    text varchar NOT NULL,
    test_questions_id int NOT NULL
);

CREATE TABLE if not exists tests (
    id int             PRIMARY KEY,
    name varchar,
    date timestamp NOT NULL,
    question_total int NOT NULL,
    right_answers int NOT NULL,
    topic_verb_id int NOT NULL,
    user_id int NOT NULL
);

CREATE INDEX topic_verbs_idx ON topic_verbs(verb);

ALTER TABLE users ADD CONSTRAINT fk_users_tests FOREIGN KEY (test_id) REFERENCES tests(id);

ALTER TABLE topic_verbs ADD  CONSTRAINT fk_topic_verbs_tests FOREIGN KEY (test_id) REFERENCES tests(id);
ALTER TABLE topic_verbs ADD  CONSTRAINT fk_topic_verbs_test_questions FOREIGN KEY (test_questions_id) REFERENCES test_questions(id);

ALTER TABLE test_questions ADD CONSTRAINT fk_test_questions_answers FOREIGN KEY (answer_id) REFERENCES answers(id);
ALTER TABLE test_questions ADD CONSTRAINT fk_test_questions_wrong_answers FOREIGN KEY (wrong_answer_id) REFERENCES wrong_answers(id);
ALTER TABLE test_questions ADD CONSTRAINT fk_test_questions_topic_verbs FOREIGN KEY (topic_verb_id) REFERENCES topic_verbs(id);

ALTER TABLE answers ADD CONSTRAINT fk_answers_test_questions FOREIGN KEY (test_question_id) REFERENCES test_questions(id);

ALTER TABLE wrong_answers ADD CONSTRAINT fk_wrong_answers_tests FOREIGN KEY (test_questions_id) REFERENCES test_questions(id);

ALTER TABLE tests ADD CONSTRAINT fk_tests_topic_verbs FOREIGN KEY (topic_verb_id) REFERENCES topic_verbs(id);
ALTER TABLE tests ADD CONSTRAINT fk_tests_users FOREIGN KEY (user_id) REFERENCES users(id);

