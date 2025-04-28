package edu.phystech.hw3;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.ArrayList;

public class Functional {

    public static <T, R> List<R> map(List<T> collection, Function<? super T, R> function) {
        List<R> result = new ArrayList<>(collection.size());
        for (T item : collection) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static <T, R> T reduce(List<T> collection, BinaryOperator<T> operator, T identity) {
        T result = identity;
        for (T item : collection) {
            result = operator.apply(result, item);
        }
        return result;
    }
}




