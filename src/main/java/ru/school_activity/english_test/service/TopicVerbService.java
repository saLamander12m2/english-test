package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.repository.TopicVerbRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicVerbService {

    private final TopicVerbRepository topicVerbRepository;

    public TopicVerb getTopicVerbByVerb(String verb) {
        return topicVerbRepository.findByVerb(verb);
    }

    public TopicVerb save(TopicVerb topicVerb){
       return topicVerbRepository.save(topicVerb);
    }

    public List<TopicVerb> getAll() {
        return topicVerbRepository.findAllBy();
    }
}
