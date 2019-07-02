package com.lintcode._190702;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
	
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return null;
		List<Integer> result = new ArrayList<>(20);
		Stack<TreeNode> stack = new Stack<>();
		while(root != null){
			stack.push(root);
			root = root.left;
		}
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			result.add(node.val);
			if(node.right != null){
				node = node.right;
				while(node != null){
					stack.push(node);
					node = node.left;
				}
			}
		}
		return result;
    }
}