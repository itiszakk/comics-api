package com.itiszakk.comics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
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
