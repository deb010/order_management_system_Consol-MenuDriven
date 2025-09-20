package com.example.exception;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
