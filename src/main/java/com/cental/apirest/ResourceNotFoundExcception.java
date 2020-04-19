package com.cental.apirest;

public class ResourceNotFoundExcception extends RuntimeException {

    private static final long serialVersionUID = 7992904489502842099L;

    public ResourceNotFoundExcception(String message) {
        this(message, null);
    }

    public ResourceNotFoundExcception(String message, Throwable cause) {
        super(message, cause);
    }
}