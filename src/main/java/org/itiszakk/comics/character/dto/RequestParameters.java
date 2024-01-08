package org.itiszakk.comics.character.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestParameters {
    private String alignment;
    private String publisher;
    private String startsWith;
    private String sortBy;
}
