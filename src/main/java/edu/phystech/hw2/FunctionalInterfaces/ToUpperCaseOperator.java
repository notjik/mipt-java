package edu.phystech.hw2.FunctionalInterfaces;

import java.util.function.UnaryOperator;

public class ToUpperCaseOperator implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}