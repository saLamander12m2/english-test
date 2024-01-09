package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.dto.CurrentTest;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.repository.TestQuestionRepository;
import ru.school_activity.english_test.repository.TestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CurrentTestService {

    private final TestQuestionRepository testQuestionRepository;
    private final TestRepository testRepository;
    private static final Random random = new Random();

    @Value("${app.testQuestionsQuantity}")
    private int testQuestionsQuantity;

    public CurrentTest createCurrentTest(TopicVerb topicVerb) {
        CurrentTest currentTest = new CurrentTest(topicVerb);
        currentTest.setTestQuestions(fillTestQuestionList(topicVerb));

        return currentTest;
    }

    public List<TestQuestion> fillTestQuestionList(TopicVerb topicVerb) {
        ArrayList<TestQuestion> currentQuestions = new ArrayList<>();
        List<TestQuestion> allQuestions = testQuestionRepository.findByTopicVerb(topicVerb);
        while (currentQuestions.size() < testQuestionsQuantity && !allQuestions.isEmpty()) {
            int index = random.nextInt(allQuestions.size());
            currentQuestions.add(allQuestions.remove(index));
        }
        return currentQuestions;
    }

    public void giveAnswer(CurrentTest currentTest, String answer) {
        if (currentTest.isAnswerRight(answer)) {
            currentTest.incrementRightAnswerCounter();
        }
        currentTest.setStateEndIfNecessary();
        if (currentTest.isEnd()) {
            testRepository.save(ConvertService.doFromCurrentTestDtoToTest(currentTest));
        } else {
            goNextQuestion(currentTest);
        }
    }

    private void goNextQuestion(CurrentTest currentTest) {
        currentTest.setCurrentTestQuestion(currentTest.getCurrentTestQuestion() + 1);
    }
}
