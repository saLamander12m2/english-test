package ru.school_activity.english_test.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.school_activity.english_test.service.UploadService;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/admin")
public class AdminController {

    private final UploadService uploadService;

    @Secured("ROLE_ADMIN")
    @GetMapping()
    public String getAdminPage(Model model, HttpSession httpSession) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = !(authentication instanceof AnonymousAuthenticationToken);
        model.addAttribute("isAuthenticated", isAuthenticated);
        model.addAttribute("name", httpSession.getAttribute("name"));

        String result = (String) httpSession.getAttribute("result");
        model.addAttribute("result", result);
        httpSession.removeAttribute("result");
        return "admin";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile, HttpSession httpSession) {

        String result = uploadService.uploadFile(multipartFile);
        httpSession.setAttribute("result", result);
        return "redirect:/admin";
    }
}
