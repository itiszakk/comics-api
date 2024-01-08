package org.itiszakk.comics.character.util;

import org.itiszakk.comics.character.ComicsPublisher;
import org.itiszakk.comics.exception.CharacterConverterException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class ComicsPublisherAttributeConverter implements AttributeConverter<ComicsPublisher, String> {
    @Override
    public String convertToDatabaseColumn(ComicsPublisher publisher) {
        return (publisher == null) ? null : publisher.getName();
    }

    @Override
    public ComicsPublisher convertToEntityAttribute(String name) {
        return Optional.ofNullable(ComicsPublisher.from(name))
                .orElseThrow(() -> new CharacterConverterException(ComicsPublisher.class, name));
    }
}
