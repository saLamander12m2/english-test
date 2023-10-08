package ru.school_activity.english_test.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "wrong_answers")
public class WrongAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "test_questions_id")
    private TestQuestion testQuestion;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public TestQuestion getTestQuestion() {
        return testQuestion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTestQuestion(TestQuestion testQuestion) {
        this.testQuestion = testQuestion;
    }
}
