package edu.phystech.hw2;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

// Ссылки на реализацию для IntelliJ IDEA
import edu.phystech.hw2.FunctionalInterfaces.ToUpperCaseOperator;
import edu.phystech.hw2.FunctionalInterfaces.AbsMaxOperator;
import edu.phystech.hw2.FunctionalInterfaces.StringLengthMoreThan5;
import edu.phystech.hw2.FunctionalInterfaces.IsNumberASquareOfAnotherNumber;
import edu.phystech.hw2.FunctionalInterfaces.EvenNumberSupplier;


public class FunctionalInterfacesTest {

    @Test
    public void unaryOperatorTest() {
        var result = new ArrayList<>(List.of("abC", "edf"));
        result.replaceAll(new ToUpperCaseOperator());
        Assertions.assertEquals(List.of("ABC", "EDF"), result);
    }

    @Test
    public void binaryOperatorTest() {
        var result = Stream.of(2, 3, 1, -10).reduce(4, new AbsMaxOperator());
        Assertions.assertEquals(10, result);
    }

    @Test
    public void predicateTest() {
        Assertions.assertEquals(
                Stream.of("a", "bb", "ccc", "1234567", "aaaaaaaaa").filter(new StringLengthMoreThan5()).toList(),
                List.of("1234567", "aaaaaaaaa")
        );

        Assertions.assertEquals(
                Stream.of(1, 4, 5, 10, 16, 25).filter(new IsNumberASquareOfAnotherNumber()).toList(),
                List.of(1, 4, 16, 25)
        );
    }

    @Test
    public void supplierTest() {
        var evenNumberSupplier = new EvenNumberSupplier(0);
        Stream.of(0, 2, 4, 6, 8, 10).forEach(number -> Assertions.assertEquals(number, evenNumberSupplier.get()));

        var anotherSupplier = new EvenNumberSupplier(11);
        Stream.of(12, 14, 16, 18, 20, 22).forEach(number -> Assertions.assertEquals(number, anotherSupplier.get()));
    }

}
