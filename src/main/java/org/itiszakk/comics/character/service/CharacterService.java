package org.itiszakk.comics.character.service;

import org.itiszakk.comics.character.context.GetCharacterContext;
import org.itiszakk.comics.character.dto.CharacterDTO;
import org.itiszakk.comics.character.dto.RequestParameters;
import org.itiszakk.comics.filter.Filter;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    CharacterDTO get(int id);
    List<CharacterDTO> get(GetCharacterContext ctx);
    CharacterDTO save(CharacterDTO characterDTO);
    CharacterDTO update(CharacterDTO characterDTO);
    void delete(int id);
    void deleteAll();
}
