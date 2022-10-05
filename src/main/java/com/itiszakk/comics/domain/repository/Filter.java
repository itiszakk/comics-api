package com.itiszakk.comics.domain.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Filter {
    private final String key;
    private final SearchOperation operation;
    private final Object value;

    public boolean hasNullFields() {
        return (key == null || operation == null || value == null);
    }
}
