package fr.najet.shape.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message;
    private final Throwable trowable;
    private HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(String message, Throwable trowable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.trowable = trowable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getTrowable() {
        return trowable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
