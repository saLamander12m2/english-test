package ru.school_activity.english_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.school_activity.english_test.entity.TestQuestion;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion, Integer> {
}
