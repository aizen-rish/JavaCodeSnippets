package rish.learn.trees.binarytree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTree<T> {

	private Node<T> root;

	public int calculateHeight() {

		if (root == null) {
			return 0;
		}

		return calculateHeightInternal(root);
	}

	public static <T> int calculateHeightInternal(Node<T> node) {

		if (node == null) {
			return 0;
		}

		int leftHeight = calculateHeightInternal(node.getLeft());
		int rightHeight = calculateHeightInternal(node.getRight());

		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}

}
