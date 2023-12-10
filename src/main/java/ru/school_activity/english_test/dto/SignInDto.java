package ru.school_activity.english_test.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SignInDto {

    private String username;
    private String password;



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
