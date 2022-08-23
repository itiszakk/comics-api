package com.itiszakk.comics.service;

import com.itiszakk.comics.domain.Character;
import com.itiszakk.comics.domain.CharacterEntity;

import java.util.List;

public interface CharacterMapper {
    Character toDTO(CharacterEntity entity);
    List<Character> toDTOList(List<CharacterEntity> entityList);
    CharacterEntity toEntity(Character dto);
    List<CharacterEntity> toEntityList(List<Character> dtoList);
}
