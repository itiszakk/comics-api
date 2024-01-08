package org.itiszakk.comics.character.converter;

import org.itiszakk.comics.character.ComicsPublisher;
import org.itiszakk.comics.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ComicsPublisherConverter implements Converter<ComicsPublisher, String> {

    public String convert(ComicsPublisher source) {
        return source == null
                ? null
                : source.getName();
    }

    @Override
    public Converter<String, ComicsPublisher> reverse() {
        return new Converter<>() {
            @Override
            public ComicsPublisher convert(String source) {
                return ComicsPublisher.from(source);
            }

            @Override
            public Converter<ComicsPublisher, String> reverse() {
                return ComicsPublisherConverter.this;
            }
        };
    }
}
