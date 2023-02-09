package com.epam.mjc.nio;

public class CustomReadException extends RuntimeException {
    public CustomReadException(String message) {
        super(message);
    }
}