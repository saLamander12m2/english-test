package ru.school_activity.english_test.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.school_activity.english_test.dto.SignUpDto;
import ru.school_activity.english_test.repository.AppUserRepository;
import ru.school_activity.english_test.service.AppUserService;

import static org.apache.coyote.http11.Constants.a;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/sign-up")
public class RegistrationController {

    private final AppUserService appUserService;
    @GetMapping()
    public String signUp(Model model) {
        model.addAttribute("signUpDto", new SignUpDto());
        return "sign-up";
    }


    @PostMapping
    public String signUpForm(@ModelAttribute("signUpDto") SignUpDto signUpDto, BindingResult bindingResult){
        appUserService.save(signUpDto);

        return "/index";
    }
}

