package ru.school_activity.english_test.dto;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CurrentTestQuestionsDto {

    private int testQuestionTotal;
    private int currentTestQuestion;
    private String testQuestion;
    private List<String> answers;

    @Override
    public String toString() {
        return "CurrentTestQuestionsDto{" +
                "testQuestionTotal=" + testQuestionTotal +
                ", currentTestQuestion=" + currentTestQuestion +
                ", testQuestion='" + testQuestion + '\'' +
                ", answer='" + answers + '\'' +
                '}';
    }
}
