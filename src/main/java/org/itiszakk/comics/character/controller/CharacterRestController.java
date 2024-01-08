package org.itiszakk.comics.character.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.itiszakk.comics.character.Character;
import org.itiszakk.comics.character.CharacterAlignment;
import org.itiszakk.comics.character.ComicsPublisher;
import org.itiszakk.comics.character.context.GetCharacterContext;
import org.itiszakk.comics.character.context.GetCharacterContext.GetCharacterContextBuilder;
import org.itiszakk.comics.character.dto.CharacterDTO;
import org.itiszakk.comics.character.service.CharacterService;
import org.itiszakk.comics.exception.CharacterFieldReferenceException;
import org.itiszakk.comics.filter.Filter;
import org.itiszakk.comics.filter.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.TypeInformation;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(CharacterRestControllerConstants.CHARACTERS_PATH)
public class CharacterRestController {

    private final CharacterService characterService;

    @Autowired
    public CharacterRestController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Operation(summary = "Get character by id")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO getCharacterById(@PathVariable int id) {
        return characterService.get(id);
    }

    @Operation(summary = "Get characters by parameters")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterDTO> getCharacterByParameters(@Nullable @RequestParam CharacterAlignment alignment,
                                                       @Nullable @RequestParam ComicsPublisher publisher,
                                                       @Nullable @RequestParam String startsWith,
                                                       @Nullable @RequestParam String sortBy) {
        GetCharacterContext ctx = buildContext(alignment, publisher, startsWith, sortBy);
        return characterService.get(ctx);
    }

    @Operation(summary = "Save new character")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterDTO saveCharacter(@RequestBody CharacterDTO characterDTO) {
        return characterService.save(characterDTO);
    }

    @Operation(summary = "Update existing character")
    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO updateCharacter(@RequestBody CharacterDTO characterDTO) {
        return characterService.update(characterDTO);
    }

    @Operation(summary = "Delete all characters")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllCharacters() {
        characterService.deleteAll();
    }

    @Operation(summary = "Delete character by id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCharacterById(@PathVariable int id) {
        characterService.delete(id);
    }

    private GetCharacterContext buildContext(CharacterAlignment alignment,
                                             ComicsPublisher publisher,
                                             String startsWith,
                                             String sortBy) {
        GetCharacterContextBuilder builder = GetCharacterContext.builder();

        if (sortBy != null) {
            builder.sort(buildSort(sortBy));
        }

        builder.filters(buildFilters(alignment, publisher, startsWith));

        return builder.build();
    }

    private Sort buildSort(String sortBy) {
        if (TypeInformation.of(Character.class).getProperty(sortBy) == null) {
            throw new CharacterFieldReferenceException(sortBy);
        }

        return Sort.by(sortBy);
    }

    private List<Filter> buildFilters(CharacterAlignment alignment, ComicsPublisher publisher, String startsWith) {
        List<Filter> filters = new ArrayList<>();

        Filter alignmentFilter = getAlignmentFilter(alignment);

        if (alignmentFilter != null) {
            filters.add(alignmentFilter);
        }

        Filter publisherFilter = getPublisherFilter(publisher);

        if (publisherFilter != null) {
            filters.add(publisherFilter);
        }

        Filter startsWithFilter = getStartsWithFilter(startsWith);

        if (startsWithFilter != null) {
            filters.add(startsWithFilter);
        }

        return filters;
    }

    private Filter getAlignmentFilter(CharacterAlignment alignment) {
        if (Objects.isNull(alignment)) {
            return null;
        }

        return Filter.builder()
                .key(CharacterDTO.Fields.alignment)
                .operation(SearchOperation.EQUAL)
                .value(alignment)
                .build();
    }

    private Filter getPublisherFilter(ComicsPublisher publisher) {
        if (Objects.isNull(publisher)) {
            return null;
        }

        return Filter.builder()
                .key(CharacterDTO.Fields.publisher)
                .operation(SearchOperation.EQUAL)
                .value(publisher)
                .build();
    }

    private Filter getStartsWithFilter(String startsWith) {
        if (StringUtils.isEmpty(startsWith)) {
            return null;
        }

        return Filter.builder()
                .key(CharacterDTO.Fields.characterName)
                .operation(SearchOperation.LIKE)
                .value(startsWith)
                .build();
    }
}