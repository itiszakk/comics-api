package com.itiszakk.comics.exception;

public class CharacterFieldReferenceException extends RuntimeException {
    public CharacterFieldReferenceException(String fieldName) {
        super(String.format("Character field '%s' not found", fieldName));
    }
}
