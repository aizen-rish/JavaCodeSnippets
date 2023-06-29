package rish.learn.trees.segmentTree;

/**
 * 
 * Implementation based on JavaTPoint
 * https://www.javatpoint.com/segment-tree-in-java
 * 
 * @author Rishabh Soni
 *
 */
public class SegmentTreeImpl {

	int[] input;
	int[] tree;

	public SegmentTreeImpl(int[] input) {
		this.input = input;
		int size = input.length;
		int height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
		int maxSize = 2 * (int) Math.pow(2, height) - 1;
		this.tree = new int[maxSize];
		buildInternal(0, size - 1, 0);
	}

	private int buildInternal(int i, int j, int node) {

		if (i == j) {
			tree[node] = input[i];
			return input[i];
		}

		int mid = getMidIndex(i, j);
		int leftChild = 2 * node + 1;
		int rightChild = leftChild + 1;

		tree[node] = buildInternal(i, mid, leftChild) + buildInternal(mid + 1, j, rightChild);
		return tree[node];
	}

	private int getMidIndex(int f, int l) {
		return (l + f) / 2;
	}

	/**
	 * Method to retrieve sum of elements in given query range
	 * 
	 * @param left  Start index of query range
	 * @param right End index of query range
	 * @return int Sum of elements in given range
	 * 
	 * @exception IllegalArgumentException On bad query range
	 */
	public int getSum(int left, int right) {

		if (right < 0 || left > input.length - 1) {
			throw new IllegalArgumentException("Invalid range for the query");
		}

		return getSumInternal(0, 0, input.length - 1, left, right);
	}

	/**
	 * Internal method to retrieve sum of elements in given query range
	 * 
	 * @param node       Index of current node, initialized as 0 for root
	 * @param rangeLeft  Start index of segment represented by current node
	 * @param rangeRight End index of segment represented by current node
	 * @param left       Start index of query range
	 * @param right      End index of query range
	 * 
	 * @return Sum of elements in given range
	 */
	private int getSumInternal(int node, int rangeLeft, int rangeRight, int left, int right) {

		if (left <= rangeLeft && right >= rangeRight) {
			return tree[node];
		}

		if (rangeRight < left || rangeLeft > right) {
			return 0;
		}

		int mid = getMidIndex(rangeLeft, rangeRight);
		int leftChild = 2 * node + 1;
		int rightChild = leftChild + 1;

		return getSumInternal(leftChild, rangeLeft, mid, left, right)
				+ getSumInternal(rightChild, mid + 1, rangeRight, left, right);
	}

}
