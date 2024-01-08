package org.itiszakk.comics.character.converter;

import org.itiszakk.comics.character.Character;
import org.itiszakk.comics.character.dto.CharacterDTO;

public class CharacterConverter {

    public static CharacterDTO convert(Character source) {
        if (source == null) {
            return null;
        }

        return CharacterDTO.builder()
                .id(source.getId())
                .characterName(source.getCharacterName())
                .realName(source.getRealName())
                .alignment(CharacterAlignmentConverter.convert(source.getAlignment()))
                .publisher(ComicsPublisherConverter.convert(source.getPublisher()))
                .description(source.getDescription())
                .imageUrl(source.getImageUrl())
                .build();
    }

    public static Character convert(CharacterDTO source) {
        if (source == null) {
            return null;
        }

        return Character.builder()
                .id(source.getId())
                .characterName(source.getCharacterName())
                .realName(source.getRealName())
                .alignment(CharacterAlignmentConverter.convert(source.getAlignment()))
                .publisher(ComicsPublisherConverter.convert(source.getPublisher()))
                .description(source.getDescription())
                .imageUrl(source.getImageUrl())
                .build();
    }
}
