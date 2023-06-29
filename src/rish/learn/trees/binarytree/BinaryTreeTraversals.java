package rish.learn.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversals {

	public static <T> void traverseInorder(Node<T> root) {

		if (root == null) {
			return;
		}

		traverseInorder(root.getLeft());
		System.out.print(" " + root.getData());
		traverseInorder(root.getRight());
	}

	public static <T> void traversePreorder(Node<T> root) {

		if (root == null) {
			return;
		}

		System.out.print(" " + root.getData());
		traversePreorder(root.getLeft());
		traversePreorder(root.getRight());
	}

	public static <T> void traversePostorder(Node<T> root) {

		if (root == null) {
			return;
		}

		traversePostorder(root.getLeft());
		traversePostorder(root.getRight());
		System.out.print(" " + root.getData());
	}

	public static <T> void levelOrderTraversal(Node<T> root) {

		if (root == null) {
			return;
		}

		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			Node<T> currentNode = queue.poll();
			System.out.print(" " + currentNode.getData());

			if (currentNode.getLeft() != null) {
				queue.add(currentNode.getLeft());
			}

			if (currentNode.getRight() != null) {
				queue.add(currentNode.getRight());
			}
		}
	}

	public static <T> void levelOrderTraversalNaive(Node<T> root) {

		int height = BinaryTree.calculateHeightInternal(root);
		for (int i = 0; i < height; i++) {
			traverseTreeAtLevel(root, i + 1);
		}
	}

	private static <T> void traverseTreeAtLevel(Node<T> node, int level) {

		if (node == null) {
			return;
		}

		if (level == 1) {
			System.out.print(" " + node.getData());
			return;
		}

		if (level > 1) {
			traverseTreeAtLevel(node.getLeft(), level - 1);
			traverseTreeAtLevel(node.getRight(), level - 1);
		}
	}

}
