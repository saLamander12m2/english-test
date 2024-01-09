package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.customException.UserExistException;
import ru.school_activity.english_test.dto.SignUpDto;
import ru.school_activity.english_test.entity.AppUser;
import ru.school_activity.english_test.repository.AppUserRepository;
import ru.school_activity.english_test.security.AppUserDetails;
import ru.school_activity.english_test.utils.Convert;

@RequiredArgsConstructor
@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUser findByEmail(String email) {
       return appUserRepository.findByEmail(email);
    }
    public void save(SignUpDto signUpDto) throws UserExistException {
        try {
            appUserRepository.save(Convert.makeAppUserFromSignUpDto(signUpDto));
        } catch (DataIntegrityViolationException e) {
            throw new UserExistException("User with this email already exists!");
        }
    }
}
