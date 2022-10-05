package com.itiszakk.comics.exception;

public class CharacterConverterException extends RuntimeException {

    public CharacterConverterException(Class<?> cls, String value) {
        super(String.format("'%s' cannot convert '%s'", cls.getName(), value));
    }
}
