package ru.school_activity.english_test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.repository.TestQuestionRepository;

@Service
class TestQuestionService {
    private TestQuestionRepository testQuestionRepository;

    @Autowired
    public TestQuestionService(TestQuestionRepository testQuestionRepository) {
        this.testQuestionRepository = testQuestionRepository;
    }
}
