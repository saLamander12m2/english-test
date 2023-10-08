package ru.school_activity.english_test.entity;

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
    @OneToMany(mappedBy = "testQuestion")
    private List<WrongAnswer> wrongAnswers;
    @ManyToOne
    @JoinColumn(name = "topic_verb_id")
    private TopicVerb topicVerb;

    public int getId() {
        return id;
    }

    public String getSentence() {
        return sentence;
    }

    public Answer getAnswer() {
        return answer;
    }

    public List<WrongAnswer> getWrongAnswers() {
        return wrongAnswers;
    }

    public TopicVerb getTopicVerb() {
        return topicVerb;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setWrongAnswers(List<WrongAnswer> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public void setTopicVerb(TopicVerb topicVerb) {
        this.topicVerb = topicVerb;
    }
}
