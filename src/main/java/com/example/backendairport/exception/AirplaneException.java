package com.example.backendairport.exception;

public class AirplaneException extends Exception{

    public AirplaneException() {
        super();
    }

    public AirplaneException(String message) {
        super(message);
    }

    public AirplaneException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirplaneException(Throwable cause) {
        super(cause);
    }

    protected AirplaneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
