package rish.learn.trees.segmentTree;

import lombok.AllArgsConstructor;

/*
 * Implementation taken from GeeksForGeeks
 * 
 * TODO: Fix query() method
 */

@AllArgsConstructor
public class SumSegmentTree {

	int[] input;
	int[] tree;

	public SumSegmentTree(int[] input) {
		this.input = input;
		this.tree = new int[input.length * 4];
	}

	public int query(int left, int right) {

		if (right < 0 || left > input.length - 1) {
			return 0;
		}

		return queryInternal(0, 0, input.length - 1, left, right);
	}

	private int queryInternal(int node, int rangeLeft, int rangeRight, int left, int right) {

		System.out.println(String.format("Node %s left %d right %d", node, rangeLeft, rangeRight));

		// fix below
		if (left <= rangeLeft && right <= rangeRight) {
			return tree[node];
		}

		int mid = (rangeLeft + rangeRight) / 2;
		int leftChild = 2 * node + 1;
		int rightChild = leftChild + 1;

		return queryInternal(leftChild, rangeLeft, mid, left, right)
				+ queryInternal(rightChild, mid + 1, rangeRight, left, right);
	}

	public void build() {
		buildInternal(0, 0, input.length - 1);
	}

	private void buildInternal(int node, int leftValue, int rightValue) {

		if (leftValue == rightValue) {
			tree[node] = input[leftValue];
			return;
		}

		int mid = (leftValue + rightValue) / 2;
		int leftChild = 2 * node + 1;
		int rightChild = leftChild + 1;

		buildInternal(leftChild, leftValue, mid);
		buildInternal(rightChild, mid + 1, rightValue);

		tree[node] = tree[leftChild] + tree[rightChild];
	}

}
