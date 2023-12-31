package ru.school_activity.english_test.customException;

public class UserExistException extends Exception {
    public UserExistException(String message) {
        super(message);
    }
}
