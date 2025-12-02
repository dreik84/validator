package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {

    @Test
    void required() {
        MapSchema schema = new MapSchema();

        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid(new HashMap<>()));
        assertFalse(schema.isValid(null));
    }

    @Test
    void sizeOf() {
        MapSchema schema = new MapSchema();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertTrue(schema.isValid(data));

        schema.sizeOf(2);

        assertFalse(schema.isValid(data));

        data.put("key2", "value2");

        assertTrue(schema.isValid(data));
    }

    @Test
    void combiner() {
        MapSchema schema = new MapSchema();
        schema.sizeOf(4).required().sizeOf(2);
        Map<String, String> data = Map.of("key1", "value1", "key2", "value2");

        assertTrue(schema.isValid(data));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(new HashMap<>()));
    }
}