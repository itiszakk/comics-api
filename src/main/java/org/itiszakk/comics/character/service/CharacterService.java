package org.itiszakk.comics.character.service;

import org.itiszakk.comics.character.context.GetCharacterContext;
import org.itiszakk.comics.character.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    CharacterDTO get(int id);
    List<CharacterDTO> get(GetCharacterContext ctx);
    CharacterDTO save(CharacterDTO characterDTO);
    CharacterDTO update(CharacterDTO characterDTO);
    void delete(int id);
    void deleteAll();
}