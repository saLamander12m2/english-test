package ru.school_activity.english_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private long date = System.currentTimeMillis();

    @Column(name = "question_total")
    private int questionTotal;
    @Column(name = "right_answers")
    private int rightAnswers;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "topic_verb_id")
    private TopicVerb topicVerb;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDate() {
        return date;
    }

    public int getQuestionTotal() {
        return questionTotal;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public AppUser getAppUser() {
        return appUser;
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

    public void setDate(long date) {
        this.date = date;
    }

    public void setQuestionTotal(int questionTotal) {
        this.questionTotal = questionTotal;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setTopicVerb(TopicVerb topicVerb) {
        this.topicVerb = topicVerb;
    }
}
