package com.itiszakk.comics.service;

import com.itiszakk.comics.domain.Character;
import com.itiszakk.comics.repository.SearchCriteria;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    Optional<Character> getById(int id);
    Optional<Character> getByCharacterNameAndRealName(String characterName, String realName);
    List<Character> getAll();
    List<Character> getAllByCriteriaList(List<SearchCriteria> criteriaList);
    Character save(Character character);
    void deleteById(int id);
    void deleteAll();
}
