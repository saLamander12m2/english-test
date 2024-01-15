package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.customException.UserExistException;
import ru.school_activity.english_test.dto.SignUpDto;
import ru.school_activity.english_test.entity.AppUser;
import ru.school_activity.english_test.repository.AppUserRepository;

@RequiredArgsConstructor
@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConvertService convertService;

    public AppUser findByEmail(String email) {
       return appUserRepository.findByEmail(email);
    }
    public void save(SignUpDto signUpDto) throws UserExistException {
        signUpDto.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        try {
            appUserRepository.save(convertService.doFromSignUpDtoToAppUser(signUpDto));
        } catch (DataIntegrityViolationException e) {
            throw new UserExistException("User with this email already exists!");
        }
    }
}
