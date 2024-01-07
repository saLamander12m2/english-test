package ru.school_activity.english_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "test_questions")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sentence")
    private String sentence;
    @OneToOne(mappedBy = "testQuestion")
    private Answer answer;
    @OneToMany(mappedBy = "testQuestion", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<WrongAnswer> wrongAnswers;
    @ManyToOne
    @JoinColumn(name = "topic_verb_id")
    private TopicVerb topicVerb;


    public TestQuestion(String sentence) {
        this.sentence = sentence;
    }
}
