package com.itiszakk.comics.service.impl;

import com.itiszakk.comics.domain.Character;
import com.itiszakk.comics.repository.CharacterEntitySpecification;
import com.itiszakk.comics.repository.CharacterRepository;
import com.itiszakk.comics.repository.SearchCriteria;
import com.itiszakk.comics.service.CharacterMapper;
import com.itiszakk.comics.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;
    private final CharacterMapper mapper;

    @Autowired
    public CharacterServiceImpl(CharacterRepository repository, CharacterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Character> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public List<Character> getAll(Sort sort) {
        return mapper.toDTOList(repository.findAll(sort));
    }

    @Override
    public Optional<Character> getById(int id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public Optional<Character> getByCharacterNameAndRealName(String characterName, String realName) {
        return repository.findByCharacterNameAndRealName(characterName, realName).map(mapper::toDTO);
    }

    @Override
    public List<Character> getAllByCriteriaList(List<SearchCriteria> criteriaList) {
        return mapper.toDTOList(repository.findAll(new CharacterEntitySpecification(criteriaList)));
    }

    @Override
    public List<Character> getAllByCriteriaList(List<SearchCriteria> criteriaList, Sort sort) {
        return mapper.toDTOList(repository.findAll(new CharacterEntitySpecification(criteriaList), sort));
    }

    @Transactional
    @Override
    public Character save(Character character) {
        return mapper.toDTO(repository.save(mapper.toEntity(character)));
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
}