package ru.school_activity.english_test.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.school_activity.english_test.dto.HistoryDto;
import ru.school_activity.english_test.entity.Test;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.repository.TestRepository;
import ru.school_activity.english_test.service.ConvertService;
import ru.school_activity.english_test.service.TestService;
import ru.school_activity.english_test.service.TopicVerbService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/start")
public class StartController {

    private final TopicVerbService topicVerbService;
    private final TestRepository testRepository;

    @GetMapping()
    public String getHome(Model model) {
        log.info("Hello controller");
        List<TopicVerb> topicVerbs = topicVerbService.getAll();
        log.info(topicVerbs.toString());
        model.addAttribute("topicVerbs", topicVerbs);

        List<Test> tests = testRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
        List<HistoryDto> historyDtoList = new ArrayList<>();
        tests.forEach(item -> historyDtoList.add(ConvertService.doFromTestToHistoryDto(item)));
        model.addAttribute("historyDtoList", historyDtoList);
        return "start";
    }
}
