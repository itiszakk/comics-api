package com.itiszakk.comics.service;

import com.itiszakk.comics.domain.Character;
import com.itiszakk.comics.domain.CharacterAlignment;
import com.itiszakk.comics.domain.CharacterEntity;
import com.itiszakk.comics.domain.ComicsPublisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    @Mapping(source = "alignment", target = "alignment", qualifiedByName = "getAlignmentType")
    @Mapping(source = "publisher", target = "publisher", qualifiedByName = "getPublisherName")
    Character toDTO(CharacterEntity entity);

    @Mapping(source = "alignment", target = "alignment", qualifiedByName = "getAlignmentByType")
    @Mapping(source = "publisher", target = "publisher", qualifiedByName = "getPublisherByName")
    CharacterEntity toEntity(Character dto);

    List<Character> toDTOList(List<CharacterEntity> entityList);
    List<CharacterEntity> toEntityList(List<Character> dtoList);

    @Named("getAlignmentType")
    static String getAlignmentType(CharacterAlignment alignment) {
        return alignment.getType();
    }

    @Named("getPublisherName")
    static String getPublisherName(ComicsPublisher publisher) {
        return publisher.getName();
    }

    @Named("getAlignmentByType")
    static CharacterAlignment getAlignmentByType(String type) {
        return CharacterAlignment.getByType(type);
    }

    @Named("getPublisherByName")
    static ComicsPublisher getPublisherByName(String name) {
        return ComicsPublisher.getByName(name);
    }
}
