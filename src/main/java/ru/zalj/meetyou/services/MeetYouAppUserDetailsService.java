package ru.zalj.meetyou.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.zalj.meetyou.repository.UsersRepository;

@Service
public class MeetYouAppUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public MeetYouAppUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByEmail(username);
    }
}
