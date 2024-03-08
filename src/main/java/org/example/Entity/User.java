package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false,unique = true,name = "username")
    String username;
    @Column(nullable = false,name = "password")
    String password;
    @Enumerated(EnumType.STRING)
    Roles role;

    public User(String username,String password,Roles role){
        this.username=username;
        this.password=password;
        this.role=role;
    }

    //user:12345m
    //admin:1234m
    //ayush:qwerty

}

