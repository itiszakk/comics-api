package org.itiszakk.comics.character.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.itiszakk.comics.character.ComicsPublisher;

@Converter(autoApply = true)
public class ComicsPublisherAttributeConverter implements AttributeConverter<ComicsPublisher, String> {

    @Override
    public String convertToDatabaseColumn(ComicsPublisher publisher) {
        return publisher.name().toLowerCase();
    }

    @Override
    public ComicsPublisher convertToEntityAttribute(String name) {
        return ComicsPublisher.valueOf(name.toUpperCase());
    }
}
