package com.itiszakk.comics.service;

import com.itiszakk.comics.domain.entity.character.CharacterAlignment;
import com.itiszakk.comics.domain.entity.character.CharacterEntity;
import com.itiszakk.comics.domain.entity.character.ComicsPublisher;
import com.itiszakk.comics.domain.repository.Filter;
import com.itiszakk.comics.dto.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterMapper {

    FilterMapper INSTANCE = Mappers.getMapper(FilterMapper.class);

    @Mapping(source = ".", target = "value", qualifiedByName = "toDTOValueMapper")
    @Mapping(source = ".", target = "values", qualifiedByName = "toDTOValuesMapper")
    Filter toDTO(Filter filter);

    @Mapping(source = ".", target = "value", qualifiedByName = "toEntityValueMapper")
    @Mapping(source = ".", target = "values", qualifiedByName = "toEntityValuesMapper")
    Filter toEntity(Filter filter);

    @Named("toDTOValueMapper")
    default Object toDTOValueMapper(Filter entityFilter) {
        if (entityFilter.getValue() == null) {
            return null;
        }

        if (entityFilter.getKey().equals(CharacterEntity.Fields.alignment)) {
            return ((CharacterAlignment)  entityFilter.getValue()).getType();
        }

        if (entityFilter.getKey().equals(CharacterEntity.Fields.publisher)) {
            return ((ComicsPublisher)  entityFilter.getValue()).getName();
        }

        return entityFilter.getValue();
    }

    @Named("toDTOValuesMapper")
    default List<Object> toDTOValuesMapper(Filter entityFilter) {
        if (entityFilter.getValues() == null || entityFilter.getValues().size() == 0) {
            return null;
        }

        if (entityFilter.getKey().equals(CharacterEntity.Fields.alignment)) {
            return entityFilter.getValues().stream()
                    .map(value -> ((CharacterAlignment) value).getType())
                    .map(value -> ((Object) value))
                    .toList();
        }

        if (entityFilter.getKey().equals(CharacterEntity.Fields.publisher)) {
            return entityFilter.getValues().stream()
                    .map(value -> ((ComicsPublisher) value).getName())
                    .map(value -> ((Object) value))
                    .toList();
        }

        return entityFilter.getValues();
    }

    @Named("toEntityValueMapper")
    default Object toEntityValueMapper(Filter dtoFilter) {
        if (dtoFilter.getValue() == null) {
            return null;
        }

        String value = dtoFilter.getValue().toString();

        if (dtoFilter.getKey().equals(Character.Fields.alignment)) {
            return CharacterAlignment.getByType(value);
        }

        if (dtoFilter.getKey().equals(Character.Fields.publisher)) {
            return ComicsPublisher.getByName(value);
        }

        return dtoFilter.getValue();
    }

    @Named("toEntityValuesMapper")
    default List<Object> toEntityValuesMapper(Filter dtoFilter) {
        if (dtoFilter.getValues() == null || dtoFilter.getValues().size() == 0) {
            return null;
        }

        if (dtoFilter.getKey().equals(Character.Fields.alignment)) {
             return dtoFilter.getValues().stream()
                    .map(Object::toString)
                    .map(CharacterAlignment::getByType)
                    .map(value -> ((Object) value))
                    .toList();
        }

        if (dtoFilter.getKey().equals(Character.Fields.publisher)) {
            return dtoFilter.getValues().stream()
                    .map(Object::toString)
                    .map(ComicsPublisher::getByName)
                    .map(value -> ((Object) value))
                    .toList();
        }

        return dtoFilter.getValues();
    }
}
