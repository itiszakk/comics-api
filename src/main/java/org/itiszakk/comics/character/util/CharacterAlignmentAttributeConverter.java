package org.itiszakk.comics.character.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.itiszakk.comics.character.CharacterAlignment;

@Converter(autoApply = true)
public class CharacterAlignmentAttributeConverter implements AttributeConverter<CharacterAlignment, String> {

    @Override
    public String convertToDatabaseColumn(CharacterAlignment alignment) {
        return alignment.name().toLowerCase();
    }

    @Override
    public CharacterAlignment convertToEntityAttribute(String type) {
        return CharacterAlignment.valueOf(type.toUpperCase());
    }
}