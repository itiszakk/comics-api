package org.itiszakk.comics.character.repository;

import org.itiszakk.comics.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CharacterRepository
        extends JpaRepository<Character, Integer>, JpaSpecificationExecutor<Character> {
    Optional<Character> findByCharacterNameAndRealName(String characterName, String realName);
}