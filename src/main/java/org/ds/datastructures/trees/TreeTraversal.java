package org.ds.datastructures.trees;

public class TreeTraversal {
	private static void preOrder(TreeNode<Integer> root) {
		if (root == null)
			return;
		System.out.print(root.getData() + ",");
		preOrder(root.getLeft());
		preOrder(root.getRigt());
	}

	private static void inOrder(TreeNode<Integer> root) {
		if (root == null)
			return;
		inOrder(root.getLeft());
		System.out.print(root.getData() + ",");
		inOrder(root.getRigt());

	}

	private static void postOrder(TreeNode<Integer> root) {
		if (root == null)
			return;
		postOrder(root.getLeft());
		postOrder(root.getRigt());
		System.out.print(root.getData() + ",");
	}

	public static void main(String[] args) {

		TreeNode<Integer> l2l = new TreeNode<>(4, null, null);
		TreeNode<Integer> l2r = new TreeNode<>(5, null, null);
		TreeNode<Integer> l1l = new TreeNode<>(2, l2l, l2r);
		TreeNode<Integer> l1r = new TreeNode<>(3, null, null);
		TreeNode<Integer> root = new TreeNode<>(1, l1l, l1r);

		System.out.println("Pre Order");
		preOrder(root);
		System.out.println();
		System.out.println("In Order");
		inOrder(root);
		System.out.println();
		System.out.println("Post Order");
		postOrder(root);

	}

}
