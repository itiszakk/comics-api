package com.itiszakk.comics.repository;

import com.itiszakk.comics.domain.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CharacterRepository
        extends JpaRepository<CharacterEntity, Integer>, JpaSpecificationExecutor<CharacterEntity> {
    Optional<CharacterEntity> findByCharacterNameAndRealName(String characterName, String realName);

}