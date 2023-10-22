package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.dto.CurrentTestDto;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.repository.TestQuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CurrentTestService {

    private final TestQuestionRepository testQuestionRepository;
    private static Random random;

    @Value("${app.testQuestionsQuantity}")
    private int testQuestionsQuantity;

    public void createCurrentTest(TopicVerb topicVerb) {
        CurrentTestDto currentTestDto = new CurrentTestDto(topicVerb);
        currentTestDto.setTestQuestions(fillTestQuestionList(topicVerb));
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

    public void giveAnswer(CurrentTestDto currentTestDto, Answer answer) {
        Answer rightAnswer = currentTestDto.getTestQuestions().get(currentTestDto.getCurrentTestQuestions()).getAnswer();
        if (rightAnswer.getText().equals(answer.getText())) {
            currentTestDto.setRightAnswersQuantity(currentTestDto.getRightAnswersQuantity() + 1);
        }
        goNextQuestion(currentTestDto);

    }

    private void goNextQuestion(CurrentTestDto currentTestDto) {
        currentTestDto.setCurrentTestQuestions(currentTestDto.getCurrentTestQuestions() + 1);
    }
}
