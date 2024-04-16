package com.example.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "images")
public class Image {
    @GeneratedValue
    @Id
    private Long id;

    private String path;

    private Long usedInId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getUsedInId() {
        return usedInId;
    }

    public void setUsedInId(Long usedInId) {
        this.usedInId = usedInId;
    }

    public Image() {
    }

    public Image(Long id, String path, Long usedInId) {
        this.id = id;
        this.path = path;
        this.usedInId = usedInId;
    }
}
