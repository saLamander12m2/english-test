package ru.school_activity.english_test.model;


import jakarta.persistence.*;

@Entity
@Table(name = "wrong_answers")
public class WrongAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "text")
    private String text;
    private String questionId;
}
