package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.repository.AnswerRepository;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer save (Answer answer) {
        return answerRepository.save(answer);
    }
}
