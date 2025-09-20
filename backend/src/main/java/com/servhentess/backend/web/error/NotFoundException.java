package com.servhentess.backend.web.error;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) { super(msg); }
}
