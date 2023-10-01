package ru.school_activity.english_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.repository.WrongAnswerRepository;

@Service
public class WrongAnswerService {
    private WrongAnswerRepository wrongAnswerRepository;

    @Autowired
    public WrongAnswerService(WrongAnswerRepository wrongAnswerRepository) {
        this.wrongAnswerRepository = wrongAnswerRepository;
    }
}
