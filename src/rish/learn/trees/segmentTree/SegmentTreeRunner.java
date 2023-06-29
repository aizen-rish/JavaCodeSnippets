package rish.learn.trees.segmentTree;

public class SegmentTreeRunner {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 3, 5, -2, 3 };
		SumSegmentTree tree = new SumSegmentTree(arr);
		tree.build();
		printArray(tree.tree);

		int a[] = { 2, 4, 7, 10, 12, 13 };
		SegmentTreeImpl tree1 = new SegmentTreeImpl(a);
		printArray(tree1.tree);

		System.out.println("Sum of values in range is: " + tree1.getSum(2, 4));
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
