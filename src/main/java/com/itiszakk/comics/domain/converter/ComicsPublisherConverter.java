package com.itiszakk.comics.domain.converter;

import com.itiszakk.comics.domain.ComicsPublisher;
import com.itiszakk.comics.exception.ConverterException;

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
                .orElseThrow(() -> new ConverterException(ComicsPublisher.class, name));
    }
}
