package rish.learn.trees.binarytree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {

	private T data;
	private Node<T> left;
	private Node<T> right;

	public Node(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
