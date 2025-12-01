package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    @Test
    void required() {
        StringSchema schema = new StringSchema();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid("test"));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    void minLength() {
        StringSchema schema = new StringSchema();
        schema.minLength(5);

        assertTrue(schema.isValid("hello"));
        assertFalse(schema.isValid("test"));
    }

    @Test
    void contains() {
        StringSchema schema = new StringSchema();
        schema.contains("ll");

        assertTrue(schema.isValid("hello"));
        assertFalse(schema.isValid("test"));
    }

    @Test
    void combiner() {
        StringSchema schema = new StringSchema();
        schema.required().minLength(4).contains("ll").minLength(5);

        assertTrue(schema.isValid("hello"));
        assertFalse(schema.isValid("test"));
    }
}