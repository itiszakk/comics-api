package org.itiszakk.comics.exception;

public class CharacterAlreadyExistsException extends RuntimeException {

    public CharacterAlreadyExistsException(String characterName) {
        super(String.format("Character '%s' already exists", characterName));
    }

    public CharacterAlreadyExistsException(String characterName, String realName) {
        super(String.format("Character '%s' ('%s') already exists", characterName, realName));
    }
}
