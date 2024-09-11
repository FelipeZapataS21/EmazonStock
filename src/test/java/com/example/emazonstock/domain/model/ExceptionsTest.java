package com.example.emazonstock.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionsTest {

    @Test
    void getExceptionInfo() {

        Integer status = 400;
        String message = "Bad request";
        String time = "10:20:25";

        Exceptions exceptions = new Exceptions(status, message, time);

        assertEquals(status, exceptions.getStatus(), "Exception status should match.");
        assertEquals(message, exceptions.getMessage(), "Exception message should match.");
        assertEquals(time, exceptions.getTime(), "Exception time should match.");

    }

    @Test
    void setExceptionInfo() {

        Integer status = 400;
        Integer newStatus = 409;

        String message = "Bad request";
        String newMessage = "Conflict";

        String time = "10:20:25";
        String newTime = "20:20:45";

        Exceptions exceptions = new Exceptions(status, message, time);
        exceptions.setStatus(newStatus);
        exceptions.setMessage(newMessage);
        exceptions.setTime(newTime);

        assertEquals(newStatus, exceptions.getStatus(), "Exception status should match.");
        assertEquals(newMessage, exceptions.getMessage(), "Exception message should match.");
        assertEquals(newTime, exceptions.getTime(), "Exception time should match.");

    }

}