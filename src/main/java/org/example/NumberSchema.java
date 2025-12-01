package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumberSchema extends BaseSchema<Integer> {

    private boolean required;
    private boolean positive;
    private Map<String, Integer> range;

    public NumberSchema() {
        required = false;
        positive = false;
        range = new HashMap<>();
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        positive = true;
        return this;
    }

    public NumberSchema range(int start, int end) {
        range.put("start", start);
        range.put("end", end);
        return this;
    }

    @Override
    public boolean isValid(Integer num) {

        if (required) {
            if (num == null) {
                return false;
            }
        }

        if (positive) {
            if (num <= 0) {
                return false;
            }
        }

        if (!range.isEmpty()) {
            if (num < range.get("start") || num > range.get("end")) {
                return false;
            }
        }

        return true;
    }
}
