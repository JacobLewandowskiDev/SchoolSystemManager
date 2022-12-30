package com.jakub.SchoolSystemManager.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false, length = 124, unique = true)
    private String email;
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "name", nullable = false, length = 124)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "dateOfBirth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "role", nullable = false)
    private Integer role;

    public User() {
    }

    public User(Long id, String email, String password, String name, String lastname, Date dateOfBirth, Integer role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }
}
