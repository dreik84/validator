package org.example;

public class StringSchema {

    private boolean required = false;
    private int minLength = 0;
    private String contains = "";

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

        if (required) {
            if (value == null || value.isEmpty()) {
                return false;
            }
        }

        if (minLength > 0) {
            if (value == null || value.length() < minLength) {
                return false;
            }
        }

        if (!contains.isEmpty()) {
            if (value == null || !value.contains(contains)) {
                return false;
            }
        }

        return true;
    }
}
