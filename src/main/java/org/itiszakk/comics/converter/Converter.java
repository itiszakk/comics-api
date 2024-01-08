package org.itiszakk.comics.converter;

import java.util.function.Function;

public interface Converter<S, T> {
    T convert(S source);
    Converter<T, S> reverse();
}