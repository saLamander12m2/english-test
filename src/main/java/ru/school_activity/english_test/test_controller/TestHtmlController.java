package ru.school_activity.english_test.test_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/html-test")
public class TestHtmlController {

    @GetMapping
    public String testHtml(){
        return "index";
    }

    @GetMapping(value = "/sign-in-page")
    public String testSignIn(){
        return "sign-in-page";
    }

    @GetMapping(value = "/sign-up-page")
    public String testSignUp(){
        return "sign-up-page";
    }
}
