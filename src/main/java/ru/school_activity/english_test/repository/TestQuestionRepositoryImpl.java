package ru.school_activity.english_test.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.school_activity.english_test.entity.TestQuestion;
@RequiredArgsConstructor
@Setter
@Getter
@Repository
public class TestQuestionRepositoryImpl {

    private final TestQuestionRepository testQuestionRepository;

    public Page<TestQuestion> findAll(int offset, int limit) {
        Pageable pageable =  PageRequest.of(offset, limit, Sort.by("id"));
        return testQuestionRepository.findAll(pageable);
    }
}
