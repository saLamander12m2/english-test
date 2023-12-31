package ru.school_activity.english_test.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/sign-in")
public class AuthController {


    @GetMapping()
    public String signIn(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        log.info("try auth for user -> {}", authentication.getPrincipal().toString());
        boolean isAuthenticated = !(authentication instanceof AnonymousAuthenticationToken);
        model.addAttribute(isAuthenticated);
        return "/sign-in";
    }


// доставали из userDetails объект appUser и из него поле username
//    @GetMapping("/")
//    public String getName(Model model, @AuthenticationPrincipal AppUserDetails appUserDetails){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("name", appUserDetails.getAppUser().getUsername());
//        return "/index";
//    }


}