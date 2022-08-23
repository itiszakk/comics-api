package com.itiszakk.comics.service.impl;

import com.itiszakk.comics.domain.Character;
import com.itiszakk.comics.domain.CharacterAlignment;
import com.itiszakk.comics.domain.CharacterEntity;
import com.itiszakk.comics.domain.ComicsPublisher;
import com.itiszakk.comics.service.CharacterMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CharacterMapperImplTest {

    private CharacterMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new CharacterMapperImpl();
    }

    @Test
    void shouldMapEntityToDTO() {
        CharacterEntity entity = CharacterEntity.builder()
                .id(1)
                .characterName("Batman")
                .realName("Bruce Wayne")
                .alignment(CharacterAlignment.HERO)
                .publisher(ComicsPublisher.DC_COMICS)
                .description("Description #1")
                .imageURL("Image #1")
                .build();

        Character dto = mapper.toDTO(entity);

        Assertions.assertThat(dto)
                .hasFieldOrPropertyWithValue("id", 1)
                .hasFieldOrPropertyWithValue("characterName", "Batman")
                .hasFieldOrPropertyWithValue("realName", "Bruce Wayne")
                .hasFieldOrPropertyWithValue("alignment", CharacterAlignment.HERO.getType())
                .hasFieldOrPropertyWithValue("publisher", ComicsPublisher.DC_COMICS.getName())
                .hasFieldOrPropertyWithValue("description", "Description #1")
                .hasFieldOrPropertyWithValue("imageURL", "Image #1");
    }

    @Test
    void shouldMapEntityListToDTOList() {
        CharacterEntity entity1 = CharacterEntity.builder()
                .id(1)
                .characterName("Batman")
                .realName("Bruce Wayne")
                .alignment(CharacterAlignment.HERO)
                .publisher(ComicsPublisher.DC_COMICS)
                .description("Description #1")
                .imageURL("Image #1")
                .build();

        CharacterEntity entity2 = CharacterEntity.builder()
                .id(2)
                .characterName("Iron Man")
                .realName("Tony Stark")
                .alignment(CharacterAlignment.HERO)
                .publisher(ComicsPublisher.MARVEL_COMICS)
                .description("Description #2")
                .imageURL("Image #2")
                .build();

        List<Character> dtoList = mapper.toDTOList(List.of(entity1, entity2));

        Assertions.assertThat(dtoList.get(0))
                .hasFieldOrPropertyWithValue("id", 1)
                .hasFieldOrPropertyWithValue("characterName", "Batman")
                .hasFieldOrPropertyWithValue("realName", "Bruce Wayne")
                .hasFieldOrPropertyWithValue("alignment", CharacterAlignment.HERO.getType())
                .hasFieldOrPropertyWithValue("publisher", ComicsPublisher.DC_COMICS.getName())
                .hasFieldOrPropertyWithValue("description", "Description #1")
                .hasFieldOrPropertyWithValue("imageURL", "Image #1");

        Assertions.assertThat(dtoList.get(1))
                .hasFieldOrPropertyWithValue("id", 2)
                .hasFieldOrPropertyWithValue("characterName", "Iron Man")
                .hasFieldOrPropertyWithValue("realName", "Tony Stark")
                .hasFieldOrPropertyWithValue("alignment", CharacterAlignment.HERO.getType())
                .hasFieldOrPropertyWithValue("publisher", ComicsPublisher.MARVEL_COMICS.getName())
                .hasFieldOrPropertyWithValue("description", "Description #2")
                .hasFieldOrPropertyWithValue("imageURL", "Image #2");
    }

    @Test
    void shouldMapDTOToEntity() {
        Character dto = Character.builder()
                .id(1)
                .characterName("Batman")
                .realName("Bruce Wayne")
                .alignment(CharacterAlignment.HERO.getType())
                .publisher(ComicsPublisher.DC_COMICS.getName())
                .description("Description #1")
                .imageURL("Image #1")
                .build();

        CharacterEntity entity = mapper.toEntity(dto);

        Assertions.assertThat(entity)
                .hasFieldOrPropertyWithValue("id", 1)
                .hasFieldOrPropertyWithValue("characterName", "Batman")
                .hasFieldOrPropertyWithValue("realName", "Bruce Wayne")
                .hasFieldOrPropertyWithValue("alignment", CharacterAlignment.HERO)
                .hasFieldOrPropertyWithValue("publisher", ComicsPublisher.DC_COMICS)
                .hasFieldOrPropertyWithValue("description", "Description #1")
                .hasFieldOrPropertyWithValue("imageURL", "Image #1");
    }

    @Test
    void shouldMapDTOListToEntityList() {
        Character dto1 = Character.builder()
                .id(1)
                .characterName("Batman")
                .realName("Bruce Wayne")
                .alignment(CharacterAlignment.HERO.getType())
                .publisher(ComicsPublisher.DC_COMICS.getName())
                .description("Description #1")
                .imageURL("Image #1")
                .build();

        Character dto2 = Character.builder()
                .id(2)
                .characterName("Iron Man")
                .realName("Tony Stark")
                .alignment(CharacterAlignment.HERO.getType())
                .publisher(ComicsPublisher.MARVEL_COMICS.getName())
                .description("Description #2")
                .imageURL("Image #2")
                .build();

        List<CharacterEntity> entityList = mapper.toEntityList(List.of(dto1, dto2));

        Assertions.assertThat(entityList.get(0))
                .hasFieldOrPropertyWithValue("id", 1)
                .hasFieldOrPropertyWithValue("characterName", "Batman")
                .hasFieldOrPropertyWithValue("realName", "Bruce Wayne")
                .hasFieldOrPropertyWithValue("alignment", CharacterAlignment.HERO)
                .hasFieldOrPropertyWithValue("publisher", ComicsPublisher.DC_COMICS)
                .hasFieldOrPropertyWithValue("description", "Description #1")
                .hasFieldOrPropertyWithValue("imageURL", "Image #1");

        Assertions.assertThat(entityList.get(1))
                .hasFieldOrPropertyWithValue("id", 2)
                .hasFieldOrPropertyWithValue("characterName", "Iron Man")
                .hasFieldOrPropertyWithValue("realName", "Tony Stark")
                .hasFieldOrPropertyWithValue("alignment", CharacterAlignment.HERO)
                .hasFieldOrPropertyWithValue("publisher", ComicsPublisher.MARVEL_COMICS)
                .hasFieldOrPropertyWithValue("description", "Description #2")
                .hasFieldOrPropertyWithValue("imageURL", "Image #2");
    }
}
