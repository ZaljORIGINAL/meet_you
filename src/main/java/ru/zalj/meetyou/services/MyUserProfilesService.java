package ru.zalj.meetyou.services;

import org.springframework.stereotype.Service;
import ru.zalj.meetyou.models.Personality;
import ru.zalj.meetyou.models.User;
import ru.zalj.meetyou.models.UserPhoto;
import ru.zalj.meetyou.models.UserProfile;
import ru.zalj.meetyou.repository.PersonalityRepository;
import ru.zalj.meetyou.repository.UserPhotosRepository;
import ru.zalj.meetyou.repository.UserProfilesRepository;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class MyUserProfilesService {

    private final UserProfilesRepository userProfilesRepository;
    private final PersonalityRepository personalityRepository;

    public MyUserProfilesService(UserProfilesRepository userProfilesRepository, PersonalityRepository personalityRepository) {
        this.userProfilesRepository = userProfilesRepository;
        this.personalityRepository = personalityRepository;
    }


    public void addPhoto(User user, UserPhoto p) {
        UserProfile profile = user.getUserProfile();
        profile.addPhoto(p);
        userProfilesRepository.saveAndFlush(profile);
    }

    public void saveName(User user, String firstName, String secondName) {
        UserProfile profile = user.getUserProfile();
        profile.setFirstName(firstName);
        profile.setSecondName(secondName);
        userProfilesRepository.saveAndFlush(profile);
    }

    public void saveDateOfBirth(User user, LocalDate dateOfBirth) {
        UserProfile profile = user.getUserProfile();
        profile.setDateOfBirth(dateOfBirth);
        userProfilesRepository.saveAndFlush(profile);
    }

    public void savePersonality(User user, long personalityId) {
        UserProfile profile = user.getUserProfile();
        Optional<Personality> opt = personalityRepository.findById(personalityId);
        Personality personality = opt.orElseThrow(
                () -> new InvalidParameterException("Not found personality by id %s".formatted(personalityId))
        );
        profile.addPersonality(personality);
        userProfilesRepository.saveAndFlush(profile);
    }

    public void deletePhoto(User user, long photoId) {
        UserProfile profile = user.getUserProfile();
        profile.deleteUserPhoto(photoId);
        userProfilesRepository.saveAndFlush(profile);
    }

    public void deletePersonality(User user, long personalityId) {
        UserProfile profile = user.getUserProfile();
        profile.deleteUserPersonality(personalityId);
        userProfilesRepository.saveAndFlush(profile);
    }
}