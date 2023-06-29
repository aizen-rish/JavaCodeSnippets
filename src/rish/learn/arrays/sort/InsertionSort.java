package rish.learn.arrays.sort;

public class InsertionSort {

	public static int[] sort(int[] arr) {
		return sort(arr, true);
	}

	public static int[] sort(int[] arr, boolean asc) {

		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {

			for (int j = i + 1; j > 0; j--) {

				int diff = arr[j] - arr[j - 1];
				if (asc) {
					diff *= -1;
				}

				if (diff > 0) {
					swap(arr, j, j - 1);
				}
			}
		}

		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] arr = { 67, 78, 5, 92, 7, 79, 91, 2, 3, 4, 8, 12, 45, -5 };
		sort(arr, true);
		printArray(arr);
	}

}
