package ru.school_activity.english_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;




@SpringBootApplication
@EnableJpaAuditing
@ComponentScan({"ru.school_activity.english_test.service", "ru.school_activity.english_test.config",
    "ru.school_activity.english_test.controllers", "ru.school_activity.english_test.repository"})
public class EnglishTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnglishTestApplication.class, args);
    }

}
