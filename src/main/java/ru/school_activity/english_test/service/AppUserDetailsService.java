package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.AppUser;
import ru.school_activity.english_test.repository.AppUserRepository;
import ru.school_activity.english_test.security.AppUserDetails;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalAppUser = Optional.ofNullable(appUserRepository.findByEmail(username));
        if (optionalAppUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new AppUserDetails(optionalAppUser.get());
    }
}
