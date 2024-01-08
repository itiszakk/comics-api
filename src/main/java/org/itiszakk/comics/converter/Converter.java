package org.itiszakk.comics.converter;

public interface Converter<S, T> {
    T convert(S source);
    Converter<T, S> reverse();
}