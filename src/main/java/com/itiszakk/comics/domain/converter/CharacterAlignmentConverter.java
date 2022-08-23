package com.itiszakk.comics.domain.converter;

import com.itiszakk.comics.domain.CharacterAlignment;
import com.itiszakk.comics.exception.EnumConverterException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class CharacterAlignmentConverter implements AttributeConverter<CharacterAlignment, String> {
    @Override
    public String convertToDatabaseColumn(CharacterAlignment alignment) {
        return alignment.getType();
    }

    @Override
    public CharacterAlignment convertToEntityAttribute(String type) {
        return Optional.ofNullable(CharacterAlignment.getByType(type))
                .orElseThrow(EnumConverterException::new);
    }
}
