package com.example.demo;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;
    @ManyToOne
    private ArrayList<Course> courses=new ArrayList<>();

}
