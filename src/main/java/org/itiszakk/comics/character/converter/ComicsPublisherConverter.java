package org.itiszakk.comics.character.converter;

import org.itiszakk.comics.character.ComicsPublisher;

public class ComicsPublisherConverter {

    public static ComicsPublisher convert(String source) {
        return ComicsPublisher.from(source);
    }

    public static String convert(ComicsPublisher source) {
        return source == null
                ? null
                : source.getName();
    }
}
