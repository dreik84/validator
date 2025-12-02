package org.example;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    private boolean required;
    private int sizeOf;

    public MapSchema() {
        required = false;
        sizeOf = -1;
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeOf(int size) {
        sizeOf = size;
        return this;
    }

    @Override
    public boolean isValid(Map<?, ?> value) {

        if (required) {
            if (value == null) {
                return false;
            }
        }

        if (sizeOf > -1) {
            if (value.size() != sizeOf) {
                return false;
            }
        }

        return true;
    }
}
