package ru.zalj.meetyou.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.zalj.meetyou.models.User;
import ru.zalj.meetyou.models.UserPhoto;
import ru.zalj.meetyou.services.MyUserProfilesService;

import java.io.IOException;
import java.time.LocalDate;

@Controller
public class MyUserProfileController {

    private final MyUserProfilesService myUserProfilesService;

    public MyUserProfileController(MyUserProfilesService myUserProfilesService) {
        this.myUserProfilesService = myUserProfilesService;
    }

    @GetMapping("/my_profile/editor")
    public String profileView(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "my_profile_editor";
    }

    @GetMapping("/my_profile/view")
    public String profileEditor(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "my_profile_view";
    }

    @PostMapping("/my_profile/add_photo")
    public ResponseEntity<?> addPhoto(
            @AuthenticationPrincipal User user,
            @RequestParam("photo") MultipartFile photo
    ) {
        try {
            UserPhoto p = UserPhoto.instanceOf(photo);
            myUserProfilesService.addPhoto(user, p);
        } catch (IOException e) {
            // TODO Завести лог и вывести сообщение пользователю об ошибке
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/my_profile/save_name")
    public ResponseEntity<?> saveName(
            @AuthenticationPrincipal User user,
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName
    ) {
        myUserProfilesService.saveName(user, firstName, secondName);
        return ResponseEntity.ok().build();
    }

    // TODO Вопрос как принимать дату?
    @PostMapping("/my_profile/save_date_of_birth")
    public ResponseEntity<?> saveDateOfBirth(
            @AuthenticationPrincipal User user,
            @RequestParam("dateOfBirth")
                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth
    ) {
        myUserProfilesService.saveDateOfBirth(user, dateOfBirth);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/my_profile/save_personality")
    public ResponseEntity<?> savePersonality(
            @AuthenticationPrincipal User user,
            @RequestParam("personalityId") long personalityId
    ) {
        myUserProfilesService.savePersonality(user, personalityId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/my_profile/delete_photo")
    public ResponseEntity<?> deletePhoto(
            @AuthenticationPrincipal User user,
            @RequestParam("photoId") long photoId
    ) {
        myUserProfilesService.deletePhoto(user, photoId);
        return ResponseEntity.ok().build();
    }

    // TODO Удаление качества человека
    @PostMapping("/delete/personality")
    public ResponseEntity<?> deletePersonality(
            @AuthenticationPrincipal User user,
            @RequestParam("photoId") long personalityId
    ) {
        myUserProfilesService.deletePersonality(user, personalityId);
        return ResponseEntity.ok().build();
    }
}