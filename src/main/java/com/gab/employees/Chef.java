package com.gab.employees;

public interface Chef {
    default void cook(String food) {
        System.out.println("I am cooking " + food);
    }

    default String cleanUp() {
        return "Im done cleaning";
    }
}
