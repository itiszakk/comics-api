package com.itiszakk.comics.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchCriteria {
    private final String key;
    private final SearchOperation operation;
    private final Object value;
}
