package edu.phystech.hw2.IntHolder;

import java.util.Objects;

public class IntHolder {

    private int value;

    // Конструктор
    public IntHolder(int value) {
        this.value = value;
    }

    // Статический метод для создания IntHolder из int
    public static IntHolder valueOf(int x) {
        return new IntHolder(x);
    }

    // Геттер
    public int getValue() {
        return value;
    }

    // Метод для обмена значениями
    public void swap(IntHolder other) {
        int temp = this.value;
        this.value = other.value;
        other.value = temp;
    }

    // Арифметические операции
    public IntHolder plus(IntHolder rhv) {
        return new IntHolder(this.value + rhv.value);
    }

    public IntHolder minus(IntHolder rhv) {
        return new IntHolder(this.value - rhv.value);
    }

    public IntHolder times(IntHolder rhv) {
        return new IntHolder(this.value * rhv.value);
    }

    public IntHolder div(IntHolder rhv) {
        if (rhv.value == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new IntHolder(this.value / rhv.value);
    }

    // Переопределение equals и hashCode для корректного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntHolder intHolder = (IntHolder) o;
        return this.value == intHolder.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    // Для удобного отображения в отладке
    @Override
    public String toString() {
        return "IntHolder{" + "value=" + this.value + '}';
    }
}