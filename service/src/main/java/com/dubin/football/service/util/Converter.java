package com.dubin.football.service.util;

@FunctionalInterface
public interface Converter<T, R> {

    R convert(T object);
}
