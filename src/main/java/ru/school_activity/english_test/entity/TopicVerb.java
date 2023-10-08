package ru.school_activity.english_test.entity;

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

    public int getId() {
        return id;
    }

    public String getVerb() {
        return verb;
    }

    public List<Test> getTests() {
        return tests;
    }

    public List<TestQuestion> getTestQuestions() {
        return testQuestions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public void setTestQuestions(List<TestQuestion> testQuestions) {
        this.testQuestions = testQuestions;
    }
}
