package ru.zalj.meetyou.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class UserProfile {
    @Id
    private Long id;

    @Column(name = "first_name", columnDefinition = "text")
    private String firstName;

    @Column(name = "second_name", columnDefinition = "text")
    private String secondName;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @MapsId
    // https://sysout.ru/otnoshenie-onetoone-v-hibernate/
    private User user;

    @OneToMany(cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
    private final Set<Personality> personality = new HashSet<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, mappedBy = "userProfile")
    private final List<Image> images = new ArrayList<>(6);

    public UserProfile() {
    }

    public UserProfile(Long id, String firstName, String secondName, LocalDateTime dateOfBirth, User user) {
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

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public User getUser() {
        return user;
    }

    public Set<Personality> getPersonality() {
        return personality;
    }

    public List<Image> getImages() {
        return images;
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

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
