package ru.school_activity.english_test.service;

import ru.school_activity.english_test.dto.CurrentTestDto;
import ru.school_activity.english_test.entity.Test;

public class ConvertService {
    public static Test doFromCurrentTestDtoToTest(CurrentTestDto currentTestDto) {
        return Test.builder()
                .questionTotal(currentTestDto.getTestQuestions().size())
                .rightAnswers(currentTestDto.getRightAnswersQuantity())
                .appUser(currentTestDto.getAppUser())
                .topicVerb(currentTestDto.getTopicVerb())
                .build();
    }
}
