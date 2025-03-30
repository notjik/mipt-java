package edu.phystech.hw2.FunctionalInterfaces;

import java.util.function.Predicate;

public class StringLengthMoreThan5 implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return s != null && s.length() > 5;
    }
}