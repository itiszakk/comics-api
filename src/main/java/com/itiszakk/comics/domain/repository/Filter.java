package com.itiszakk.comics.domain.repository;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Filter {
    private final String key;
    private final SearchOperation operation;
    private final Object value;
    private final List<Object> values;
}
