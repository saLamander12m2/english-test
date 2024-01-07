package ru.school_activity.english_test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.entity.AppUser;

import java.util.List;

@NoArgsConstructor
public class CurrentTestDto {

    @Getter
    private List<TestQuestion> testQuestions;

    private int rightAnswersQuantity;

    private int currentTestQuestion;

    private TopicVerb topicVerb;

    private StateCurrentTest state;
    private AppUser appUser;

    public CurrentTestDto(TopicVerb topicVerb) {
        this.rightAnswersQuantity = 0;
        this.currentTestQuestion = 0;
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

    public int getCurrentTestQuestion() {
        return currentTestQuestion;
    }

    public void setCurrentTestQuestion(int currentTestQuestion) {
        this.currentTestQuestion = currentTestQuestion;
    }

    public boolean isEnd() {
        return state.equals(StateCurrentTest.END);
    }

    public void setStateEndIfNecessary() {
        if (testQuestions.size() - 1 == currentTestQuestion) {
            state = StateCurrentTest.END;
        }
    }

    public boolean isAnswerRight(String answer) {
        return answer.toLowerCase()
                .equals(testQuestions
                        .get(currentTestQuestion)
                        .getAnswer()
                        .getText()
                );
    }

    public void incrementRightAnswerCounter() {
        rightAnswersQuantity++;
    }

    public void incrementCurrentTestQuestion() {
        currentTestQuestion++;
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

    @Override
    public String toString() {
        return "CurrentTestDto{" +
                "testQuestions=" + testQuestions +
                ", rightAnswersQuantity=" + rightAnswersQuantity +
                ", currentTestQuestion=" + currentTestQuestion +
                ", topicVerb=" + topicVerb +
                ", state=" + state +
                ", appUser=" + appUser +
                '}';
    }
}
