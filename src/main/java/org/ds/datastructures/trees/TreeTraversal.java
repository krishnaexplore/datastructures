package org.ds.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
	private static void preOrder(TreeNode<Integer> root) {
		if (root == null)
			return;
		process( root.getData() );
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	private static void inOrder(TreeNode<Integer> root) {
		if (root == null)
			return;
		inOrder(root.getLeft());
		process( root.getData() );
		inOrder(root.getRight());

	}

	private static void postOrder(TreeNode<Integer> root) {
		if (root == null)
			return;
		postOrder(root.getLeft());
		postOrder(root.getRight());
		process( root.getData() );
	}
	
	private static void preOrderIterative(TreeNode<Integer> root) {
		
		Stack<TreeNode<Integer>> stack = new Stack<>();
		
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode<Integer> node = stack.pop();
			process(node.getData());
			if(node.getRight()!=null)
				stack.push(node.getRight());
			if(node.getLeft()!=null)
				stack.push(node.getLeft());
		}
	}
	
	private static void inOrderIterative(TreeNode<Integer> root) {
		
		Stack<TreeNode<Integer>> stack = new Stack<>();
		TreeNode<Integer> current = root;
		
		/*while(current!=null) {
			stack.push(current);
			current = current.getLeft();
		}
		while(!stack.isEmpty()) {
			current = stack.pop();
			System.out.print( current.getData() + "," );
			if( current.getRigt()!=null) {
			  current = current.getRigt();
			  while(current!=null) {
				  stack.push(current);
				  current = current.getLeft();
			  }
			}
		}*/
		boolean isDone = false;
		while(!isDone) {
			if(current!=null) {
				stack.push(current);
				current = current.getLeft();
			}else {
				if(!stack.isEmpty()) {
					TreeNode<Integer> node = stack.pop();
					process( node.getData() );
					current = node.getRight();
				}else {
					isDone = true;
				}
			}
		}
	}
	
	private static void postOrderIterativeTwoStacks(TreeNode<Integer> root) {
		
		Stack<TreeNode<Integer>> stack1 = new Stack<>();
		Stack<TreeNode<Integer>> stack2 = new Stack<>();
		
		stack1.push(root);
		
		while(!stack1.isEmpty()) {
			TreeNode<Integer> node = stack1.pop();
			if(node.getLeft()!=null)
				stack1.push(node.getLeft());
			if(node.getRight()!=null)
				stack1.push(node.getRight());
			
			stack2.push(node);
		}
		while(!stack2.isEmpty()) {
			TreeNode<Integer> node = stack2.pop();
			process( node.getData() );
		}
		
	}

	private static void levelOrder(TreeNode<Integer> root) {

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
	private static void process(Integer s) {
		System.out.print(s + ",");
	}

	public static void main(String[] args) {

		/**
		 *                      1
		 *                    /   \
		 *                   2     3
		 *                 /   \
		 *                4     5
		 *
		 *
		 */
		TreeNode<Integer> l2l = new TreeNode<>(4, null, null);
		TreeNode<Integer> l2r = new TreeNode<>(5, null, null);
		TreeNode<Integer> l1l = new TreeNode<>(2, l2l, l2r);
		TreeNode<Integer> l1r = new TreeNode<>(3, null, null);
		TreeNode<Integer> root = new TreeNode<>(1, l1l, l1r);

		System.out.println("Pre Order");
		preOrder(root);
		System.out.println();
		System.out.println("Pre Order Iterative");
		preOrderIterative(root);
		System.out.println();
		System.out.println("In Order");
		inOrder(root);
		System.out.println();
		System.out.println("In Order Iterative");
		inOrderIterative(root);
		System.out.println();
		System.out.println("Post Order");
		postOrder(root);
		System.out.println();
		System.out.println("Post OrderIterativeTwoStacks");
		postOrderIterativeTwoStacks(root);
		System.out.println();
		System.out.println("Level Order");
		levelOrder(root);

	}

}
