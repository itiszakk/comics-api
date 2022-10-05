package com.itiszakk.comics.domain.entity.character;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

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

    public static List<String> getNameList() {
        return Arrays.stream(values()).map(value -> value.name).toList();
    }
}