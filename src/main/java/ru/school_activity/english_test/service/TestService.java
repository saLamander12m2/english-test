package ru.school_activity.english_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private TestService testService;

    @Autowired
    public TestService(TestService testService) {
        this.testService = testService;
    }
}
