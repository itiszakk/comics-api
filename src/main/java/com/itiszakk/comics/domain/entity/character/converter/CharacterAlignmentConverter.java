package com.itiszakk.comics.domain.entity.character.converter;

import com.itiszakk.comics.domain.entity.character.CharacterAlignment;
import com.itiszakk.comics.exception.CharacterConverterException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class CharacterAlignmentConverter implements AttributeConverter<CharacterAlignment, String> {

    @Override
    public String convertToDatabaseColumn(CharacterAlignment alignment) {
        return (alignment == null) ? null : alignment.getType();
    }

    @Override
    public CharacterAlignment convertToEntityAttribute(String type) {
        return Optional.ofNullable(CharacterAlignment.getByType(type))
                .orElseThrow(() -> new CharacterConverterException(CharacterAlignmentConverter.class, type));
    }
}
