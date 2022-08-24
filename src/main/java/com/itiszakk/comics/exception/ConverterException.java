package com.itiszakk.comics.exception;

public class ConverterException extends RuntimeException {

    public ConverterException(Class<?> cls, String value) {
        super(String.format("'%s' cannot convert '%s'", cls.getName(), value));
    }
}
