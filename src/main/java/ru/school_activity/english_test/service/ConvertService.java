package ru.school_activity.english_test.service;

import ru.school_activity.english_test.dto.CurrentTestDto;
import ru.school_activity.english_test.dto.CurrentTestQuestionsDto;
import ru.school_activity.english_test.entity.Test;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.WrongAnswer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertService {
    public static Test doFromCurrentTestDtoToTest(CurrentTestDto currentTestDto) {
        return Test.builder()
                .questionTotal(currentTestDto.getTestQuestions().size())
                .rightAnswers(currentTestDto.getRightAnswersQuantity())
                .appUser(currentTestDto.getAppUser())
                .topicVerb(currentTestDto.getTopicVerb())
                .build();
    }

    public static CurrentTestQuestionsDto doFromCurrentTestDtoToCurrentTestQuestionsDto(CurrentTestDto currentTestDto){
        TestQuestion testQuestion = currentTestDto.getTestQuestions().get(currentTestDto.getCurrentTestQuestion());
        List<String> answers = new ArrayList<>();
        answers.add(testQuestion.getAnswer().getText());

        for (WrongAnswer item: testQuestion.getWrongAnswers()) {
            answers.add(item.getText());
        }
        Collections.shuffle(answers);

        return CurrentTestQuestionsDto.builder()
                .currentTestQuestion(currentTestDto.getCurrentTestQuestion())
                .testQuestion(testQuestion.getSentence())
                .testQuestionTotal(currentTestDto.getTestQuestions().size())
                .answers(answers)
                .build();
    }
}
