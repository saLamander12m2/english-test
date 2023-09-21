package ru.school_activity.english_test.model;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "text")
    private String text;
    private int questionId;
}
