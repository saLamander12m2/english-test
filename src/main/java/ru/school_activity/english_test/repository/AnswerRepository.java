package ru.school_activity.english_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.school_activity.english_test.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
