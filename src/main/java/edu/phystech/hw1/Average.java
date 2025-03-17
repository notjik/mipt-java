package edu.phystech.hw1;


public class Average {

    public static double average(int... numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return (double) sum / numbers.length;
    }
}
