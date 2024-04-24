package com.example.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.boot.context.properties.bind.Name;

@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double price;

    public Book(Double price, String description, String name, Long id) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.name = name;
    }

    public Book() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
