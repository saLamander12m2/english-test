package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.repository.TestRepository;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
}
