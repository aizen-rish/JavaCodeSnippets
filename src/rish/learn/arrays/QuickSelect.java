package rish.learn.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuickSelect {

    /*
     * Used to find Kth smallest element in an unordered list It has an average
     * runtime of O(n)
     */
    private static int quickSelect(List<Integer> nums, int k) {

        // Randomly select an index as pivot
        int random = new Random().nextInt(nums.size());
        int pivot = nums.get(random);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        nums.forEach(num -> {
            if (num < pivot) {
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        });

        /*
         * The Kth smallest element will be in list of smaller numbers.
         */
        if (left.size() >= k) {
            return quickSelect(left, k);
        }

        /*
         * The Kth smallest element will be in list of bigger numbers. Since we are
         * eliminating some amount of smaller numbers, we need to adjust k
         * appropriately.
         */
        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }

        /*
         * The Kth smallest element is in the pivot element.
         */
        return pivot;
    }

    public static int findKthSmallest(List<Integer> nums, int k) {
        return quickSelect(nums, k);
    }

    public static int findKthLargest(List<Integer> nums, int k) {
        /*
         * Adjust k to find smallest element from end, instead of largest.
         */
        return quickSelect(nums, nums.size() - k + 1);
    }

    public static void main(String[] args) {

        int[] x = { 0 };

        Arrays.stream(x).boxed().collect(Collectors.toList());

        List<Integer> nums = Arrays.asList(3, 2, 3, 1, 2, 4, 5, 5, 6);

        System.out.println(findKthSmallest(nums, 6));
        System.out.println(findKthLargest(nums, 4));
    }

}
