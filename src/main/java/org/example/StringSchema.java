package org.example;

public class StringSchema {

    private boolean required;
    private int minLength;
    private String contains;

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int len) {
        minLength = len;
        return this;
    }

    public StringSchema contains(String sub) {
        contains = sub;
        return this;
    }

    public boolean isValid(String value) {
        return true;
    }
}
