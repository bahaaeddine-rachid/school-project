package com.example.demo.Security.ConfigUserDTO;

import lombok.Data;

@Data
public class LoginResponse {
    String accessToken;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
