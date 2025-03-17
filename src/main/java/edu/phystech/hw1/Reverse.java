package edu.phystech.hw1;

import java.util.Arrays;

public class Reverse {

    public static int[] reverse(int[] nums) {
        int[] reversed = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = reversed[i];
            reversed[i] = reversed[nums.length - 1 - i];
            reversed[nums.length - 1 - i] = temp;
        }
        return reversed;
    }
}
