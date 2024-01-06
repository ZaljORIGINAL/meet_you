package ru.zalj.meetyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zalj.meetyou.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String username);

    boolean existsByName(String name);
}
