package com.example.demo.Security.ConfigUserDTO;

import lombok.Data;

@Data
public class UserDTO {

    String username;
    String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
