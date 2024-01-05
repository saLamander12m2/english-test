package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.WrongAnswer;
import ru.school_activity.english_test.repository.WrongAnswerRepository;

@Service
@RequiredArgsConstructor
public class WrongAnswerService {

    private final WrongAnswerRepository wrongAnswerRepository;

    public WrongAnswer save(WrongAnswer wrongAnswer){
        return wrongAnswerRepository.save(wrongAnswer);
    }
}
