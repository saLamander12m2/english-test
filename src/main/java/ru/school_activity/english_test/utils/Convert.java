package ru.school_activity.english_test.utils;

import ru.school_activity.english_test.dto.SignUpDto;
import ru.school_activity.english_test.entity.AppUser;

public class Convert {

    public static AppUser makeAppUserFromSignUpDto(SignUpDto signUpDto) {
        return AppUser.builder()
                .username(signUpDto.getUsername())
                .password(signUpDto.getPassword())
                .email(signUpDto.getEmail())
                .build();
    }
}
