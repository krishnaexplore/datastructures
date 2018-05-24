- Give an algorithm for finding maximum element in binary tree. (recursion & iteration)
- Give an algorithm for searching an element in binary tree (recursion & iteration)
- Give an algorithm for inserting an element into binary tree
- Give an algorithm for finding the size of binary tree. (recursion & iteration)
- Give an algorithm for printing the level order data in reverse (level order -- instead of S.o.P push it to stack and display later) 
- Give an algorithm for deleting the tree (Use post order LRD)
- Give an algorithm for finding the height (or depth) of the binary tree. (recursion and iteration)
- Give an algorithm for finding the deepest node in a binary tree.
- Give an algorithm for deleting a element from binary tree.
- Give an algorithm to finding the number of leaves in the binary tree without using recursion.
- Give an algorithm to find the number of full nodes in the binary tree without using recursion
- Give an algorithm to find the number of half nodes in the binary tree without using recursion
-  Given two binary trees return true if they are structurally identical 
-  Give an algorithm for finding the diameter of the binary tree. The diameter of a tree (some times called the width) is the number   of   nodes on longest path b/w two leaves in the tree
- Give an algorithm to find the level which is having maximum sum in the binary tree.
- Given a binary tree, print out all of its root-to-leaf paths
- Given an algorithm for checking the existence of path with given sum. That means, given a sum check whether there exists a path from root to any of the nodes.
- Given an algorithm for finding the sum of all elements in binary tree (recursion & iteration)
- Give an algorithm for converting a tree to its mirror. Mirror of a tree is another tree with left and right children of non-leaf nodes interchanged.
- Given two trees, give an algorithm for checking whether they are mirrors of each other.
- Give an algorithm for constructing binary tree from given inorder and preorder traversals
    if we are given two traversal sequences, can we construct the binary tree uniquiely.

- Give an algorithm for printing all the ancestors of a node in a binary tree. for the below tree, for 7 the ancestors are 1,3,7
- Give an algorithm for finding LCA of two nodes in a binary tree.
    zigzag tree traversal
- Give an algorithm for finding the vertical sum of a binary tree.
- how many different binary trees are possible with n nodes
- Given a tree with special property where leaves are represented with L and internal node with I. Also, assume that each node has either 0 or 2 children. Given preorder traversal of this tree. construct the tree[l]
- Given a tree, give an algorithm for finding the sum of all the elements of the tree.
- For 4-ary tree , what is the maximum possible height with 100 nodes? assume height of a single node is 0
- For 4-ary tree, what is the minimum possible height with n nodes?
- Given a parent array p, where p[i] indicates the parent of ith node in the tree (assume parent of root node is indicated with -1). 
- Give algorithm for finding the height or depth of tree.
- Given a node in the generic tree. 

- Give an algorithm for finding the shortest path between two nodes in a BST

- Give an alogorithm for counting the number of BST's possible with n nodes

- Give an algorithm to check whether the given binary tree is a BST or not

- Give an algorithm for converting BST to cicular DLL with space complexity O(1)
  * hint: Convert Left n Right sub trees to DLLs and maintain end of those lists, then, adjust the pointers. TC O(n)

- Given a sorted doubly linked list, give an algorithm for converting it into balanced binary search tree.
	* hint find the list lenth and construct the tree bottom-up
	Tc : 2T(n/2) + O(n) = O(nlogn)

- Give a sorted array, give an algorithm for converting the array to BST

- Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

- Give an algorithm for finding the k-th smallest element in BST
  * hint : inorder traversal

- Give an algorithm for finding the union and intersection of BSTs. Assume parent pointers are available (say threaded binary trees). Also assume the lengths of two BST's are m and n respectively

- Given a BST and two numbers K1 and K2, give an algorithm for printing all the elements of BST in the range k1 and k2.

- Given root of binary search tree, trim the tree, so that all elements in the new tree returned are between the A and B

- Given two BSTs, check whether the elements of them are same or not. for example: TWO bsts with data 10, 5, 20,15,30 and 10 20 15 30 5 should return true, and data with 10,5,20,15,30 and 10 15 30 20 5

- Given a height h, give an algorithm for generating the HB(0).

- Construct minimal AVL trees of height 0,1,2,3,4 and 5.what is number of nodes ina minimal AVL tree of height 6?

- Given a BST check whether it is AVL tree or not
- Given a height, give an algorithm for generating an AVL tree with minimum number of nodes.

- Given an AVL tree with n integer items and two integers a andb, where a and b can be any integers with a <= b. implement an algorithm to count the number of nodes in the range [a,b ]

- Median in an infinite series of Integers

- Given a binary tree, how do you remove all the half nodes (which has only one child)? Note that we should not touch leaves
  * post order traversal

- Given a binary tree, how do you remove leaves of it
  * post order traversal

- Given a BST and two integers (minimum and maximum integers) as parameters, how do you remove (prune) elements from the tree any elements that are not within that range, inclusive.

- Given a binary tree, how do you connect all the adjacent nodes at the same level? Assume that given binary tree has next pointer along with left and right pointers.


- Assume that a set S on n numbers are stored in some form of balanced binary search tree; i.e the depth of the tree is O(logn). In addition to the key value and the pointers to children, assume that every node contains the number of nodes in its subtree. Specify a reason(s) why a balanced binary tree can be a better option than a complete binary tree for storing that set S.
