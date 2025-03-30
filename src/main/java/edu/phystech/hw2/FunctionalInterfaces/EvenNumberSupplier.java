package edu.phystech.hw2.FunctionalInterfaces;

import java.util.function.Supplier;

public class EvenNumberSupplier implements Supplier<Integer> {
    private int current;

    public EvenNumberSupplier(int from) {
        // Если from нечетное, начинаем с первого четного числа, большего from.
        if (from % 2 != 0) {
            this.current = from + 1;
        } else {
            this.current = from;
        }
    }

    @Override
    public Integer get() {
        int result = current;
        current += 2;
        return result;
    }
}