package ru.school_activity.english_test.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.school_activity.english_test.entity.Answer;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.entity.WrongAnswer;
import ru.school_activity.english_test.repository.TopicVerbRepository;
import ru.school_activity.english_test.service.AnswerService;
import ru.school_activity.english_test.service.TestQuestionService;
import ru.school_activity.english_test.service.TopicVerbService;
import ru.school_activity.english_test.service.WrongAnswerService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/admin")
public class AdminController {

    private final TopicVerbService topicVerbService;
    private final TestQuestionService testQuestionService;
    private final AnswerService answerService;
    private final WrongAnswerService wrongAnswerService;

    @GetMapping()
    public String getAdminPage() {
        return "admin-page";
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {

            String line = reader.readLine();
            int i = 0;

            while ((line = reader.readLine()) != null) {

                String[] stringArray = line.split(",");
                System.out.println(Arrays.toString(stringArray));
                i++;

                TopicVerb topicVerb;
                topicVerb = topicVerbService.getTopicVerbByVerb(stringArray[1]);
                if (topicVerb == null) {
                    topicVerb = new TopicVerb(stringArray[1]);
                }

                TestQuestion testQuestion = new TestQuestion(stringArray[2]);
                testQuestion.setTopicVerb(topicVerb);
                testQuestionService.save(testQuestion);

                try {
                    Answer answer = new Answer(stringArray[3], testQuestion);

                    List<WrongAnswer> wrongAnswers = new ArrayList<>();
                    for (int y = 4; y < 7; y++) {
                        wrongAnswers.add(new WrongAnswer(stringArray[y], testQuestion));
                    }

//                    testQuestion.setAnswer(answer);
//                    testQuestion.setWrongAnswers(wrongAnswers);

                    answerService.save(answer);
                    wrongAnswers.forEach(wrongAnswerService::save);

                    log.info("Successfully save testQuestion -> {}", testQuestion.toString());
                } catch (DataIntegrityViolationException e) {
                    log.info("TestQuestion already exists -> {}", testQuestion.toString());
                }
            }
            log.info("Всего в файле {} строк", i);

            return "redirect:/admin";

        } catch (IOException e) {

        }

        return "admin-page";
    }
}
