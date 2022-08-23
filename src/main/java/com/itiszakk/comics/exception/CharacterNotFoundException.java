package com.itiszakk.comics.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(int id) {
        super(String.format("Character with id '%d' not found", id));
    }
}
