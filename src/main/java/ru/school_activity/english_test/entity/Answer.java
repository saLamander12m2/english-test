package ru.school_activity.english_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "text")
    private String text;
    @OneToOne
    @JoinColumn(name = "test_question_id")
    private TestQuestion testQuestion;

    public Answer(String text) {
        this.text = text;
    }

    public Answer(String text, TestQuestion testQuestion) {
        this.text = text;
        this.testQuestion = testQuestion;
    }
}
