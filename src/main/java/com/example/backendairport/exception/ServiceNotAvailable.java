package com.example.backendairport.exception;

public class ServiceNotAvailable extends RuntimeException {
    public ServiceNotAvailable(String message) {
        super(message);
    }
}