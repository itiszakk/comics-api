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
    private CharacterAlignment alignment;
    private ComicsPublisher publisher;
    private String description;
    private String imageUrl;
}
