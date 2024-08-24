package com.makershark.supplier.api.exception;

public class InvalidPageNumberException extends RuntimeException {

    public InvalidPageNumberException(String message) {
        super(message);
    }
}