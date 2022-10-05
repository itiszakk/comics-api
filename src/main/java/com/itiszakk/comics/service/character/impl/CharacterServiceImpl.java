package com.itiszakk.comics.service.character.impl;

import com.itiszakk.comics.domain.entity.character.CharacterEntity;
import com.itiszakk.comics.domain.repository.Filter;
import com.itiszakk.comics.dto.Character;
import com.itiszakk.comics.domain.repository.character.CharacterRepository;
import com.itiszakk.comics.service.FilterMapper;
import com.itiszakk.comics.service.character.CharacterMapper;
import com.itiszakk.comics.service.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;
    private final CharacterMapper characterMapper;
    private final FilterMapper filterMapper;

    @Autowired
    public CharacterServiceImpl(CharacterRepository repository, CharacterMapper characterMapper, FilterMapper filterMapper) {
        this.repository = repository;
        this.characterMapper = characterMapper;
        this.filterMapper = filterMapper;
    }

    @Override
    public Optional<Character> getById(int id) {
        return repository.findById(id).map(characterMapper::toDTO);
    }

    @Override
    public Optional<Character> getByCharacterNameAndRealName(String characterName, String realName) {
        return repository.findByCharacterNameAndRealName(characterName, realName).map(characterMapper::toDTO);
    }

    @Override
    public List<Character> getAll() {
        return repository.findAll().stream()
                .map(characterMapper::toDTO)
                .toList();
    }

    @Override
    public List<Character> getAll(Sort sort) {
        return repository.findAll(sort).stream()
                .map(characterMapper::toDTO)
                .toList();
    }

    @Override
    public List<Character> getAll(List<Filter> filterList) {
        return repository.findAll(getSpecification(filterList)).stream()
                .map(characterMapper::toDTO)
                .toList();
    }

    @Override
    public List<Character> getAll(List<Filter> filterList, Sort sort) {
        return repository.findAll(getSpecification(filterList), sort).stream()
                .map(characterMapper::toDTO)
                .toList();
    }

    @Transactional
    @Override
    public Character save(Character character) {
        return characterMapper.toDTO(repository.save(characterMapper.toEntity(character)));
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    private Specification<CharacterEntity> getSpecification(List<Filter> dtoFilterList) {
        List<Filter> entityFilterList = dtoFilterList.stream()
                .map(filterMapper::toEntity)
                .toList();

        Specification<CharacterEntity> specification = Specification.where(getSpecification((entityFilterList.get(0))));

        for (int i = 1; i < entityFilterList.size(); i++) {
            specification = specification.and(getSpecification(entityFilterList.get(i)));
        }

        return specification;
    }

    private Specification<CharacterEntity> getSpecification(Filter filter) {
        if (filter.hasNullFields()) {
            return null;
        }

        switch (filter.getOperation()) {
            case EQUAL -> {
                return (root, query, builder) ->
                        builder.equal(root.get(filter.getKey()), filter.getValue());
            }
            case LIKE -> {
                return (root, query, builder) ->
                        builder.like(root.get(filter.getKey()), "%" + filter.getValue() + "%");
            }
            case IN -> {
                return (root, query, builder) ->
                        builder.in(root.get(filter.getKey())).value(filter.getValue());
            }
        }

        return null;
    }
}