package com.example.bookstore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity(name = "users")
public class Users {
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    private Long id;

    @Size(min = 5, message = "Login must be at least 5 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Login must contain only letters and numbers")
    private String login;

    @Size(min = 2, message = "The name should have at least 2 characters.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "The name should contain only letters.")
    private String name;

    @Size(min = 2, message = "The last name should have at least 2 characters.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "The last name should contain only letters.")
    private String lastName;

    @Email(message = "Invalid email address format.")
    private String email;

    @Size(min = 8, message = "The password should have at least 8 characters.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$", message = "The password should contain at least one letter and one digit.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public Users(Long id, String login, String name, String lastName, String email, String password) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
