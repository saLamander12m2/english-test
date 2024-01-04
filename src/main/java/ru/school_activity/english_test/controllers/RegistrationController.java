package ru.school_activity.english_test.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.school_activity.english_test.customException.UserExistException;
import ru.school_activity.english_test.dto.SignUpDto;
import ru.school_activity.english_test.service.AppUserService;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/sign-up")
public class RegistrationController {

    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping()
    public String signUp(Model model) {
        model.addAttribute("signUpDto", new SignUpDto());
        model.addAttribute("warning", "");

        return "sign-up";
    }


    @PostMapping
    public String signUpForm(@ModelAttribute("signUpDto") SignUpDto signUpDto, BindingResult bindingResult, Model model) {

//        signUpDto.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        try {
            appUserService.save(signUpDto);
        } catch (UserExistException e) {
            model.addAttribute("warning", e.getMessage());
            return "/sign-up";
        }

        return "redirect:/sign-in";
    }
}

