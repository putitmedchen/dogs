package com.example.dogs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.awt.*;
import java.util.Objects;

@Entity
public class Dog {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private Bread bread;
    private Color color;
    private int age;

    public Dog() {
    }

    public Dog(String name, Bread bread, Color color, int age) {
        this.name = name;
        this.bread = bread;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(this.id, dog.id) && Objects.equals(this.name, dog.name) && Objects.equals(this.bread, dog.bread);
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.bread, this, color, this.age);
    }


    @Override
    public String toString() {
        return "Dog{" + "id=" + this.id + ", name='" + this.name + '\'' + ", bread='" + this.bread + '\'' + ", color='" + this.color + '\'' + ", age='" + this.age + '}';
    }

    public Long getId() {
        return this.id;
    }
}
