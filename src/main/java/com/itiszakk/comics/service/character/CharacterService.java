package com.itiszakk.comics.service.character;

import com.itiszakk.comics.domain.repository.Filter;
import com.itiszakk.comics.dto.Character;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    Optional<Character> getById(int id);
    Optional<Character> getByCharacterNameAndRealName(String characterName, String realName);
    List<Character> getAll();
    List<Character> getAll(Sort sort);
    List<Character> getAll(List<Filter> filterList);
    List<Character> getAll(List<Filter> filterList, Sort sort);
    Character save(Character character);
    void deleteById(int id);
    void deleteAll();
}
