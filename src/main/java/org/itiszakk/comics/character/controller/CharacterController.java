package org.itiszakk.comics.character.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.itiszakk.comics.character.CharacterAlignment;
import org.itiszakk.comics.character.ComicsPublisher;
import org.itiszakk.comics.character.context.GetCharacterContext;
import org.itiszakk.comics.character.context.GetCharacterContext.GetCharacterContextBuilder;
import org.itiszakk.comics.character.dto.CharacterDTO;
import org.itiszakk.comics.character.dto.RequestParameters;
import org.itiszakk.comics.character.service.CharacterService;
import org.itiszakk.comics.exception.RequestParameterValueException;
import org.itiszakk.comics.filter.Filter;
import org.itiszakk.comics.filter.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO getCharacterById(@PathVariable int id) {
        return characterService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterDTO> getAllCharacters(RequestParameters parameters) {
        GetCharacterContext ctx = buildContext(parameters);
        return characterService.get(ctx);
    }

    private GetCharacterContext buildContext(RequestParameters parameters) {
        checkRequestParameters(parameters);

        GetCharacterContextBuilder builder = GetCharacterContext.builder();

        if (StringUtils.isNotEmpty(parameters.getSortBy())) {
            builder.sortBy(parameters.getSortBy());
        }

        List<Filter> filters = buildFilters(parameters);

        if (CollectionUtils.isNotEmpty(filters)) {
            builder.filters(filters);
        }

        return builder.build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterDTO saveCharacter(@RequestBody CharacterDTO characterDTO) {
        return characterService.save(characterDTO);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO updateCharacter(@RequestBody CharacterDTO characterDTO) {
        return characterService.update(characterDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllCharacters() {
        characterService.deleteAll();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCharacterById(@PathVariable int id) {
        characterService.delete(id);
    }

    private void checkRequestParameters(RequestParameters parameters) {
        CharacterAlignment alignment = CharacterAlignment.from(parameters.getAlignment());
        ComicsPublisher publisher = ComicsPublisher.from(parameters.getPublisher());

        if (alignment == null && parameters.getAlignment() != null && parameters.getAlignment().length() > 0) {
            throw new RequestParameterValueException(CharacterDTO.Fields.alignment, parameters.getAlignment());
        }

        if (publisher == null && parameters.getPublisher() != null && parameters.getPublisher().length() > 0) {
            throw new RequestParameterValueException(CharacterDTO.Fields.alignment, parameters.getPublisher());
        }
    }

    private List<Filter> buildFilters(RequestParameters parameters) {
        List<Filter> filters = new ArrayList<>();

        Filter alignmentFilter = getAlignmentFilter(parameters);

        if (alignmentFilter != null) {
            filters.add(alignmentFilter);
        }

        Filter publisherFilter = getPublisherFilter(parameters);

        if (publisherFilter != null) {
            filters.add(publisherFilter);
        }

        Filter startsWithFilter = getStartsWithFilter(parameters);

        if (startsWithFilter != null) {
            filters.add(startsWithFilter);
        }

        return filters;
    }

    private Filter getAlignmentFilter(RequestParameters parameters) {
        if (StringUtils.isEmpty(parameters.getAlignment())) {
            return null;
        }

        return Filter.builder()
                .key(CharacterDTO.Fields.alignment)
                .operation(SearchOperation.EQUAL)
                .value(parameters.getAlignment())
                .build();
    }

    private Filter getPublisherFilter(RequestParameters parameters) {
        if (StringUtils.isEmpty(parameters.getPublisher())) {
            return null;
        }

        return Filter.builder()
                .key(CharacterDTO.Fields.publisher)
                .operation(SearchOperation.EQUAL)
                .value(parameters.getPublisher())
                .build();
    }

    private Filter getStartsWithFilter(RequestParameters parameters) {
        if (StringUtils.isEmpty(parameters.getStartsWith())) {
            return null;
        }

        return Filter.builder()
                .key(CharacterDTO.Fields.characterName)
                .operation(SearchOperation.LIKE)
                .value(parameters.getStartsWith())
                .build();
    }
}