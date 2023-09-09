package rish.scripts.challenges;

import java.util.Arrays;

/*
 * Given an unsorted array of integers, find the first missing positive integer.
 */
public class MissingInteger {

    public static int solution(int[] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 1) {
                A[i] = A.length + 1;
            }
        }

        System.out.println(Arrays.toString(A));

        for (int i = 0; i < A.length; i++) {
            int val = Math.abs(A[i]);
            if (val - 1 < A.length) {
                A[val - 1] = -1 * Math.abs(A[val - 1]);
            }
        }

        System.out.println(Arrays.toString(A));

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                return i + 1;
            }
        }

        return A.length + 1;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        System.out.println(solution(arr));

    }

}
