package ru.school_activity.english_test.dto;

import lombok.Getter;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;

import java.util.List;

public class CurrentTestDto {

    @Getter
    private List<TestQuestion> testQuestions;

    private int rightAnswersQuantity;

    private int currentTestQuestions;

    private TopicVerb topicVerb;

    public CurrentTestDto(TopicVerb topicVerb) {
        this.rightAnswersQuantity = 0;
        this.currentTestQuestions = 0;
        this.topicVerb = topicVerb;
    }


    public void setTestQuestions(List<TestQuestion> testQuestions) {
        this.testQuestions = testQuestions;
    }

    public int getRightAnswersQuantity() {
        return rightAnswersQuantity;
    }

    public void setRightAnswersQuantity(int rightAnswersQuantity) {
        this.rightAnswersQuantity = rightAnswersQuantity;
    }

    public int getCurrentTestQuestions() {
        return currentTestQuestions;
    }

    public void setCurrentTestQuestions(int currentTestQuestions) {
        this.currentTestQuestions = currentTestQuestions;
    }

}
