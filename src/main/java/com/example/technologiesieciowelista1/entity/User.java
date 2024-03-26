package com.example.technologiesieciowelista1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String role;
    private String email;
    private String fullUserName;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Loan> loans = new HashSet<>();

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getFullUserName() {return fullUserName;}
    public void setFullUserName(String fullUserName) {this.fullUserName = fullUserName;}
    public Set<Loan> getLoans() {return loans;}
}
