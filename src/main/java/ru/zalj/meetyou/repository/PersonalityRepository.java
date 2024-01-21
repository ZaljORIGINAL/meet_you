package ru.zalj.meetyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zalj.meetyou.models.Personality;

public interface PersonalityRepository extends JpaRepository<Personality, Long> {
}