package com.example.backendairport.exception;

public class CabinCrewException extends Exception{

    public CabinCrewException() {
        super();
    }

    public CabinCrewException(String message) {
        super(message);
    }

    public CabinCrewException(String message, Throwable cause) {
        super(message, cause);
    }

    public CabinCrewException(Throwable cause) {
        super(cause);
    }

    protected CabinCrewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
