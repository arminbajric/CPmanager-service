package com.cpmanager.service.commonModels;

public class UniqueStatus {
    int http_status;
    boolean email;
    boolean password;
    String token;

    public UniqueStatus(int http_status, boolean email, boolean password, String token) {
        this.http_status = http_status;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public UniqueStatus(int http_status, boolean email, boolean password) {
        this.http_status = http_status;
        this.email = email;
        this.password = password;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getHttp_status() {
        return http_status;
    }

    public void setHttp_status(int http_status) {
        this.http_status = http_status;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }
}
