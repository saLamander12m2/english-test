package ru.school_activity.english_test.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class HistoryDto {

    private String date;
    private String topicVerb;
    private int questionTotal;
    private int rightAnswersQuantity;

}
