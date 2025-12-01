package org.example;

public abstract class BaseSchema<T> {

    public abstract boolean isValid(T value);
}
