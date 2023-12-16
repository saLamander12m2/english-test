package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.dto.SignUpDto;
import ru.school_activity.english_test.repository.AppUserRepository;
import ru.school_activity.english_test.utils.Convert;

@RequiredArgsConstructor
@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public void save(SignUpDto signUpDto) {
        try {
            appUserRepository.save(Convert.makeAppUserFromSignUpDto(signUpDto));
        } catch (DataIntegrityViolationException e) {
            System.out.println("Это дубликат");
        }
    }
}
