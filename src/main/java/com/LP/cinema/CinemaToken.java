package com.LP.cinema;

import java.util.UUID;

public class CinemaToken {
    private String token;

    public CinemaToken() {
        this.token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
