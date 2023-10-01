package ru.school_activity.english_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserService userService;

    @Autowired
    public UserService(UserService userService) {
        this.userService = userService;
    }
}
