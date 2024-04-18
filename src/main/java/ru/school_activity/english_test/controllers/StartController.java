package ru.school_activity.english_test.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.school_activity.english_test.dto.HistoryDto;
import ru.school_activity.english_test.entity.Role;
import ru.school_activity.english_test.entity.Test;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.repository.TestRepository;
import ru.school_activity.english_test.security.AppUserDetails;
import ru.school_activity.english_test.service.ConvertService;
import ru.school_activity.english_test.service.TopicVerbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/start")
public class StartController {

    private final TopicVerbService topicVerbService;
    private final TestRepository testRepository;

    @GetMapping()
    public String getHome(Model model, @AuthenticationPrincipal AppUserDetails appUserDetails, HttpSession httpSession) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = !(authentication instanceof AnonymousAuthenticationToken);
        String name = appUserDetails.getAppUser().getUsername();

        AtomicBoolean isAdmin = new AtomicBoolean(false);
        Set<Role> roles = appUserDetails.getAppUser().getRoles();
        roles.forEach(role -> {
            isAdmin.set(role.getName().equals("ADMIN"));
        });

        model.addAttribute("isAuthenticated", isAuthenticated);
        model.addAttribute("name", name);
        model.addAttribute("isAdmin", isAdmin);

        httpSession.setAttribute("name", name);

        List<TopicVerb> topicVerbs = topicVerbService.getAll();
        log.info(topicVerbs.toString());
        model.addAttribute("topicVerbs", topicVerbs);

        List<Test> tests = testRepository.findAllByAppUser(appUserDetails.getAppUser(), Sort.by(Sort.Direction.DESC, "date"));
        List<HistoryDto> historyDtoList = new ArrayList<>();
        tests.forEach(item -> historyDtoList.add(ConvertService.doFromTestToHistoryDto(item)));
        model.addAttribute("historyDtoList", historyDtoList);
        return "start";
    }
}
