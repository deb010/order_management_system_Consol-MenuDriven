package com.example.exception;

public class DuplicateItemException extends Exception {
    public DuplicateItemException(String msg) {
        super(msg);
    }
}
