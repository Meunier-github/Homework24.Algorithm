package org.example;

public class StringsListIsFUllException extends RuntimeException{
    public StringsListIsFUllException() {
    }

    public StringsListIsFUllException(String message) {
        super(message);
    }

    public StringsListIsFUllException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringsListIsFUllException(Throwable cause) {
        super(cause);
    }

    public StringsListIsFUllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
