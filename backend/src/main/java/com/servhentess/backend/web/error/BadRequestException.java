package com.servhentess.backend.web.error;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) { super(msg); }
}
