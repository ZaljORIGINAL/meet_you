package ru.zalj.meetyou.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.zalj.meetyou.models.User;
import ru.zalj.meetyou.repository.UsersRepository;

import java.util.Optional;

@Service
public class UserProfileService {

    private final UsersRepository usersRepository;

    public UserProfileService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/profile/{id}")
    public String profile(Model model, @PathVariable(value = "id") long id) {
        Optional<User> opt = usersRepository.findById(id);
        if (opt.isEmpty()) {
            return "redirect:/error";
        }

        model.addAttribute(opt.get());
        return "user_profile";
    }
}
