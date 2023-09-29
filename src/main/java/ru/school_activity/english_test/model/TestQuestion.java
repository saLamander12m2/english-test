package ru.school_activity.english_test.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "test_questions")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sentence")
    private String sentence;
    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;
    @OneToMany(mappedBy = "test")
    private List<WrongAnswer> wrongAnswers;
    @ManyToOne
    @JoinColumn(name = "topic_verb_id")
    private TopicVerb topicVerb;
}
