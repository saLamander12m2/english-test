package ru.school_activity.english_test.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
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


    public WrongAnswer(String text) {
        this.text = text;
    }

    public WrongAnswer(String text, TestQuestion testQuestion) {
        this.text = text;
        this.testQuestion = testQuestion;
    }
}
