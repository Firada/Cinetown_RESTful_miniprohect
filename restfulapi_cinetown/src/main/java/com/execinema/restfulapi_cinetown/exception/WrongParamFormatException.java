package com.execinema.restfulapi_cinetown.exception;

public class WrongParamFormatException extends RuntimeException{
    public WrongParamFormatException() {
    }

    public WrongParamFormatException(String message) {
        super(message);
    }

    public WrongParamFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongParamFormatException(Throwable cause) {
        super(cause);
    }

    public WrongParamFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
