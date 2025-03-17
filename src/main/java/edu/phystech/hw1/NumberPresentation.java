package edu.phystech.hw1;

public class NumberPresentation {
    public static String toBinary(int x) {
        return Integer.toBinaryString(x);
    }

    public static String toOct(int x) {
        return Integer.toOctalString(x);
    }

    public static String toHex(int x) {
        return Integer.toHexString(x);
    }
}
