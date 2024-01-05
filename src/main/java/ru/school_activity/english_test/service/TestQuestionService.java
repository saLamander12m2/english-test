package ru.school_activity.english_test.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.repository.TestQuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
class TestQuestionService {

    private final TestQuestionRepository testQuestionRepository;

}
