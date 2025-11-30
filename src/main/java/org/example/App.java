package org.example;

public class App {
    public static void main(String[] args) {

        Validator validator = new Validator();
        StringSchema schema = validator.string();

        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));

        schema.required();

        System.out.println(schema.isValid(null));
        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid("what does the fox say"));
        System.out.println(schema.isValid("test"));

        System.out.println(schema.contains("wh").isValid("what does the fox say"));
        System.out.println(schema.contains("what").isValid("what does the fox say"));
        System.out.println(schema.contains("whatthe").isValid("what does the fox say"));

        System.out.println(schema.isValid("what does the fox say"));

        StringSchema schema1 = validator.string();
        System.out.println(schema1.minLength(10).minLength(4).isValid("Hexlet"));
    }
}
