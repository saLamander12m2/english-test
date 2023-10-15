package ru.school_activity.english_test.dto;

import org.springframework.beans.factory.annotation.Value;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;

import java.util.List;

public class CurrentTestDto {
    private List<TestQuestion> testQuestions;

    @Value("${app.testQuestionsQuantity}")
    private int testQuestionsQuantity;

    private int rightAnswersQuantity = 0;

    private int currentTestQuestions = 0;

    private TopicVerb topicVerb;

    public CurrentTestDto(TopicVerb topicVerb) {
        this.topicVerb = topicVerb;
    }


    public List<TestQuestion> getTestQuestions() {
        return testQuestions;
    }

    public void setTestQuestions(List<TestQuestion> testQuestions) {
        this.testQuestions = testQuestions;
    }

    public int getTestQuestionsQuantity() {
        return testQuestionsQuantity;
    }

    public void setTestQuestionsQuantity(int testQuestionsQuantity) {
        this.testQuestionsQuantity = testQuestionsQuantity;
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

    public TopicVerb getTopicVerb() {
        return topicVerb;
    }

    public void setTopicVerb(TopicVerb topicVerb) {
        this.topicVerb = topicVerb;
    }
}
