package ru.school_activity.english_test.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;
    @Column(name = "question_total")
    private int questionTotal;
    @Column(name = "right_answers")
    private int rightAnswers;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "topic_verb_id")
    private TopicVerb topicVerb;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public int getQuestionTotal() {
        return questionTotal;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public User getUser() {
        return user;
    }

    public TopicVerb getTopicVerb() {
        return topicVerb;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQuestionTotal(int questionTotal) {
        this.questionTotal = questionTotal;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTopicVerb(TopicVerb topicVerb) {
        this.topicVerb = topicVerb;
    }
}
