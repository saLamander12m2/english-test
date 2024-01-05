package ru.school_activity.english_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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


    @Override
    public String toString() {
        return "TopicVerb{" +
                "id=" + id +
                ", verb='" + verb + '\'' +
                ", tests=" + tests +
                ", testQuestions=" + testQuestions +
                '}';
    }
}
