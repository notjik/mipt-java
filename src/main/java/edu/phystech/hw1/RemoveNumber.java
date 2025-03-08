package edu.phystech.hw1;

public class RemoveNumber {
    public static int[] removeElement(int[] input, int element) {
        int c = 0;
        for (int num : input) {
            if (num != element) {
                c++;
            }
        }
        int[] result = new int[c];
        int i = 0;
        for (int num : input) {
            if (num != element) {
                result[i++] = num;
            }
        }
        return result;
    }
}
