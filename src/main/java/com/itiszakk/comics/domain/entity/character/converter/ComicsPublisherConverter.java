package com.itiszakk.comics.domain.entity.character.converter;

import com.itiszakk.comics.domain.entity.character.ComicsPublisher;
import com.itiszakk.comics.exception.CharacterConverterException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class ComicsPublisherConverter implements AttributeConverter<ComicsPublisher, String> {
    @Override
    public String convertToDatabaseColumn(ComicsPublisher publisher) {
        return (publisher == null) ? null : publisher.getName();
    }

    @Override
    public ComicsPublisher convertToEntityAttribute(String name) {
        return Optional.ofNullable(ComicsPublisher.getByName(name))
                .orElseThrow(() -> new CharacterConverterException(ComicsPublisher.class, name));
    }
}
