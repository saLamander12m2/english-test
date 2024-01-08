package ru.school_activity.english_test.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EndTestDto {

    private  int totalTestQuestionQuantity;
    private int rightAnswerQuantity;
    private List<String> testQuestionSentences = new ArrayList<>();
    private List<String> rightAnswers = new ArrayList<>();
    private List<String> usersAnswers = new ArrayList<>();


    @Override
    public String toString() {
        return "EndTestDto{" +
                "totalTestQuestionQuantity=" + totalTestQuestionQuantity +
                ", rightAnswerQuantity=" + rightAnswerQuantity +
                ", testQuestionSentences=" + testQuestionSentences +
                ", rightAnswers=" + rightAnswers +
                ", usersAnswers=" + usersAnswers +
                '}';
    }
}
