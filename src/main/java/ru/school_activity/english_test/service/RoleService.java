package ru.school_activity.english_test.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.AppUser;
import ru.school_activity.english_test.entity.Role;
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
    public void addRoles() {
        log.info("Try to save Role");
        Role roleUser = new Role("USER");
        try {
            roleRepository.save(roleUser);
            log.info("Successfully save role USER");
        } catch (DataIntegrityViolationException exception) {
            log.info("Role USER already exist in db");
        }

        Role roleAdmin = new Role("ADMIN");
        try {
            roleRepository.save(roleAdmin);
            log.info("Successfully save role ADMIN");
        } catch (DataIntegrityViolationException e) {
            log.info("Role ADMIN already exist in db");
        }

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
