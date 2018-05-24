package org.ds.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeProblems<T> {

	private TreeNode<T> root;
	
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
	
	public void insertElementInBT(TreeNode<Integer> root, Integer data) {

		LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
		if(root!=null) {
			queue.offer(root);
		}else {

		}
		TreeNode<Integer> newNode = new TreeNode<>(data,null,null);
		while(!queue.isEmpty()) {
			TreeNode<Integer> temp = queue.pop();
			if (temp.getLeft()!=null) {
				queue.offer(temp.getLeft());
			}
			else {
				temp.setLeft(newNode);
				break;
			}
			if( temp.getRight()!=null) {
				queue.offer(temp.getRight());
			}else {
				temp.setRight(newNode);
				break;
			}
		}

	}

	public void printLevelOrder(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

		while(!queue.isEmpty()) {
			TreeNode<Integer> node  = queue.poll();
			process(node.getData());
			if( node.getLeft() != null)
				queue.offer(node.getLeft());
			if( node.getRight() != null)
				queue.offer(node.getRight());
		}
	}
	private void process(Integer s) {
		System.out.print(s + ",");
	}

	public int findHeight(TreeNode<Integer> root) {
		int height = 0;
		LinkedList<TreeNode<Integer>> queue = new LinkedList<>();

		if(root == null)
			return 0;
		else {
			queue.offer(root);
			height++;
		}

		while(!queue.isEmpty()) {

			TreeNode<Integer> temp = queue.poll();
			if( temp.getLeft()!=null || temp.getRight()!=null) {
				height++;
				if(temp.getLeft()!=null)
					queue.offer(temp.getLeft());
				if(temp.getRight()!=null)
					queue.offer(temp.getRight());
			}

		}
		return height;
	}

	public void printLevelOrderInReverse(TreeNode<Integer> root) {

		if(root == null)
			return;
		LinkedList<TreeNode<Integer>> ll = new LinkedList<>();
		ll.offer(root);
		Stack<TreeNode<Integer>> stack = new Stack<>();
		while(!ll.isEmpty()) {
			TreeNode<Integer> temp = ll.poll();
			stack.push(temp);
			if(temp.getLeft()!=null)
				ll.offer(temp.getLeft());
			if(temp.getRight()!=null)
				ll.offer(temp.getRight());
		}

		while(!stack.isEmpty()) {
			TreeNode<Integer> currentNode = stack.pop();
			System.out.print(currentNode.getData() +", ");
		}

	}

	public int findNumberOfLeafNodes(TreeNode<Integer> root) {

		if(root == null)
			return 0;

		LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);

		int numberOfLeaves = 0;
		while(!queue.isEmpty()) {

			TreeNode<Integer> temp = queue.poll();
			if(temp.getLeft() == null && temp.getRight() == null) {
				numberOfLeaves++;
			}else {
				if( temp.getLeft()!=null )
					queue.offer(temp.getLeft() );
				if(temp.getRight()!=null)
					queue.offer(temp.getRight());
			}
		}
		return numberOfLeaves;

	}

	public TreeNode<Integer> mirror(TreeNode<Integer> root) {
		if(root==null)
			return null;

		TreeNode<Integer> left = mirror(root.getLeft());
		TreeNode<Integer> right = mirror(root.getRight());

		root.setLeft(right);
		root.setRight(left);

		return root;
	}

	public static void main(String[] args) {
		TreeNode<Integer> l2l = new TreeNode<>(4, null, null);
		TreeNode<Integer> l2r = new TreeNode<>(5, null, null);
		TreeNode<Integer> l1l = new TreeNode<>(2, l2l, l2r);
		TreeNode<Integer> l1r = new TreeNode<>(3, null, null);
		TreeNode<Integer> root = new TreeNode<>(1, l1l, l1r);

		/*System.out.println(t.findMax(root));
		System.out.println(t.findMaxIterative(root));
		
		System.out.println(t.findElement(root, 3));
		System.out.println(t.findElement(root, 6));
		
		System.out.println(t.findElementIterative(root, 3));
		System.out.println(t.findElementIterative(root,	6));*/

		TreeProblems<Integer> tree = new TreeProblems<>();
		//tree.printLevelOrder(root);
		tree.insertElementInBT(root, 10);
		tree.insertElementInBT(root, 11);
		System.out.println();
		//tree.printLevelOrder(root);

		//System.out.println( "height of the tree is "+tree.findHeight(root));

		//System.out.println();
		//tree.printLevelOrderInReverse(root);
		//System.out.println();
		//System.out.println(tree.findNumberOfLeafNodes(root) );

		tree.printLevelOrder(root);
		System.out.println();
		tree.mirror(root);
		tree.printLevelOrder(root);
	}

}
