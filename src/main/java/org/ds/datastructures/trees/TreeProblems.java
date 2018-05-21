package org.ds.datastructures.trees;

import java.util.LinkedList;

public class TreeProblems {

	
	public int findMax(TreeNode<Integer> root){
		int maxNode = Integer.MIN_VALUE;
		if( root!= null) {
			int leftMax = 	findMax(root.getLeft());
			int rightMax = findMax(root.getRight());
			
			if( leftMax > rightMax ) {
				maxNode = leftMax;
			}else {
				maxNode = rightMax;
			}
			
			if(root.getData() > maxNode) {
				maxNode = root.getData();
			}
		}
		return maxNode;
	}
	
	public int findMaxIterative(TreeNode<Integer> root) {
		if(root == null)
			return Integer.MIN_VALUE;
		
		int max = Integer.MIN_VALUE;
		
		LinkedList<TreeNode<Integer>> ll = new LinkedList<>();
		ll.offer(root);
		
		while(!ll.isEmpty()) {
			TreeNode<Integer> temp = ll.poll();
			if( temp != null ) {
				if( temp.getData() > max ) {
					max = temp.getData();
				}
				if( temp.getLeft()!=null )
					ll.offer(temp.getLeft());
				if( temp.getRight()!=null) 
					ll.offer(temp.getRight());
			}
		}
		return max;
	}
	
	public boolean findElement(TreeNode<Integer> root, int data) {
		if(root == null)
			return false;
		if(root.getData() == data)
			return true;
		return findElement(root.getLeft(),data) || findElement(root.getRight(),data);
	}
	
	public boolean findElementIterative(TreeNode<Integer> root, int data) {
		if(root == null)
			return false;
		LinkedList<TreeNode<Integer>> ll = new LinkedList<>();
		ll.offer(root);
		while(!ll.isEmpty()) {
			TreeNode<Integer> temp = ll.poll();
			
			if(temp.getData().equals(data)) {
				return true;
			}
			if( temp.getLeft()!=null)
				ll.offer(temp.getLeft());
			if(temp.getRight()!=null)
				ll.offer(temp.getRight());
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> l2l = new TreeNode<>(4, null, null);
		TreeNode<Integer> l2r = new TreeNode<>(5, null, null);
		TreeNode<Integer> l1l = new TreeNode<>(2, l2l, l2r);
		TreeNode<Integer> l1r = new TreeNode<>(3, null, null);
		TreeNode<Integer> root = new TreeNode<>(1, l1l, l1r);
		TreeProblems t = new TreeProblems();
		System.out.println(t.findMax(root));
		System.out.println(t.findMaxIterative(root));
		
		System.out.println(t.findElement(root, 3));
		System.out.println(t.findElement(root, 6));
		
		System.out.println(t.findElementIterative(root, 3));
		System.out.println(t.findElementIterative(root,	6));
	}
	
}
