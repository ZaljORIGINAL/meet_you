package ru.zalj.meetyou.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_profiles")
public class UserProfile {
    private final static int MAX_USER_PHOTO_COUNT = 6;

    @Id
    private Long id;

    @Column(name = "first_name", columnDefinition = "text")
    private String firstName;

    @Column(name = "second_name", columnDefinition = "text")
    private String secondName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @MapsId
    // https://sysout.ru/otnoshenie-onetoone-v-hibernate/
    private User user;

    @OneToMany(cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
    private final Set<Personality> personalities = new HashSet<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, mappedBy = "userProfile")
    private final List<UserPhoto> userPhotos = new ArrayList<>(MAX_USER_PHOTO_COUNT);

    public UserProfile() {
    }

    public UserProfile(Long id, String firstName, String secondName, LocalDate dateOfBirth, User user) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public User getUser() {
        return user;
    }

    public Set<Personality> getPersonalities() {
        return personalities;
    }

    public List<UserPhoto> getImages() {
        return userPhotos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean addPhoto(UserPhoto photo) {
        if (userPhotos.size() == MAX_USER_PHOTO_COUNT) {
            return false;
        }

        return userPhotos.add(photo);
    }

    public boolean addPersonality(Personality personality) {
        return personalities.add(personality);
    }

    public void deleteUserPhoto(long photoId) {
        userPhotos.removeIf(p -> p.getId() == photoId);
    }

    public void deleteUserPersonality(long personalityId) {
        personalities.removeIf(p -> p.getId() == personalityId);
    }
}