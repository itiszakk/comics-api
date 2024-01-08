package org.itiszakk.comics.character.util;

import org.itiszakk.comics.character.CharacterAlignment;
import org.itiszakk.comics.character.converter.CharacterAlignmentConverter;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Component
@Converter(autoApply = true)
public class CharacterAlignmentAttributeConverter implements AttributeConverter<CharacterAlignment, String> {

    private final CharacterAlignmentConverter alignmentConverter;

    public CharacterAlignmentAttributeConverter(CharacterAlignmentConverter alignmentConverter) {
        this.alignmentConverter = alignmentConverter;
    }

    @Override
    public String convertToDatabaseColumn(CharacterAlignment alignment) {
        return alignmentConverter.convert(alignment);
    }

    @Override
    public CharacterAlignment convertToEntityAttribute(String type) {
        return alignmentConverter.reverse().convert(type);
    }
}