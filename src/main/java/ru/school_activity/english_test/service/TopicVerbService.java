package ru.school_activity.english_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school_activity.english_test.entity.TopicVerb;
import ru.school_activity.english_test.repository.TopicVerbRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicVerbService {

    private final TopicVerbRepository topicVerbRepository;

    public List<TopicVerb> getTopicVerbList(){
        return topicVerbRepository.findAllBy();
    }
}
