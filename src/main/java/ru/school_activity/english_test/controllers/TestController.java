package ru.school_activity.english_test.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/test")
public class TestController {


//    @GetMapping(value = "/download")
//    public String getTest() {
//        return "/start";
//    }
}
