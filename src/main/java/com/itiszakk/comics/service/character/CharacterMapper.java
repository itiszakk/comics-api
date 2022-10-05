package com.itiszakk.comics.service.character;

import com.itiszakk.comics.dto.Character;
import com.itiszakk.comics.domain.entity.character.CharacterAlignment;
import com.itiszakk.comics.domain.entity.character.CharacterEntity;
import com.itiszakk.comics.domain.entity.character.ComicsPublisher;
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
