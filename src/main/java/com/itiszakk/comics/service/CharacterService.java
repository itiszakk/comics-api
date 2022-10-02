package com.itiszakk.comics.service;

import com.itiszakk.comics.domain.Character;
import com.itiszakk.comics.repository.SearchCriteria;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    Optional<Character> getById(int id);
    Optional<Character> getByCharacterNameAndRealName(String characterName, String realName);
    List<Character> getAll();
    List<Character> getAll(Sort sort);
    List<Character> getAllByCriteriaList(List<SearchCriteria> criteriaList);
    List<Character> getAllByCriteriaList(List<SearchCriteria> criteriaList, Sort sort);
    Character save(Character character);
    void deleteById(int id);
    void deleteAll();
}
