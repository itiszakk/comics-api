package com.itiszakk.comics.controller;

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
