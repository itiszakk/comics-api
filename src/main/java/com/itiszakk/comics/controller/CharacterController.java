package com.itiszakk.comics.controller;

import com.itiszakk.comics.domain.Character;
import com.itiszakk.comics.domain.CharacterAlignment;
import com.itiszakk.comics.domain.CharacterEntity;
import com.itiszakk.comics.domain.ComicsPublisher;
import com.itiszakk.comics.exception.*;
import com.itiszakk.comics.repository.SearchCriteria;
import com.itiszakk.comics.repository.SearchOperation;
import com.itiszakk.comics.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${url.character}")
public class CharacterController {
    private static final String ALIGNMENT_REQUEST_PARAMETER = "alignment";
    private static final String PUBLISHER_REQUEST_PARAMETER = "publisher";

    private static final String ALIGNMENT_ENTITY_FIELD = "alignment";
    private static final String PUBLISHER_ENTITY_FIELD = "publisher";
    private static final String CHARACTER_NAME_ENTITY_FIELD = "characterName";

    private final CharacterService service;

    @Autowired
    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Character getCharacterById(@PathVariable int id) {
        return getCharacterByIdOrThrowException(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Character> getAllCharacters(RequestParameters parameters) {
        CharacterAlignment alignment = checkParameterAndReturnCharacterAlignment(parameters.getAlignment());
        ComicsPublisher publisher = checkParameterAndReturnComicsPublisher(parameters.getPublisher());

        List<SearchCriteria> criteriaList = List.of(
                new SearchCriteria(ALIGNMENT_ENTITY_FIELD, SearchOperation.EQUAL, alignment),
                new SearchCriteria(PUBLISHER_ENTITY_FIELD, SearchOperation.EQUAL, publisher),
                new SearchCriteria(CHARACTER_NAME_ENTITY_FIELD, SearchOperation.LIKE, parameters.getStartsWith())
        );

        return (parameters.getSortBy() == null)
                ? service.getAllByCriteriaList(criteriaList)
                : service.getAllByCriteriaList(criteriaList, getSortOrThrowException(parameters.getSortBy()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Character saveCharacter(@RequestBody Character character) {
        checkCharacterBeforeSave(character);
        return service.save(character);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Character updateCharacter(@RequestBody Character character) {
        checkCharacterBeforeUpdate(character);
        return service.save(character);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllCharacters() {
        service.deleteAll();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCharacterById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    private CharacterAlignment checkParameterAndReturnCharacterAlignment(String alignmentType) {
        CharacterAlignment alignment = CharacterAlignment.getByType(alignmentType);

        if (alignment == null && alignmentType != null && alignmentType.length() > 0) {
            throw new RequestParameterValueException(ALIGNMENT_REQUEST_PARAMETER, alignmentType);
        }

        return alignment;
    }

    private ComicsPublisher checkParameterAndReturnComicsPublisher(String publisherName) {
        ComicsPublisher publisher = ComicsPublisher.getByName(publisherName);

        if (publisher == null && publisherName != null && publisherName.length() > 0) {
            throw new RequestParameterValueException(PUBLISHER_REQUEST_PARAMETER, publisherName);
        }

        return publisher;
    }

    private Character getCharacterByIdOrThrowException(int id) {
        return service.getById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    private Sort getSortOrThrowException(String sortField) {
        if (ClassTypeInformation.from(CharacterEntity.class).getProperty(sortField) == null) {
            throw new CharacterFieldReferenceException(sortField);
        }

        return Sort.by(sortField);
    }

    private void checkCharacterBeforeSave(Character character) {
        checkCharacterDTOFields(character, false);
        checkCharacterExistenceByUniqueNames(character.getCharacterName(), character.getRealName());
    }

    private void checkCharacterBeforeUpdate(Character updatedCharacter) {
        checkCharacterDTOFields(updatedCharacter, true);
        Character savedCharacter = getCharacterByIdOrThrowException(updatedCharacter.getId());

        boolean doNamesMatches = savedCharacter.getCharacterName().equals(updatedCharacter.getCharacterName())
                && savedCharacter.getRealName().equals(updatedCharacter.getRealName());

        if (!doNamesMatches) {
            checkCharacterExistenceByUniqueNames(updatedCharacter.getCharacterName(), updatedCharacter.getRealName());
        }
    }

    private void checkCharacterDTOFields(Character character, boolean checkId) {
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

    private void checkCharacterExistenceByUniqueNames(String characterName, String realName) {
        Optional<Character> optionalCharacter = service.getByCharacterNameAndRealName(characterName, realName);

        if (optionalCharacter.isPresent()) {
            throw (realName == null)
                    ? new CharacterAlreadyExistsException(characterName)
                    : new CharacterAlreadyExistsException(characterName, realName);
        }
    }
}