package com.mlcc.week4;

import com.mlcc.util.TreeNode;

public class ConstructBinarySearchTreefromPreorderTraversal {
	/**
	 * Return the root node of a binary search tree that matches the given preorder
	 * traversal.
	 * 
	 * (Recall that a binary search tree is a binary tree where for every node, any
	 * descendant of node.left has a value < node.val, and any descendant of
	 * node.right has a value > node.val. Also recall that a preorder traversal
	 * displays the value of the node first, then traverses node.left, then
	 * traverses node.right.)
	 * 
	 * It's guaranteed that for the given test cases there is always possible to
	 * find a binary search tree with the given requirements.
	 * 
	 * Example 1:
	 * 
	 * Input: [8,5,1,7,10,12] Output: [8,5,10,1,7,null,12]
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= preorder.length <= 100 1 <= preorder[i] <= 10^8 The values of preorder
	 * are distinct.
	 * 
	 */

	int index = 0;

	public TreeNode bstFromPreorder(int[] preorder) {

		return bstFromPreorderHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	TreeNode bstFromPreorderHelper(int[] preorder, int min, int max) {

		if (index >= preorder.length)
			return null;
		TreeNode treeNode = null;
		int key = preorder[index];

		if (key > min && key < max) {
			treeNode = new TreeNode(key);
			index++;
			treeNode.left = bstFromPreorderHelper(preorder, min, key);
			treeNode.right = bstFromPreorderHelper(preorder, key, max);
		}

		return treeNode;
	}
}
