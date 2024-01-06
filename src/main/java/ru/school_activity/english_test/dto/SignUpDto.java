package ru.school_activity.english_test.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class SignUpDto {

    private String username;
    private String password;
    private String email;
}
