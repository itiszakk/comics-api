package com.itiszakk.comics.controller.rest;

import com.itiszakk.comics.controller.ControllerUtils;
import com.itiszakk.comics.domain.entity.character.CharacterAlignment;
import com.itiszakk.comics.domain.entity.character.ComicsPublisher;
import com.itiszakk.comics.domain.repository.Filter;
import com.itiszakk.comics.domain.repository.SearchOperation;
import com.itiszakk.comics.dto.Character;
import com.itiszakk.comics.exception.CharacterAlreadyExistsException;
import com.itiszakk.comics.exception.CharacterNotFoundException;
import com.itiszakk.comics.service.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@PropertySource("classpath:controller-config.properties")
@RequestMapping("${controller.rest.character.domain}")
public class CharacterRestController {

    private final CharacterService service;

    @Autowired
    public CharacterRestController(CharacterService service) {
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
        ControllerUtils.checkRequestParameters(parameters);
        Optional<Sort> optionalSort = ControllerUtils.getSortOrThrowException(parameters.getSortBy());

        boolean requestWithoutSearchParameters = parameters.getAlignment() == null
                && parameters.getPublisher() == null
                && parameters.getStartsWith() == null;

        if (requestWithoutSearchParameters) {
            return (optionalSort.isEmpty())
                    ? service.getAll()
                    : service.getAll(optionalSort.get());
        }

        Filter alignmentFilter = Filter.builder()
                .key(Character.Fields.alignment)
                .operation(SearchOperation.EQUAL)
                .value(parameters.getAlignment())
                .build();

        Filter publisherFilter = Filter.builder()
                .key(Character.Fields.publisher)
                .operation(SearchOperation.EQUAL)
                .value(parameters.getPublisher())
                .build();

        Filter startsWithFilter = Filter.builder()
                .key(Character.Fields.characterName)
                .operation(SearchOperation.LIKE)
                .value(parameters.getStartsWith())
                .build();

        List<Filter> filterList = List.of(alignmentFilter, publisherFilter, startsWithFilter);

        return (optionalSort.isEmpty())
                ? service.getAll(filterList)
                : service.getAll(filterList, optionalSort.get());
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

    private Character getCharacterByIdOrThrowException(int id) {
        return service.getById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    private void checkCharacterBeforeSave(Character character) {
        ControllerUtils.checkCharacterDTO(character, false);
        checkCharacterExistenceByUniqueNames(character.getCharacterName(), character.getRealName());
    }

    private void checkCharacterBeforeUpdate(Character updatedCharacter) {
        ControllerUtils.checkCharacterDTO(updatedCharacter, true);
        Character savedCharacter = getCharacterByIdOrThrowException(updatedCharacter.getId());

        boolean doNamesMatches = savedCharacter.getCharacterName().equals(updatedCharacter.getCharacterName())
                && savedCharacter.getRealName().equals(updatedCharacter.getRealName());

        if (!doNamesMatches) {
            checkCharacterExistenceByUniqueNames(updatedCharacter.getCharacterName(), updatedCharacter.getRealName());
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