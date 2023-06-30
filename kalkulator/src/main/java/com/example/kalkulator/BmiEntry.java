package com.example.kalkulator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BmiEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weight;
    private double height;
    private double bmi;

    public BmiEntry() {
    }

    public BmiEntry(double weight, double height) {
        this.weight = weight;
        this.height = height;
        this.calculateBmi();
    }

    public Long getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBmi() {
        return bmi;
    }

    private void calculateBmi() {
        double heightInMeters = height / 100;
        bmi = weight / (heightInMeters * heightInMeters);
    }
}
