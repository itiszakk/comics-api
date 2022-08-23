package com.itiszakk.comics.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Character {
    private int id;
    private String characterName;
    private String realName;
    /* A string representation of CharacterAlignment enum */
    private String alignment;
    /* A string representation of ComicsPublisher enum */
    private String publisher;
    private String description;
    private String imageURL;
}
