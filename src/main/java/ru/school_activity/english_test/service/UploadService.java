package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.entity.WrongAnswer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UploadService {

    private final TopicVerbService topicVerbService;
    private final TestQuestionService testQuestionService;
    private final AnswerService answerService;
    private final WrongAnswerService wrongAnswerService;

    public String uploadFile(MultipartFile multipartFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {

            String line = reader.readLine();
            int successLine = 0;
            int totalLine = 0;

            while ((line = reader.readLine()) != null) {
                totalLine++;

                String[] stringArray = line.split(";");

                if (stringArray.length == 7) {

                    TopicVerb topicVerb;
                    topicVerb = topicVerbService.getTopicVerbByVerb(stringArray[1].toLowerCase());
                    if (topicVerb == null) {
                        topicVerb = new TopicVerb(stringArray[1].toLowerCase());
                        topicVerbService.save(topicVerb);
                    }

                    TestQuestion testQuestion = new TestQuestion(stringArray[2]);
                    testQuestion.setTopicVerb(topicVerb);
                    try {
                        testQuestionService.save(testQuestion);

                        Answer answer = new Answer(stringArray[3].toLowerCase(), testQuestion);

                        List<WrongAnswer> wrongAnswers = new ArrayList<>();
                        for (int y = 4; y < 7; y++) {
                            wrongAnswers.add(new WrongAnswer(stringArray[y].toLowerCase(), testQuestion));
                        }

                        answerService.save(answer);
                        wrongAnswers.forEach(wrongAnswerService::save);

                        log.info("Successfully save testQuestion -> {}", testQuestion.toString());
                        successLine++;
                    } catch (DataIntegrityViolationException e) {
                        log.info("TestQuestion already exists -> {}", testQuestion.toString());
                        stringBuilder.append("- Error in line %d: question for test already exists<br>".formatted(totalLine));
                    }
                } else {
                    stringBuilder.append("- Error in line %d: there are not enough arguments for the question<br>".formatted(totalLine));
                }
            }
            log.info("Всего в файле {} строк", totalLine);
            stringBuilder.append("Successfully upload %d from %d lines".formatted(successLine, totalLine));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
