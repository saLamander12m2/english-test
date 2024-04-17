package ru.school_activity.english_test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.school_activity.english_test.entity.TestQuestion;
import ru.school_activity.english_test.entity.TopicVerb;

import java.util.List;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion, Integer> {

    List<TestQuestion> findByTopicVerb(TopicVerb topicVerb);

    Page<TestQuestion> findAll(int offset, int limit);
}
