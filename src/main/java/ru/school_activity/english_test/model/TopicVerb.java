package ru.school_activity.english_test.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "topic_verbs")
public class TopicVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "verb")
    private String verb;
    @OneToMany(mappedBy = "topicVerb")
    private List<Test> tests;
    @OneToMany(mappedBy = "topicVerb")
    private List<TestQuestion> testQuestions;
}
