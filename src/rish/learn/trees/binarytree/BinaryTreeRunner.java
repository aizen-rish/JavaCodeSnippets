package rish.learn.trees.binarytree;

public class BinaryTreeRunner {

	public static void main(String[] args) {

		BinaryTree<Integer> tree1 = new BinaryTree<>();
		tree1.setRoot(new Node<>(1));
		tree1.getRoot().setLeft(new Node<>(2));
		tree1.getRoot().setRight(new Node<>(3));
		tree1.getRoot().getLeft().setLeft(new Node<>(4));
		tree1.getRoot().getLeft().setRight(new Node<>(5));

		System.out.println(" Height of tree is : " + tree1.calculateHeight());

		BinaryTreeTraversals.traverseInorder(tree1.getRoot());
		System.out.println();
		BinaryTreeTraversals.traversePreorder(tree1.getRoot());
		System.out.println();
		BinaryTreeTraversals.traversePostorder(tree1.getRoot());
		System.out.println();
		BinaryTreeTraversals.levelOrderTraversal(tree1.getRoot());
		System.out.println();
		BinaryTreeTraversals.levelOrderTraversalNaive(tree1.getRoot());
	}

}
