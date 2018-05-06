package org.ds.datastructures.trees;

public class TreeNode<T> {

	private T data;
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;
	
	public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public T getData() {
		return data;
	}
	public TreeNode<T> getLeft() {
		return leftNode;
	}
	public TreeNode<T> getRight(){
		return rightNode;
	}
	
	
}
