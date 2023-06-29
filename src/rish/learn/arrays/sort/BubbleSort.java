package rish.learn.arrays.sort;

public class BubbleSort {

	public static int[] sort(int[] arr) {
		return sort(arr, true);
	}

	public static int[] sort(int[] arr, boolean asc) {

		int sortedCount = 0;
		boolean swap = false;

		do {

			swap = false;
			for (int i = 0; i < arr.length - sortedCount - 1; i++) {
				boolean shouldSwap = asc ? arr[i] > arr[i + 1] : arr[i] < arr[i + 1];
				if (shouldSwap) {
					swap(arr, i, i + 1);
					swap = true;
				}
			}

			sortedCount++;

		} while (swap);

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

		sort(arr, false);
		printArray(arr);
	}

}
