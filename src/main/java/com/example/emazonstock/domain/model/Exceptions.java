package com.example.emazonstock.domain.model;

public class Exceptions {

    private int status;
    private String message;
    private String time;

    // Constructor
    public Exceptions(Integer status, String message, String time) {
        this.status = status;
        this.message = message;
        this.time = time;
    }

    // Getters y Setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}
