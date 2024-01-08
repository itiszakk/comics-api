package org.itiszakk.comics.character.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.itiszakk.comics.character.CharacterAlignment;
import org.itiszakk.comics.character.ComicsPublisher;

@Data
@Builder
@FieldNameConstants
public class CharacterDTO {
    private int id;
    private String characterName;
    private String realName;
    /**
     * String representation of {@link CharacterAlignment}
     */
    private String alignment;
    /**
     * String representation of {@link ComicsPublisher}
     */
    private String publisher;
    private String description;
    private String imageUrl;
}
