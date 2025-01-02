package org.example.service_2;

public class DataNotAvailableException extends RuntimeException {
    public DataNotAvailableException(String message) {
        super(message);
    }
}
