package ru.school_activity.english_test.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CurrentAnswerDto {
    private int numberCurrentTestQuestion;
    private String answer;

    @Override
    public String toString() {
        return "CurrentAnswerDto{" +
                "numberCurrentTestQuestion=" + numberCurrentTestQuestion +
                ", answer='" + answer + '\'' +
                '}';
    }
}
