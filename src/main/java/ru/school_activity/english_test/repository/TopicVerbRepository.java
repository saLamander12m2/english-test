package ru.school_activity.english_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.school_activity.english_test.entity.TopicVerb;

import java.util.List;

@Repository
public interface TopicVerbRepository extends JpaRepository<TopicVerb, Integer> {
    TopicVerb findByVerb(String verb);

    List<TopicVerb> findAllBy();
}
