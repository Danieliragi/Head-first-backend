package com.alimentationAkonkwa.HeadFirst.exceptionHandler;

public class CategoryAlreadyExistException extends RuntimeException {
    public CategoryAlreadyExistException(String message) {
        super(message);
    }

    public CategoryAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
