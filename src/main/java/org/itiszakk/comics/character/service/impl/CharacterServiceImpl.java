package org.itiszakk.comics.character.service.impl;

import org.itiszakk.comics.character.Character;
import org.itiszakk.comics.character.context.GetCharacterContext;
import org.itiszakk.comics.character.converter.CharacterConverter;
import org.itiszakk.comics.character.dto.CharacterDTO;
import org.itiszakk.comics.character.repository.CharacterRepository;
import org.itiszakk.comics.character.service.CharacterService;
import org.itiszakk.comics.exception.CharacterAlreadyExistsException;
import org.itiszakk.comics.exception.CharacterDTOException;
import org.itiszakk.comics.exception.CharacterNotFoundException;
import org.itiszakk.comics.filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;
    private final CharacterConverter converter;

    @Autowired
    public CharacterServiceImpl(CharacterRepository repository, CharacterConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public CharacterDTO get(int id) {
        return repository.findById(id)
                .map(converter::convert)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @Override
    public List<CharacterDTO> get(GetCharacterContext ctx) {
         return getByContext(ctx).stream()
                 .map(converter::convert)
                 .toList();
    }

    private List<Character> getByContext(GetCharacterContext ctx) {
        if (ctx.hasFilters()) {
            Specification<Character> specification = getSpecification(ctx.getFilters());

            if (ctx.hasSort()) {
                return repository.findAll(specification, ctx.getSort());
            }

            return repository.findAll(specification);
        }

        if (ctx.hasSort()) {
            return repository.findAll(ctx.getSort());
        }

        return repository.findAll();
    }

    @Transactional
    @Override
    public CharacterDTO save(CharacterDTO characterDTO) {
        checkCharacterBeforeSave(characterDTO);
        Character entity = converter.reverse().convert(characterDTO);
        return converter.convert(repository.save(entity));
    }

    @Transactional
    @Override
    public CharacterDTO update(CharacterDTO characterDTO) {
        checkCharacterBeforeUpdate(characterDTO);
        Character entity = converter.reverse().convert(characterDTO);
        return converter.convert(repository.save(entity));
    }

    @Transactional
    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    private void checkCharacterBeforeSave(CharacterDTO characterDTO) {
        checkCharacterDTO(characterDTO, false);
        checkCharacterExistenceByUniqueNames(characterDTO.getCharacterName(), characterDTO.getRealName());
    }

    private void checkCharacterBeforeUpdate(CharacterDTO updatedCharacterDTO) {
        checkCharacterDTO(updatedCharacterDTO, true);

        Character saved = repository.findById(updatedCharacterDTO.getId())
                .orElseThrow(() -> new CharacterNotFoundException(updatedCharacterDTO.getId()));

        boolean namesMatches = saved.getCharacterName().equals(updatedCharacterDTO.getCharacterName())
                && saved.getRealName().equals(updatedCharacterDTO.getRealName());

        if (!namesMatches) {
            checkCharacterExistenceByUniqueNames(updatedCharacterDTO.getCharacterName(), updatedCharacterDTO.getRealName());
        }
    }

    private void checkCharacterDTO(CharacterDTO characterDTO, boolean checkId) {
        if (checkId && characterDTO.getId() == 0) {
            throw new CharacterDTOException("Character id is missing");
        }

        if (characterDTO.getCharacterName() == null || characterDTO.getCharacterName().length() == 0) {
            throw new CharacterDTOException("Character name is missing");
        }

        if (characterDTO.getRealName() != null && characterDTO.getRealName().length() == 0) {
            throw new CharacterDTOException("Character real name is missing");
        }

        if (characterDTO.getAlignment() == null) {
            throw new CharacterDTOException("Character alignment is missing");
        }

        if (characterDTO.getPublisher() == null) {
            throw new CharacterDTOException("Comics publisher is missing");
        }
    }

    private void checkCharacterExistenceByUniqueNames(String characterName, String realName) {
        Optional<Character> optionalCharacter = repository.findByCharacterNameAndRealName(characterName, realName);

        if (optionalCharacter.isPresent()) {
            throw (realName == null)
                    ? new CharacterAlreadyExistsException(characterName)
                    : new CharacterAlreadyExistsException(characterName, realName);
        }
    }

    private Specification<Character> getSpecification(List<Filter> filters) {
        Specification<Character> specification = Specification.where(getSpecification((filters.get(0))));

        for (int i = 1; i < filters.size(); i++) {
            specification = specification.and(getSpecification(filters.get(i)));
        }

        return specification;
    }

    private Specification<Character> getSpecification(Filter entityFilter) {
        if (entityFilter.getKey() == null || entityFilter.getValue() == null) {
            return null;
        }

        switch (entityFilter.getOperation()) {
            case EQUAL -> {
                return (root, query, builder) ->
                        builder.equal(root.get(entityFilter.getKey()), entityFilter.getValue());
            }
            case LIKE -> {
                return (root, query, builder) ->
                        builder.like(
                                builder.lower(root.get(entityFilter.getKey())),
                                "%" + entityFilter.getValue().toString().toLowerCase() + "%");
            }
        }

        return null;
    }
}