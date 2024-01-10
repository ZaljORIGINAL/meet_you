package ru.zalj.meetyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zalj.meetyou.models.UserProfile;

public interface UserProfilesRepository extends JpaRepository<UserProfile, Long> {
}
