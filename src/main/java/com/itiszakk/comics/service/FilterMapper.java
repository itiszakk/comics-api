package com.itiszakk.comics.service;

import com.itiszakk.comics.domain.entity.character.CharacterAlignment;
import com.itiszakk.comics.domain.entity.character.ComicsPublisher;
import com.itiszakk.comics.domain.repository.Filter;
import com.itiszakk.comics.dto.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FilterMapper {

    FilterMapper INSTANCE = Mappers.getMapper(FilterMapper.class);

    @Mapping(source = ".", target = "value", qualifiedByName = "toDTOValueMapper")
    Filter toDTO(Filter filter);

    @Mapping(source = ".", target = "value", qualifiedByName = "toEntityValueMapper")
    Filter toEntity(Filter filter);

    @Named("toEntityValueMapper")
    default Object toEntityValueMapper(Filter dtoFilter) {
        if (dtoFilter.getValue() == null)
            return dtoFilter.getValue();

        if (dtoFilter.getKey().equals(Character.Fields.alignment)) {
            return CharacterAlignment.getByType(dtoFilter.getValue().toString());
        }

        if (dtoFilter.getKey().equals(Character.Fields.publisher)) {
            return ComicsPublisher.getByName(dtoFilter.getValue().toString());
        }

        return dtoFilter.getValue();
    }

    @Named("toDTOValueMapper")
    default Object toDTOValueMapper(Filter entityFilter) {
        if (entityFilter.getValue() == null)
            return entityFilter.getValue();

        if (entityFilter.getValue().getClass() == CharacterAlignment.class) {
            return ((CharacterAlignment) entityFilter.getValue()).getType();
        }

        if (entityFilter.getValue().getClass() == ComicsPublisher.class) {
            return ((ComicsPublisher) entityFilter.getValue()).getName();
        }

        return entityFilter.getValue();
    }
}
