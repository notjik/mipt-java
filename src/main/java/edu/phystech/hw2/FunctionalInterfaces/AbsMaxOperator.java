package edu.phystech.hw2.FunctionalInterfaces;

import java.util.function.BinaryOperator;

public class AbsMaxOperator implements BinaryOperator<Integer> {

    @Override
    public Integer apply(Integer a, Integer b) {
        return Math.max(Math.abs(a), Math.abs(b));
    }
}