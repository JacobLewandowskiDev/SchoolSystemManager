package com.jakub.SchoolSystemManager.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
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


    public User() {
    }

    public User(Long user_id, String email, String password, String name, String lastname, Date dateOfBirth) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }
}
