package org.ds.datastructures.trees;

import java.util.LinkedList;

public class BST {

	private TreeNode<Integer> root;
	
	public BST() {
	}
	
	public TreeNode<Integer> getRoot(){
		return root;
	}
	public TreeNode<Integer> insert(TreeNode<Integer> root, TreeNode<Integer> data) {
		if(root==null) {
			this.root = data;
			return root;
		}
		
		if(root.getData() > data.getData()) {
			root.setLeft( insert(root.getLeft(), data) );
		}else if(root.getData() < data.getData()) {
			root.setRight( insert(root.getRight(), data));
		}
		
		return root;
	}
	
	public void insert(int data) {
		insert(this.root, new TreeNode<Integer>(data,null,null));
	}
	
	public void printBST(TreeNode<Integer> root) {
		if(root == null)
			return;
		LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode<Integer> temp = queue.poll();
			System.out.print( temp.getData() + ", ");
			if(temp.getLeft()!=null)
				queue.offer(temp.getLeft());
			if(temp.getRight()!=null)
				queue.offer(temp.getRight());
		}
		
		
	}
	
	public static void main(String[] args) {
		
		BST bst = new BST();
		bst.insert(10);
		bst.insert(-10);
		bst.insert(20);
		bst.insert(15);
		bst.insert(5);
		
		bst.printBST(bst.getRoot());
		
	}
	
	
	
	
	
}
