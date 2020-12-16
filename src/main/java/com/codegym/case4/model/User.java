package com.codegym.case4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotEmpty(message = "this field is required")
    private String name;
    @Email
    private String mail;
    private int age;
    @NotEmpty(message = "this field is required")
    private String phone;
    @NotEmpty(message = "this field is required")
    private String userName;
    @NotEmpty(message = "this field is required")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean isDeleted;


    public User() {
    }

}
