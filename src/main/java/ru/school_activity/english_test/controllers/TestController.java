package ru.school_activity.english_test.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.school_activity.english_test.dto.CurrentAnswerDto;
import ru.school_activity.english_test.dto.CurrentTest;
import ru.school_activity.english_test.dto.CurrentTestQuestionsDto;
import ru.school_activity.english_test.dto.EndTestDto;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.security.AppUserDetails;
import ru.school_activity.english_test.service.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/test")
@Slf4j
public class TestController {

    private final CurrentTestService currentTestService;
    private final TopicVerbService topicVerbService;
    private final AppUserDetailsService appUserDetailsService;
    private final TestService testService;


    @PostMapping(value = "/create")
    public String startTest(@RequestParam("verb") String verb, Model model,
                            @AuthenticationPrincipal AppUserDetails appUserDetails,
                            HttpSession httpSession) {

        TopicVerb topicVerb = topicVerbService.getTopicVerbByVerb(verb.toLowerCase());

        List<TestQuestion> testQuestions = currentTestService.fillTestQuestionList(topicVerb);

        CurrentTest currentTest = new CurrentTest(topicVerb);
        currentTest.setAppUser(appUserDetails.getAppUser());
        currentTest.setTestQuestions(testQuestions);

        httpSession.setAttribute("currentTestDto", currentTest);

        return "redirect:/test";
    }

    @GetMapping
    public String currentTest(HttpSession httpSession, Model model) {
        CurrentTest currentTest = (CurrentTest) httpSession.getAttribute("currentTestDto");
        CurrentTestQuestionsDto currentTestQuestionsDto = ConvertService.doFromCurrentTestDtoToCurrentTestQuestionsDto(currentTest);

        model.addAttribute("currentTestQuestionsDto", currentTestQuestionsDto);
        model.addAttribute("currentAnswerDto", new CurrentAnswerDto());

        return "test";
    }

    @PostMapping(value = "/answer")
    public String answerTest(@ModelAttribute("currentAnswerDto") CurrentAnswerDto currentAnswerDto,
                             HttpSession httpSession, Model model) {
        CurrentTest currentTest = (CurrentTest) httpSession.getAttribute("currentTestDto");

        currentTest.getUsersAnswers().add(currentAnswerDto.getAnswer());
        currentTestService.giveAnswer(currentTest, currentAnswerDto.getAnswer());
        if (currentTest.isEnd()) {
            return "redirect:/test/end";
        }
        httpSession.setAttribute("currentTestDto", currentTest);

//        EndTestDto endTestDto = (EndTestDto) httpSession.getAttribute("endTestDto");
//        endTestDto.getUsersAnswers().add(currentAnswerDto.getAnswer());
//
//        httpSession.setAttribute("endTestDto", endTestDto);

        return "redirect:/test";
    }

    @GetMapping(value = "/end")
    public String endTest(HttpSession httpSession, Model model) {
        CurrentTest currentTest = (CurrentTest) httpSession.getAttribute("currentTestDto");
        EndTestDto endTestDto = ConvertService.doFromCurrentTestDtoToEndTestDto(currentTest);

        model.addAttribute("endTestDto", endTestDto);

        return "end";
    }
}
