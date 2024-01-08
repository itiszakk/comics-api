package org.itiszakk.comics.character.converter;

import org.itiszakk.comics.character.Character;
import org.itiszakk.comics.character.dto.CharacterDTO;
import org.itiszakk.comics.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CharacterConverter implements Converter<Character, CharacterDTO> {

    private final CharacterAlignmentConverter alignmentConverter;
    public final ComicsPublisherConverter publisherConverter;

    public CharacterConverter(CharacterAlignmentConverter alignmentConverter,
                              ComicsPublisherConverter publisherConverter) {
        this.alignmentConverter = alignmentConverter;
        this.publisherConverter = publisherConverter;
    }

    @Override
    public CharacterDTO convert(Character source) {
        if (source == null) {
            return null;
        }

        return CharacterDTO.builder()
                .id(source.getId())
                .characterName(source.getCharacterName())
                .realName(source.getRealName())
                .alignment(alignmentConverter.convert(source.getAlignment()))
                .publisher(publisherConverter.convert(source.getPublisher()))
                .description(source.getDescription())
                .imageUrl(source.getImageUrl())
                .build();
    }

    @Override
    public Converter<CharacterDTO, Character> reverse() {
        return new Converter<>() {
            @Override
            public Character convert(CharacterDTO source) {
                if (source == null) {
                    return null;
                }

                return Character.builder()
                        .id(source.getId())
                        .characterName(source.getCharacterName())
                        .realName(source.getRealName())
                        .alignment(alignmentConverter.reverse().convert(source.getAlignment()))
                        .publisher(publisherConverter.reverse().convert(source.getPublisher()))
                        .description(source.getDescription())
                        .imageUrl(source.getImageUrl())
                        .build();
            }

            @Override
            public Converter<Character, CharacterDTO> reverse() {
                return CharacterConverter.this;
            }
        };
    }
}