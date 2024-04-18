package ru.school_activity.english_test.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.school_activity.english_test.entity.AppUser;
import ru.school_activity.english_test.entity.Test;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    List<Test> findAllByAppUser(AppUser appUser, Sort sort);
}
