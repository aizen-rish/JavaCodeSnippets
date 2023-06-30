package rish.scripts.challenges.hackerearth;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println(tree.query(1, 4));

		System.out.println(isInverted("abcd"));
	}

	public static boolean isInverted(String s) {
		int init = 0;
		for (char c : s.toCharArray()) {
			int cVal = Character.getNumericValue(c);
			if (cVal < init) {
				return true;
			}
			init = cVal;
		}
		return false;
	}

}

class StringSegmentTree {

	String input;
	String[] tree;
	int[] invTree;

	public StringSegmentTree(String input) {

		int size = input.length();
		int height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
		int maxSize = 2 * (int) Math.pow(2, height) - 1;

		this.input = input;
		this.tree = new String[maxSize];
		this.invTree = new int[maxSize];
		buildInternal(0, size - 1, 0);
	}

	public List<String> query(int i, int j) {
		List<String> answer = new ArrayList<>();
		queryInternal(answer, 0, 0, input.length() - 1, i, j);
		return answer;
	}

	private String queryInternal(List<String> answer, int node, int rangeLeft, int rangeRight, int i, int j) {

		if (i <= rangeLeft && j >= rangeRight) {
//			answer.add(tree[node]);
			// return NoInversions.isInverted(tree[node]) ? 1 : 0;
			System.out.println(tree[node]);
			return tree[node];
		}

		if (rangeRight < i || rangeLeft > j) {
			return "";
		}

		int mid = (rangeLeft + rangeRight) / 2;
		int leftChild = 2 * node + 1;
		int rightChild = leftChild + 1;

		String a = queryInternal(answer, leftChild, rangeLeft, mid, i, j);
		String b = queryInternal(answer, rightChild, mid + 1, rangeRight, i, j);
		System.out.println(a + ":" + b);
		return a + b;
	}

	private String buildInternal(int i, int j, int node) {

		if (i == j) {
			tree[node] = input.substring(i, j + 1);
			invTree[node] = 1;
			return tree[node];
		}

		int mid = (i + j) / 2;
		int leftChild = 2 * node + 1;
		int rightChild = leftChild + 1;

		System.out.println(input.substring(i, j + 1));
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
