package com.example.javalab5.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Worker {
    private final StringProperty workerName;
    private final IntegerProperty age;

    private final DoubleProperty salary;
    public Worker() {
        this(null,0,0.0);
    }

    public Worker(String name, Integer age, Double salary) {
        this.workerName = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.salary = new SimpleDoubleProperty(salary);
    }


    public String getWorkerName() {
        return workerName.get();
    }

    public void setWorkerName(String name) {
        this.workerName.set(name);
    }

    public StringProperty workerNameProperty() {
        return workerName;
    }


    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }


    public double getSalary() {
        return salary.get();
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }

}
