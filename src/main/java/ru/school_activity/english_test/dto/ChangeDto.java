package ru.school_activity.english_test.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.entity.WrongAnswer;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ChangeDto {

    private Answer answer;
    private List<WrongAnswer> wrongAnswers;
    private List<TestQuestion> testQuestions;
    private TopicVerb topicVerb;
    private Double testQuestionsId;

    @Override
    public String toString() {
        return "ChangeDto{" +
                "answer=" + answer +
                ", wrongAnswers=" + wrongAnswers +
                ", testQuestions=" + testQuestions +
                ", topicVerb=" + topicVerb +
                '}';
    }
}
