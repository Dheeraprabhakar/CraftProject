package com.example.CraftProject.model;


import jakarta.persistence.*;

@Entity
@Table(name = "sum")
public class Sum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number1", nullable = false)
    private int number1;

    @Column(name = "number2", nullable = false)
    private int number2;

    @Column(name = "sum", nullable = false)
    private int sum;

    // Default constructor
    public Sum() {
    }

    // Parameterized constructor
    public Sum(int number1, int number2, int sum) {
        this.number1 = number1;
        this.number2 = number2;
        this.sum = sum;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}