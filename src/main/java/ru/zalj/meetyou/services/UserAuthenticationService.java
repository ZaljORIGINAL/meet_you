package ru.zalj.meetyou.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.zalj.meetyou.models.Enums.Role;
import ru.zalj.meetyou.models.User;
import ru.zalj.meetyou.repository.UsersRepository;

import java.security.InvalidParameterException;

@Service
public class UserAuthenticationService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAuthenticationService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        if (usersRepository.existsByEmail(user.getUsername())) {
            throw new InvalidParameterException();
        }

        user.setBlocked(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRole(Role.SIMPLE);
        usersRepository.save(user);
        return user;
    }
}
