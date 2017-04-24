package com.example.model;

/**
 * Created by kajornsak on 4/24/2017 AD.
 */

public class JwtUser extends Account{
    private String userName;
    private String role;

    public JwtUser() {
    }

    public JwtUser(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
