package org.itiszakk.comics.character.util;

import org.itiszakk.comics.character.CharacterAlignment;
import org.itiszakk.comics.character.converter.CharacterAlignmentConverter;
import org.itiszakk.comics.exception.CharacterConverterException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class CharacterAlignmentAttributeConverter implements AttributeConverter<CharacterAlignment, String> {

    private CharacterAlignmentConverter characterAlignmentConverter;

    @Override
    public String convertToDatabaseColumn(CharacterAlignment alignment) {
        return (alignment == null) ? null : alignment.getType();
    }

    @Override
    public CharacterAlignment convertToEntityAttribute(String type) {
        return Optional.ofNullable(CharacterAlignment.from(type))
                .orElseThrow(() -> new CharacterConverterException(CharacterAlignmentAttributeConverter.class, type));
    }
}
