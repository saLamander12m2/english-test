package ru.school_activity.english_test.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.repository.TestQuestionRepository;

@Service
@RequiredArgsConstructor
public class TestQuestionService {

    private final TestQuestionRepository testQuestionRepository;

    public TestQuestion save(TestQuestion testQuestion){
        return testQuestionRepository.save(testQuestion);
    }
}
