package ru.school_activity.english_test.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.school_activity.english_test.dto.CurrentAnswerDto;
import ru.school_activity.english_test.dto.CurrentTestDto;
import ru.school_activity.english_test.dto.CurrentTestQuestionsDto;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.security.AppUserDetails;
import ru.school_activity.english_test.service.AppUserDetailsService;
import ru.school_activity.english_test.service.ConvertService;
import ru.school_activity.english_test.service.CurrentTestService;
import ru.school_activity.english_test.service.TopicVerbService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/test")
@Slf4j
public class TestController {

    private final CurrentTestService currentTestService;
    private final TopicVerbService topicVerbService;
    private final AppUserDetailsService appUserDetailsService;

    @PostMapping(value = "/create")
    public String startTest(@RequestParam("topicVerb") String verb, Model model, @AuthenticationPrincipal AppUserDetails appUserDetails){

        TopicVerb topicVerb = topicVerbService.getTopicVerbByVerb(verb.toLowerCase());

        List<TestQuestion> testQuestions = currentTestService.fillTestQuestionList(topicVerb);

        CurrentTestDto currentTestDto = new CurrentTestDto(topicVerb);
        currentTestDto.setAppUser(appUserDetails.getAppUser());
        currentTestDto.setTestQuestions(testQuestions);

        CurrentTestQuestionsDto currentTestQuestionsDto = ConvertService.doFromCurrentTestDtoToCurrentTestQuestionsDto(currentTestDto);
        log.info(currentTestQuestionsDto.getAnswers().toString());

        model.addAttribute("currentTestQuestionsDto", currentTestQuestionsDto);
        model.addAttribute("currentAnswerDto", new CurrentAnswerDto());
        return "index";
    }

    @PostMapping(value = "/answer")
    public String answerTest(@ModelAttribute("currentAnswerDto") CurrentAnswerDto currentAnswerDto){
        log.info(currentAnswerDto.toString());

        return "redirect:/index";
    }

}
