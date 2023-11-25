package ru.school_activity.english_test.dto;

import lombok.Getter;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.entity.AppUser;

import java.util.List;

public class CurrentTestDto {

    @Getter
    private List<TestQuestion> testQuestions;

    private int rightAnswersQuantity;

    private int currentTestQuestions;

    private TopicVerb topicVerb;

    private StateCurrentTest state;
    private AppUser appUser;

    public CurrentTestDto(TopicVerb topicVerb) {
        this.rightAnswersQuantity = 0;
        this.currentTestQuestions = 0;
        this.topicVerb = topicVerb;
        this.state = StateCurrentTest.ONGOING;
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

    public boolean isEnd() {
        return state.equals(StateCurrentTest.END);
    }

    public void setStateEndIfNecessary() {
        if (testQuestions.size() - 1 == currentTestQuestions) {
            state = StateCurrentTest.END;
        }
    }

    public boolean isAnswerRight(Answer answer) {
        return answer.getText().equals(testQuestions.get(currentTestQuestions).getAnswer().getText());
    }

    public void incrementRightAnswerCounter(){
        rightAnswersQuantity++;
    }


    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public TopicVerb getTopicVerb() {
        return topicVerb;
    }
}
