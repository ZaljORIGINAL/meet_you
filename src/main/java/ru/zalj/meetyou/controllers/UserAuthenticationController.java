package ru.zalj.meetyou.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.zalj.meetyou.models.User;
import ru.zalj.meetyou.services.UserAuthenticationService;

@Controller
public class UserAuthenticationController {

    private final UserAuthenticationService userAuthenticationService;

    public UserAuthenticationController(UserAuthenticationService userAuthenticationService) {
        this.userAuthenticationService = userAuthenticationService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(User user) {
        userAuthenticationService.createUser(user);
        return "redirect:/home";
    }

    @GetMapping("/lost_password")
    public String lostPassword() {
        // TODO: ДОДЕЛАТЬ
        return "redirect:/error";
    }

    @PostMapping("/lost_password")
    public String resetPassword(String email) {
        // TODO: ДОДЕЛАТЬ
        return "redirect:/error";
    }
}
