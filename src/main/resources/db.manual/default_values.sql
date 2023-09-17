INSERT INTO users (id,
                   name,
                   email,
                   password)
    values (1,
            'vasy',
            'hello world',
            '854385');

INSERT INTO tests (id,
                   user_id,
                   name,
                   date,
                   question_total,
                   right_answers)
    values (1,
            1,
            'gala',
            '2004-10-19 10:23:54+02',
            150,
            20);

INSERT INTO test_questions (id, sentence) VALUES (1, 'Who are you?');
INSERT INTO answers (id, text, question_id) VALUES (1, 'come on', 1);
INSERT INTO wrong_answers (id, text, question_id) VALUES (1, 'run after', 1);

