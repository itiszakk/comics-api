package com.itiszakk.comics.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum ComicsPublisher {
    DC_COMICS("dc"),
    MARVEL_COMICS("marvel");

    private final String name;

    ComicsPublisher(String name) {
        this.name = name;
    }

    public static ComicsPublisher getByName(String name) {
        return Arrays.stream(values())
                .filter(publisher -> publisher.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}