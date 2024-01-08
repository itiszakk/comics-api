package org.itiszakk.comics.character.util;

import org.itiszakk.comics.character.ComicsPublisher;
import org.itiszakk.comics.character.converter.ComicsPublisherConverter;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Component
@Converter(autoApply = true)
public class ComicsPublisherAttributeConverter implements AttributeConverter<ComicsPublisher, String> {

    private final ComicsPublisherConverter publisherConverter;

    public ComicsPublisherAttributeConverter(ComicsPublisherConverter publisherConverter) {
        this.publisherConverter = publisherConverter;
    }

    @Override
    public String convertToDatabaseColumn(ComicsPublisher publisher) {
        return publisherConverter.convert(publisher);
    }

    @Override
    public ComicsPublisher convertToEntityAttribute(String name) {
        return publisherConverter.reverse().convert(name);
    }
}
