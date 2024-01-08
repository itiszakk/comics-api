package org.itiszakk.comics.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Filter {
    private final String key;
    private final SearchOperation operation;
    private final Object value;
}
