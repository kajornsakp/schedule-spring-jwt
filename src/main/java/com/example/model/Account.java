package com.example.model;

import org.springframework.data.annotation.Id;

/**
 * Created by kajornsak on 4/23/2017 AD.
 */
public class Account {
    @Id
    String id;
    String username;
    String password;
    String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
