package rish.learn.arrays.sort;

public class SelectionSort {

	public static int[] sort(int[] arr) {
		return sort(arr, true);
	}

	public static int[] sort(int[] arr, boolean asc) {

		int n = arr.length;
		int pivotIndex = -1;

		for (int i = 0; i < n; i++) {

			int pivot = asc ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			for (int j = i; j < arr.length; j++) {
				boolean updatePivot = asc ? arr[j] < pivot : arr[j] > pivot;
				if (updatePivot) {
					pivotIndex = j;
					pivot = arr[j];
				}
			}

			swap(arr, i, pivotIndex);
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
		sort(arr, false);
		printArray(arr);
	}

}
