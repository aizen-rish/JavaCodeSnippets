package rish.scripts.challenges.hackerearth;

/**
 * 
 * Contest link:
 * https://www.hackerearth.com/challenges/competitive/june-circuits-23/problems/
 * Problem link:
 * https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/no-inversions-db0ebea5/
 * 
 * Date attempted: 30th June 2023
 * 
 * @author Rishabh Soni
 *
 */
public class NoInversions {

	public static void main(String[] args) {

		String test = "abced";

		StringSegmentTree tree = new StringSegmentTree(test);
		tree.printTree();
	}

}

class StringSegmentTree {

	String input;
	String[] tree;

	public StringSegmentTree(String input) {

		int size = input.length();
		int height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
		int maxSize = 2 * (int) Math.pow(2, height) - 1;

		this.input = input;
		this.tree = new String[maxSize];
		buildInternal(0, size - 1, 0);
	}

	private String buildInternal(int i, int j, int node) {

		if (i == j) {
			tree[node] = input.substring(i, j + 1);
			return tree[node];
		}

		int mid = (i + j) / 2;
		int leftChild = 2 * node + 1;
		int rightChild = leftChild + 1;

		tree[node] = buildInternal(i, mid, leftChild) + buildInternal(mid + 1, j, rightChild);
		return tree[node];
	}

	public void printTree() {
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}

}
