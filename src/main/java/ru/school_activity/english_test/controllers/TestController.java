package ru.school_activity.english_test.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.school_activity.english_test.dto.CurrentAnswerDto;
import ru.school_activity.english_test.dto.CurrentTestDto;
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
    public String startTest(@RequestParam("verb") String verb, Model model, @AuthenticationPrincipal AppUserDetails appUserDetails, HttpSession httpSession) {

        TopicVerb topicVerb = topicVerbService.getTopicVerbByVerb(verb.toLowerCase());

        List<TestQuestion> testQuestions = currentTestService.fillTestQuestionList(topicVerb);

        CurrentTestDto currentTestDto = new CurrentTestDto(topicVerb);
        currentTestDto.setAppUser(appUserDetails.getAppUser());
        currentTestDto.setTestQuestions(testQuestions);

        httpSession.setAttribute("currentTestDto", currentTestDto);

//        EndTestDto endTestDto = new EndTestDto();
//        endTestDto.setTotalTestQuestionQuantity(testQuestions.size());
//        List<String> rightAnswers = new ArrayList<>();
//        testQuestions.forEach(question -> rightAnswers.add(question.getAnswer().getText()));
//        endTestDto.setRightAnswers(rightAnswers);
//        httpSession.setAttribute("endTestDto", endTestDto);

        return "redirect:/test";
    }

    @GetMapping
    public String currentTest(HttpSession httpSession, Model model) {
        CurrentTestDto currentTestDto = (CurrentTestDto) httpSession.getAttribute("currentTestDto");
        CurrentTestQuestionsDto currentTestQuestionsDto = ConvertService.doFromCurrentTestDtoToCurrentTestQuestionsDto(currentTestDto);

        model.addAttribute("currentTestQuestionsDto", currentTestQuestionsDto);
        model.addAttribute("currentAnswerDto", new CurrentAnswerDto());

        return "test";
    }

    @PostMapping(value = "/answer")
    public String answerTest(@ModelAttribute("currentAnswerDto") CurrentAnswerDto currentAnswerDto, HttpSession httpSession, Model model) {
        CurrentTestDto currentTestDto = (CurrentTestDto) httpSession.getAttribute("currentTestDto");

        currentTestDto.getUsersAnswers().add(currentAnswerDto.getAnswer());
        currentTestService.giveAnswer(currentTestDto, currentAnswerDto.getAnswer());
        if (currentTestDto.isEnd()) {
            return "redirect:/test/end";
        }
        httpSession.setAttribute("currentTestDto", currentTestDto);

//        EndTestDto endTestDto = (EndTestDto) httpSession.getAttribute("endTestDto");
//        endTestDto.getUsersAnswers().add(currentAnswerDto.getAnswer());
//
//        httpSession.setAttribute("endTestDto", endTestDto);

        return "redirect:/test";
    }

    @GetMapping(value = "/end")
    public String endTest(HttpSession httpSession, Model model) {
        CurrentTestDto currentTestDto = (CurrentTestDto) httpSession.getAttribute("currentTestDto");
        EndTestDto endTestDto = ConvertService.doFromCurrentTestDtoToEndTestDto(currentTestDto);

        model.addAttribute("endTestDto", endTestDto);

        return "end";
    }
}
