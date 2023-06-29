package rish.learn.arrays.search;

public class BinarySearch {

	public static int binarySearch(int[] arr, int ele) {

		int start = 0;
		int end = arr.length - 1;
		int mid = (int) Math.ceil((start + end) / 2);

		while (end >= 0 && start < arr.length) {

			if (arr[mid] < ele) {
				start = mid + 1;
			} else if (arr[mid] > ele) {
				end = mid - 1;
			} else {
				return mid;
			}

			mid = (start + end) / 2;
		}

		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 5, 7, 8, 12, 45, 67, 78, 79, 91, 92 };

		System.out.println(binarySearch(arr, 4));
	}

}
