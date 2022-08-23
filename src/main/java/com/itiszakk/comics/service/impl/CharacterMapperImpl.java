package com.itiszakk.comics.service.impl;

import com.itiszakk.comics.domain.Character;
import com.itiszakk.comics.domain.CharacterAlignment;
import com.itiszakk.comics.domain.CharacterEntity;
import com.itiszakk.comics.domain.ComicsPublisher;
import com.itiszakk.comics.service.CharacterMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public Character toDTO(CharacterEntity entity) {
        return Character.builder()
                .id(entity.getId())
                .characterName(entity.getCharacterName())
                .realName(entity.getRealName())
                .alignment(entity.getAlignment().getType())
                .publisher(entity.getPublisher().getName())
                .description(entity.getDescription())
                .imageURL(entity.getImageURL())
                .build();
    }

    @Override
    public List<Character> toDTOList(List<CharacterEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

    @Override
    public CharacterEntity toEntity(Character dto) {
        CharacterAlignment dtoAlignment = CharacterAlignment.getByType(dto.getAlignment());
        ComicsPublisher dtoPublisher = ComicsPublisher.getByName(dto.getPublisher());

        return CharacterEntity.builder()
                .id(dto.getId())
                .characterName(dto.getCharacterName())
                .realName(dto.getRealName())
                .alignment(dtoAlignment)
                .publisher(dtoPublisher)
                .description(dto.getDescription())
                .imageURL(dto.getImageURL())
                .build();
    }

    @Override
    public List<CharacterEntity> toEntityList(List<Character> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}
