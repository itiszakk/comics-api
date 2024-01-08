package org.itiszakk.comics.character.converter;

import org.itiszakk.comics.character.CharacterAlignment;

public class CharacterAlignmentConverter {

    public static CharacterAlignment convert(String source) {
        return CharacterAlignment.from(source);
    }

    public static String convert(CharacterAlignment source) {
        return source == null
                ? null
                : source.getType();
    }
}
