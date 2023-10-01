package ru.school_activity.english_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.repository.TopicVerbRepository;

@Service
public class TopicVerbService {
    private TopicVerbRepository topicVerbRepository;

    @Autowired
    public TopicVerbService(TopicVerbRepository topicVerbRepository) {
        this.topicVerbRepository = topicVerbRepository;
    }
}
