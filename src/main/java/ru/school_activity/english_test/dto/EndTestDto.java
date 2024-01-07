package ru.school_activity.english_test.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EndTestDto {

    private  int totalTestQuestionQuantity;
    private int RightAnswerQuantity;

    @Override
    public String toString() {
        return "EndTestDto{" +
                "totalTestQuestionQuantity=" + totalTestQuestionQuantity +
                ", RightAnswerQuantity=" + RightAnswerQuantity +
                '}';
    }
}
