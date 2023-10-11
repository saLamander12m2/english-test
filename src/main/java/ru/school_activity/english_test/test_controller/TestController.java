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



    @GetMapping(value = "/save")
    public String save() {
        log.info("start test controller -> /save");

        TopicVerb topicVerb = topicVerbRepository.findByVerb("look");

        testQuestion.setAnswer(answer);

        User user = userRepository.findByEmail("djhfjds.yandex.ru");

        return "save";
    }

    @GetMapping(value = "/saveuser")
    public String saveUser(){

        User user = new User();
        user.setName("Misha");
        user.setEmail("djhfjds.yandex.ru");
        user.setPassword("1223hf");
        userRepository.save(user);

        TopicVerb topicVerb = new TopicVerb();
        topicVerb.setVerb("look");
        topicVerbRepository.save(topicVerb);

        return "save-user";
    }

    @GetMapping(value = "/savetopicverbs")
    public String saveTopicVerbs(){
        TopicVerb topicVerb = new TopicVerb();
        topicVerb.setVerb("look");
        topicVerbRepository.save(topicVerb);

        return "save-topic-verbs";
    }


    @GetMapping(value = "/savetestquestions")
    public String saveTestQuestions(){
        TestQuestion testQuestion = new TestQuestion();
        testQuestion.setSentence("Police look ... for criminal");
        testQuestion.setTopicVerb(topicVerb);
        testQuestion.setAnswer(answer);
        testQuestionRepository.save(testQuestion);

        return "save-test-questions";
    }

    @GetMapping(value = "/saveanswers")
    public String saveAnswers(){
        Answer answer = new Answer();
        answer.setText("look after");
        answer.setTestQuestion(testQuestion);
        answerRepository.save(answer);

        return "save-answers";
    }

    @GetMapping(value = "/savewronganswers")
    public String saveWrongAnswers(){
        WrongAnswer wrongAnswer = new WrongAnswer();
        wrongAnswer.setText("in");
        wrongAnswer.setTestQuestion(testQuestion);
        wrongAnswerRepository.save(wrongAnswer);

        return "save-wrong-answers";
    }

    @GetMapping(value = "savetest")
    public String saveTest(){
        Test test = new Test();
        test.setName("look");
        test.setQuestionTotal(15);
        test.setRightAnswers(13);
        test.setTopicVerb(topicVerb);
        test.setUser(user);
        testRepository.save(test);

        return "save-test";
    }



}
