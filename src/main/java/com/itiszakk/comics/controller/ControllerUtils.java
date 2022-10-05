package com.itiszakk.comics.controller;

import com.itiszakk.comics.controller.rest.RequestParameters;
import com.itiszakk.comics.domain.entity.character.CharacterAlignment;
import com.itiszakk.comics.domain.entity.character.CharacterEntity;
import com.itiszakk.comics.domain.entity.character.ComicsPublisher;
import com.itiszakk.comics.dto.Character;
import com.itiszakk.comics.exception.CharacterDTOException;
import com.itiszakk.comics.exception.CharacterFieldReferenceException;
import com.itiszakk.comics.exception.RequestParameterValueException;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.ClassTypeInformation;

import java.util.Optional;

public class ControllerUtils {

    public static Optional<Sort> getSortOrThrowException(String sortField) {
        if (sortField == null) {
            return Optional.empty();
        }

        if (ClassTypeInformation.from(CharacterEntity.class).getProperty(sortField) == null) {
            throw new CharacterFieldReferenceException(sortField);
        }

        return Optional.of(Sort.by(sortField));
    }

    public static void checkRequestParameters(RequestParameters parameters) {
        CharacterAlignment alignment = CharacterAlignment.getByType(parameters.getAlignment());
        ComicsPublisher publisher = ComicsPublisher.getByName(parameters.getPublisher());

        if (alignment == null && parameters.getAlignment() != null && parameters.getAlignment().length() > 0) {
            throw new RequestParameterValueException(Character.Fields.alignment, parameters.getAlignment());
        }

        if (publisher == null && parameters.getPublisher() != null && parameters.getPublisher().length() > 0) {
            throw new RequestParameterValueException(Character.Fields.alignment, parameters.getPublisher());
        }
    }

    public static void checkCharacterDTO(Character character, boolean checkId) {
        if (checkId && character.getId() == 0) {
            throw new CharacterDTOException("Character id is missing");
        }

        if (character.getCharacterName() == null || character.getCharacterName().length() == 0) {
            throw new CharacterDTOException("Character name is missing");
        }

        if (character.getRealName() != null && character.getRealName().length() == 0) {
            throw new CharacterDTOException("Character real name is missing");
        }

        if (character.getAlignment() == null) {
            throw new CharacterDTOException("Character alignment is missing");
        } else {
            if (CharacterAlignment.getByType(character.getAlignment()) == null) {
                throw new CharacterDTOException("Character alignment is unsupported");
            }
        }

        if (character.getPublisher() == null) {
            throw new CharacterDTOException("Comics publisher is missing");
        } else {
            if (ComicsPublisher.getByName(character.getPublisher()) == null) {
                throw new CharacterDTOException("Comics publisher is unsupported");
            }
        }
    }
}
