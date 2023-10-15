package ru.school_activity.english_test.test_controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.school_activity.english_test.entity.*;
import ru.school_activity.english_test.repository.*;


@Slf4j
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private final TopicVerbRepository topicVerbRepository;
    private final AnswerRepository answerRepository;
    private final TestQuestionRepository testQuestionRepository;
    private final TestRepository testRepository;
    private final UserRepository userRepository;
    private final WrongAnswerRepository wrongAnswerRepository;


    public TestController(TopicVerbRepository topicVerbRepository, AnswerRepository answerRepository, TestQuestionRepository testQuestionRepository, TestRepository testRepository, UserRepository userRepository, WrongAnswerRepository wrongAnswerRepository) {
        this.topicVerbRepository = topicVerbRepository;
        this.answerRepository = answerRepository;
        this.testQuestionRepository = testQuestionRepository;
        this.testRepository = testRepository;
        this.userRepository = userRepository;
        this.wrongAnswerRepository = wrongAnswerRepository;
    }


    @GetMapping(value = "/saveuser")
    public String saveUser() {

        User user = new User();
        user.setName("Misha");
        user.setEmail("djhfjds.yandex.ru");
        user.setPassword("1223hf");
        userRepository.save(user);

        return "save-user";
    }

    @GetMapping(value = "/savetopicverbs")
    public String saveTopicVerbs() {
        TopicVerb topicVerb = new TopicVerb();
        topicVerb.setVerb("look");
        topicVerbRepository.save(topicVerb);

        return "save-topic-verbs";
    }


    @GetMapping(value = "/savetestquestions")
    public String saveTestQuestions() {
        TestQuestion testQuestion = new TestQuestion();
        testQuestion.setSentence("look after");
        testQuestion.setTopicVerb(topicVerbRepository.findByVerb("look"));
        testQuestionRepository.save(testQuestion);

        return "save-test-questions";
    }
    @GetMapping(value = "/saveanswer")
    public String saveAnswer() {
        Answer answer = new Answer();
        answer.setText("after");
        answer.setTestQuestion(testQuestionRepository.findById(1).get());
        answerRepository.save(answer);
        return "save-answers";
    }

    @GetMapping(value = "/savewronganswers")
    public String saveWringAnswers() {
        WrongAnswer wrongAnswer = new WrongAnswer();
        wrongAnswer.setText("for");
        wrongAnswer.setTestQuestion(testQuestionRepository.findById(1).get());
        wrongAnswerRepository.save(wrongAnswer);
        return "save-wrong-answers";
    }


    @GetMapping(value = "/savetest")
    public String saveTest() {
        Test test = new Test();
        test.setName("look");
        test.setQuestionTotal(15);
        test.setRightAnswers(13);
        test.setTopicVerb(topicVerbRepository.findByVerb("look"));
        test.setUser(userRepository.findByEmail("djhfjds.yandex.ru"));
        testRepository.save(test);

        return "save-test";
    }


}
