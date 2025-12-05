package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ValidatorTest {

    Validator validator;

    @BeforeEach
    void initValidator() {
        validator = new Validator();
    }

    @Test
    void string() {
        assertInstanceOf(StringSchema.class, validator.string());
    }

    @Test
    void number() {
        assertInstanceOf(NumberSchema.class, validator.number());
    }

    @Test
    void map() {
        assertInstanceOf(MapSchema.class, validator.map());
    }
}
