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

        schema.sizeof(2);

        assertFalse(schema.isValid(data));

        data.put("key2", "value2");

        assertTrue(schema.isValid(data));
    }

    @Test
    void combiner() {
        MapSchema schema = new MapSchema();
        schema.sizeof(4).required().sizeof(2);
        Map<String, String> data = Map.of("key1", "value1", "key2", "value2");

        assertTrue(schema.isValid(data));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(new HashMap<>()));
    }

    @Test
    void shape() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");

        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);

        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "John");
        human3.put("lastName", "B");

        assertFalse(schema.isValid(human3));
    }
}