package edu.phystech.hw1;

public class FindNumber {
    public static int findNumber(int[] input, int element) {
        int left = 0;
        int right = input.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (input[mid] == element) {
                return mid;
            } else if (input[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
