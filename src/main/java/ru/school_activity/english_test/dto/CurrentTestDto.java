package ru.school_activity.english_test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.entity.AppUser;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CurrentTestDto {

    private List<TestQuestion> testQuestions;
    private int rightAnswersQuantity;
    private int currentTestQuestion;
    private List<String> usersAnswers = new ArrayList<>();
    private TopicVerb topicVerb;
    private StateCurrentTest state;
    private AppUser appUser;

    public CurrentTestDto(TopicVerb topicVerb) {
        this.rightAnswersQuantity = 0;
        this.currentTestQuestion = 0;
        this.topicVerb = topicVerb;
        this.state = StateCurrentTest.ONGOING;
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
