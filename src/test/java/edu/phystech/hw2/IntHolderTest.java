package edu.phystech.hw2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

// Ссылки на реализацию для IntelliJ IDEA
import edu.phystech.hw2.IntHolder.IntHolder;

public class IntHolderTest {

    @Test
    public void swapWorks() {
        IntHolder left = IntHolder.valueOf(10);
        IntHolder right = IntHolder.valueOf(12);

        left.swap(right);

        Assertions.assertEquals(12, left.getValue());
        Assertions.assertEquals(10, right.getValue());

        left.swap(right);

        Assertions.assertEquals(10, left.getValue());
        Assertions.assertEquals(12, right.getValue());

    }

    @Test
    public void equalsAndHashcodeAreConsistent() {
        IntHolder left = IntHolder.valueOf(10);
        IntHolder right = new IntHolder(10);

        Assertions.assertEquals(left, right);
        Assertions.assertEquals(left.hashCode(), right.hashCode());
    }

    @Test
    public void operatorsWork() {
        IntHolder left = IntHolder.valueOf(10);
        IntHolder right = IntHolder.valueOf(2);
        Assertions.assertEquals(10, left.getValue());
        Assertions.assertEquals(2, right.getValue());

        Assertions.assertEquals(12, left.plus(right).getValue());
        Assertions.assertEquals(8, left.minus(right).getValue());
        Assertions.assertEquals(40, left.times(right).times(right).getValue());
        Assertions.assertEquals(5, left.div(right).getValue());

    }

}
