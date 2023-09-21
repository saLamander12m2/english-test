package ru.school_activity.english_test.model;

import jakarta.persistence.*;

@Entity
@Table(name = "verbs")
public class Verbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "verbs")
    private String verbs;
}
