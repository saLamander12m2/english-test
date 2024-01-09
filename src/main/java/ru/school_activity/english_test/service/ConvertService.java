package ru.school_activity.english_test.service;

import ru.school_activity.english_test.dto.CurrentTest;
import ru.school_activity.english_test.dto.CurrentTestQuestionsDto;
import ru.school_activity.english_test.dto.EndTestDto;
import ru.school_activity.english_test.dto.HistoryDto;
import ru.school_activity.english_test.entity.Test;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.WrongAnswer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ConvertService {
    public static Test doFromCurrentTestDtoToTest(CurrentTest currentTest) {
        return Test.builder()
                .questionTotal(currentTest.getTestQuestions().size())
                .rightAnswers(currentTest.getRightAnswersQuantity())
                .appUser(currentTest.getAppUser())
                .topicVerb(currentTest.getTopicVerb())
                .build();
    }

    public static CurrentTestQuestionsDto doFromCurrentTestDtoToCurrentTestQuestionsDto(CurrentTest currentTest) {
        TestQuestion testQuestion = currentTest.getTestQuestions().get(currentTest.getCurrentTestQuestion());
        List<String> answers = new ArrayList<>();
        answers.add(testQuestion.getAnswer().getText());

        for (WrongAnswer item : testQuestion.getWrongAnswers()) {
            answers.add(item.getText());
        }
        Collections.shuffle(answers);

        return CurrentTestQuestionsDto.builder()
                .currentTestQuestion(currentTest.getCurrentTestQuestion())
                .testQuestion(testQuestion.getSentence())
                .testQuestionTotal(currentTest.getTestQuestions().size())
                .answers(answers)
                .build();
    }

    public static EndTestDto doFromCurrentTestDtoToEndTestDto(CurrentTest currentTest) {

        List<String> rightAnswers = new ArrayList<>();
        currentTest.getTestQuestions().forEach(question -> rightAnswers.add(question.getAnswer().getText()));
        List<String> testQuestionSentences = new ArrayList<>();
        currentTest.getTestQuestions().forEach(item -> testQuestionSentences.add(item.getSentence()));
        return EndTestDto.builder()
                .rightAnswerQuantity(currentTest.getRightAnswersQuantity())
                .totalTestQuestionQuantity(currentTest.getTestQuestions().size())
                .usersAnswers(currentTest.getUsersAnswers())
                .rightAnswers(rightAnswers)
                .testQuestionSentences(testQuestionSentences)
                .build();
    }

    public static HistoryDto doFromTestToHistoryDto(Test test){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = new Date(test.getDate());
        String dateString = simpleDateFormat.format(date);

        return HistoryDto.builder()
                .rightAnswersQuantity(test.getRightAnswers())
                .questionTotal(test.getQuestionTotal())
                .topicVerb(test.getTopicVerb().getVerb())
                .date(dateString)
                .build();
    }
}
