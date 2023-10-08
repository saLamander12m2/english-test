package ru.school_activity.english_test.service;

import org.springframework.stereotype.Service;
import ru.school_activity.english_test.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
