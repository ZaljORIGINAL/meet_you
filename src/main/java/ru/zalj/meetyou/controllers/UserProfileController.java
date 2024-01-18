package ru.zalj.meetyou.controllers;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserProfileController {

    @GetMapping("/my_profile/{id}")
    public String myProfile(Model model, UserDetails user, @PathVariable(name = "id") long expectedUserId) {
        model.addAttribute("user", user.getUsername());
        model.addAttribute("expected_user", expectedUserId);
        return "my_profile";
    }

}
