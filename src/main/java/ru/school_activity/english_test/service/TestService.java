package ru.school_activity.english_test.service;

import org.springframework.stereotype.Service;
import ru.school_activity.english_test.repository.TestRepository;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
}
