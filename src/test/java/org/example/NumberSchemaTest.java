package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {

    @Test
    void required() {
        NumberSchema schema = new NumberSchema();

        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(null));
    }

    @Test
    void positive() {
        NumberSchema schema = new NumberSchema();

        assertTrue(schema.isValid(-5));
        assertTrue(schema.isValid(null));

        schema.positive();

        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
        assertFalse(schema.isValid(0));
    }

    @Test
    void range() {
        NumberSchema schema = new NumberSchema();
        schema.range(2, 5);

        assertTrue(schema.isValid(2));
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(3));
        assertFalse(schema.isValid(1));
        assertFalse(schema.isValid(6));
    }

    @Test
    void combiner() {
        NumberSchema schema = new NumberSchema();
        schema.required().range(5, 12).positive().range(-6, 3);

        assertTrue(schema.isValid(1));
        assertTrue(schema.isValid(3));
        assertFalse(schema.isValid(-6));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(null));
    }
}