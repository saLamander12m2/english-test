package ru.school_activity.english_test.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.AppUser;
import ru.school_activity.english_test.repository.AppUserRepository;
import ru.school_activity.english_test.repository.RoleRepository;

import java.util.Set;


@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.adminpass}")
    private String adminPass;

    @Value("${app.adminemail}")
    private String adminEmail;

    @PostConstruct
    public void createAdmin() {
        log.info("Create ADMIN in PostConstruct");
        AppUser admin = AppUser.builder()
                .username("admin")
                .password(passwordEncoder.encode(adminPass))
                .email(adminEmail)
                .roles(Set.of(roleRepository.findByName("ADMIN").get()))
                .build();
        try {
            appUserRepository.save(admin);
            log.info("Successfully save user ADMIN");
        } catch (DataIntegrityViolationException e){
            log.info("User ADMIN already exist");
        }
    }
}
