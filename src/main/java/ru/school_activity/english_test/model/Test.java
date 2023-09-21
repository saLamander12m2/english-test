package ru.school_activity.english_test.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;
    @Column(name = "question_total")
    private int questionTotal;
    @Column(name = "right_answers")
    private int rightAnswers;
    private int verbsId;
}
