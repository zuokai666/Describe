package com.lintcode._190702;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：174ms
 * 空间：
 * 
 * 
 * @author King
 * 
 */
public class Solution {
	
	static int count = 0;
	
	public List<Integer> preorderTraversal(TreeNode root) {
		System.out.println(++count);
		List<Integer> result = new ArrayList<>(20);
		preorderTraversalInternal(root, result);
		return result;
	}
	
	private void preorderTraversalInternal(TreeNode root,List<Integer> result){
		if(root == null) return;
		result.add(root.val);
		preorderTraversalInternal(root.left, result);
		preorderTraversalInternal(root.right, result);
	}
}