package com.alimentationAkonkwa.HeadFirst.exceptionHandler;
public class ProductAlreadyExistException extends RuntimeException {
    public ProductAlreadyExistException(String message) {
        super(message);
    }

    public ProductAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}