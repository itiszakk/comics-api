package org.itiszakk.comics.character.converter;

import org.itiszakk.comics.character.CharacterAlignment;
import org.itiszakk.comics.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CharacterAlignmentConverter implements Converter<CharacterAlignment, String> {

    public String convert(CharacterAlignment source) {
        return source == null
                ? null
                : source.getType();
    }

    @Override
    public Converter<String, CharacterAlignment> reverse() {
        return new Converter<>() {
            @Override
            public CharacterAlignment convert(String source) {
                return CharacterAlignment.from(source);
            }

            @Override
            public Converter<CharacterAlignment, String> reverse() {
                return CharacterAlignmentConverter.this;
            }
        };
    }
}
