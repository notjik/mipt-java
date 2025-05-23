package edu.phystech.hw2.FunctionalInterfaces;

import java.util.function.Predicate;

public class IsNumberASquareOfAnotherNumber implements Predicate<Integer> {

    @Override
    public boolean test(Integer n) {
        if (n == null || n < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}