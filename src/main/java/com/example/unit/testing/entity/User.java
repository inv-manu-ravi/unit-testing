package com.example.unit.testing.entity;

import javax.persistence.*;

import lombok.Data;

import javax.persistence.*;

@Entity // Specifies that this class is an entity
@Data
@Table(name = "users") // Specifies the name of the database table that this entity maps to
public class User {

    @Id // Specifies the primary key property
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the primary key should be generated automatically by the database
    private Long id;

    @Column(nullable = false) // Specifies that this column cannot be null
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) // Specifies that this column cannot be null and should be unique
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }
}

