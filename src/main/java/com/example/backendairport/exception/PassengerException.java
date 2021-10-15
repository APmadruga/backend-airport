package com.example.backendairport.exception;

public class PassengerException extends Exception{

    public PassengerException() {
        super();
    }

    public PassengerException(String message) {
        super(message);
    }

    public PassengerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassengerException(Throwable cause) {
        super(cause);
    }

    protected PassengerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
