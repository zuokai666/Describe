package com.lintcode._190710;

import com.lintcode._190702.TreeNode;

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
    	try {
    		int[] arr = { Integer.MIN_VALUE };
			middleQuery(arr, root);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
	private void middleQuery(int[] arr, TreeNode root){
    	if(root == null) return;
    	middleQuery(arr, root.left);
    	if(arr[0] != Integer.MIN_VALUE && arr[0] >= root.val){
    		throw new RuntimeException();
    	}
    	arr[0] = root.val;
    	middleQuery(arr, root.right);
    }
}