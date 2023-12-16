package ru.school_activity.english_test.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SignUpDto {

    private String username;
    private String password;

    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
