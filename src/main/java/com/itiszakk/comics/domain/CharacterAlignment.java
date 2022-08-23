package com.itiszakk.comics.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum CharacterAlignment {
    HERO("hero"),
    ANTIHERO("antihero"),
    VILLAIN("villain");

    private final String type;

    CharacterAlignment(String type) {
        this.type = type;
    }

    public static CharacterAlignment getByType(String type) {
        return Arrays.stream(values())
                .filter(alignment -> alignment.getType().equals(type))
                .findFirst()
                .orElse(null);
    }
}