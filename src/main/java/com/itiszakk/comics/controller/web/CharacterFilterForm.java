package com.itiszakk.comics.controller.web;

import com.itiszakk.comics.dto.Character;
import lombok.Data;

import java.util.List;

@Data
public class CharacterFilterForm {

    private String sortField = Character.Fields.id;

    private List<String> alignments;
    private List<String> publishers;

    private String nameStartsWith;
}