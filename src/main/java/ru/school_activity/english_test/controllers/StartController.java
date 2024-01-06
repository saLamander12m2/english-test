package ru.school_activity.english_test.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.service.TopicVerbService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/start")
public class StartController {

    private final TopicVerbService topicVerbService;

    @GetMapping()
    public String getHome(Model model) {
        log.info("Hello controller");
        List<TopicVerb> topicVerbs = topicVerbService.getAll();
        log.info(topicVerbs.toString());
        model.addAttribute("topicVerbs", topicVerbs);
        return "start";
    }
}
