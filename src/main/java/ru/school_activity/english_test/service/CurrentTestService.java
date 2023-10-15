package ru.school_activity.english_test.service;

import ru.school_activity.english_test.dto.CurrentTestDto;
import ru.school_activity.english_test.entity.TopicVerb;

public class CurrentTestService {

    public void  createCurrentTest(TopicVerb topicVerb) {
        CurrentTestDto currentTestDto = new CurrentTestDto(topicVerb);

    }
}
