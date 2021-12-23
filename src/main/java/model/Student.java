package model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int score;
    private int age;

    @ManyToOne
    private Clasz clasz;

    public Student() {
    }

    public Student(Long id, String name, int score, int age) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public Student(Long id, String name, int score, int age, Clasz clasz) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
        this.clasz = clasz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clasz getClasz() {
        return clasz;
    }

    public void setClasz(Clasz clasz) {
        this.clasz = clasz;
    }
}
