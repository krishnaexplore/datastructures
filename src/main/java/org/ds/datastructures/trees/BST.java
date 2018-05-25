package org.ds.datastructures.trees;

import java.util.LinkedList;
import java.util.Stack;

public class BST {

	private TreeNode<Integer> root;
	
	public BST() {
	}
	
	public TreeNode<Integer> getRoot(){
		return root;
	}
	public TreeNode<Integer> insert(TreeNode<Integer> root, int key) {
		if(root==null) {
			root = new TreeNode<Integer>(key,null,null);
			return root;
		}
		
		if( key < root.getData()) {
			root.setLeft( insert(root.getLeft(), key) );
		}else if( key > root.getData() ) {
			root.setRight( insert(root.getRight(), key));
		}
		
		return root;
	}
	
	public void insert(int data) {
	
		root = insert(root,data);
	}
	
	
	public void insertIteratively(int data) {
		TreeNode<Integer> newNode = new TreeNode<>(data,null,null);
		if( root == null) {
			root = newNode;
			return;
		}
		
		Stack<TreeNode<Integer>> k = new Stack<>();
		k.push(root);
		
		while(!k.isEmpty()) {
			TreeNode<Integer> temp = k.pop();
			
			if( data > temp.getData() ) {
				if( temp.getRight() ==null) {
					temp.setRight(newNode);
					break;
				}else {
					k.push(temp.getRight());
				}
			}
			
			if( data < temp.getData()) {
				if( temp.getLeft() == null ) {
					temp.setLeft( newNode );
					break;
				}else {
					k.push(temp.getLeft());
				}
				
			}
			
			
		}
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
	
	public void delete(int data) {
		delete(root, data);
	}
	
	private TreeNode<Integer> delete(TreeNode<Integer> root, int data) {
		if(root == null)
			return null;
		if(data < root.getData())
			root.setLeft(     delete(root.getLeft(), data)  );
		else if (data > root.getData() )
			root.setRight(    delete(root.getRight(), data) );
		else {
			if( root.getLeft() == null )
					return root.getRight();
			if( root.getRight() == null )
				    return root.getLeft();
			
			root.setData( minValue(root.getRight()) );
			
			root.setRight(  delete(root.getRight(), data) );
		}
		return root;
		
	}
	private int minValue(TreeNode<Integer> root) {
		int minv = root.getData();
		while(root.getLeft()!=null) {
			minv = root.getLeft().getData();
			root = root.getLeft();
		}
		return minv;
	}
	
	public void printInOrder(TreeNode<Integer> root) {
		if(root!=null) {
			printInOrder(root.getLeft());
            System.out.println(root.getData());
            printInOrder(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		
		BST bst = new BST();
		/*bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		bst.printBST(bst.getRoot());
		
		System.out.println("\nDelete 20");
        bst.delete(20);
        bst.printBST(bst.getRoot());
        System.out.println("\nDelete 30");
        bst.delete(30);
        bst.printBST(bst.getRoot());
        System.out.println("\nDelete 50");
        bst.delete(50);
        bst.printBST(bst.getRoot());*/
		
		bst.insertIteratively(50);
		bst.insertIteratively(30);
		bst.insertIteratively(20);
		bst.insertIteratively(40);
		bst.insertIteratively(70);
		bst.insertIteratively(60);
		bst.insertIteratively(80);
		bst.printInOrder(bst.getRoot());
	}
	
	
	
	
	
}
