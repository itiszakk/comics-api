package org.itiszakk.comics.character.context;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.itiszakk.comics.filter.Filter;

import java.util.List;

@Builder
@Getter
public class GetCharacterContext {

    private final List<Filter> filters;
    private final String sortBy;

    public boolean hasFilters() {
        return CollectionUtils.isNotEmpty(filters);
    }

    public boolean hasSort() {
        return StringUtils.isNoneEmpty(sortBy);
    }
}