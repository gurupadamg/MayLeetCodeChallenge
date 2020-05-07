package com.mlcc.week1;

public class Day7_CousinsInBinaryTree {

	/*
	 * In a binary tree, the root node is at depth 0, and children of each depth k
	 * node are at depth k+1.
	 * 
	 * Two nodes of a binary tree are cousins if they have the same depth, but have
	 * different parents.
	 * 
	 * We are given the root of a binary tree with unique values, and the values x
	 * and y of two different nodes in the tree.
	 * 
	 * Return true if and only if the nodes corresponding to the values x and y are
	 * cousins.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * 
	 * Input: root = [1,2,3,4], x = 4, y = 3 Output: false Example 2:
	 * 
	 * 
	 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4 Output: true Example 3:
	 * 
	 * 
	 * 
	 * Input: root = [1,2,3,null,4], x = 2, y = 3 Output: false
	 * 
	 * 
	 * Note:
	 * 
	 * The number of nodes in the tree will be between 2 and 100. Each node has a
	 * unique integer value from 1 to 100.
	 * 
	 */

	/* Definition for a binary tree node. */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class CousinNode {
		TreeNode parent;
		int level;

		CousinNode(TreeNode parentVal, int level) {
			this.parent = parentVal;
			this.level = level;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {

		CousinNode cn1 = getCousinNode(root, null, x, 0);
		CousinNode cn2 = getCousinNode(root, null, y, 0);
		if (cn1.level == cn2.level && cn1.parent != cn2.parent)
			return true;
		return false;
	}

	/* Recursion Approach */
	CousinNode getCousinNode(TreeNode currNode, TreeNode parentNode, int value, int level) {
		/* Base Condition */
		if (currNode == null)
			return null;

		if (currNode.val == value)
			return new CousinNode(parentNode, level);

		CousinNode cnLeft = getCousinNode(currNode.left, currNode, value, level + 1);
		CousinNode cnRight = getCousinNode(currNode.right, currNode, value, level + 1);

		return cnLeft == null ? cnRight : cnLeft;

	}

}
