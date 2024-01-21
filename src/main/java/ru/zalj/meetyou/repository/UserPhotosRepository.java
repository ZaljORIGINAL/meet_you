package ru.zalj.meetyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zalj.meetyou.models.UserPhoto;

public interface UserPhotosRepository extends JpaRepository<UserPhoto, Long> {
}