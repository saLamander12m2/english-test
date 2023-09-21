package ru.school_activity.english_test.model;

import jakarta.persistence.*;

@Entity
@Table(name = "test_questions")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sentence")
    private String sentence;
    private int verbsId;

}
