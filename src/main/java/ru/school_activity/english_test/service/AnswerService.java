package ru.school_activity.english_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.repository.AnswerRepository;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void save (Answer answer) {
        // какая-то бизнес логика
        answerRepository.save(answer);
    }
}
