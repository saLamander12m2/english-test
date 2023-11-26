package ru.school_activity.english_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

    @GetMapping(value = "/sign-in")
    public String signIn(){
        return "sign-in";
    }

    @GetMapping(value = "/sign-up")
    public String signUp(){
        return "sign-up";
    }
}
