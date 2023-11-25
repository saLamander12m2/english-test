package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.repository.AppUserRepository;

@RequiredArgsConstructor
@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
}
