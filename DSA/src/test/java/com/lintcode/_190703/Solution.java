package com.lintcode._190703;

import java.util.LinkedList;

import com.lintcode._190702.TreeNode;

public class Solution {

    public boolean isComplete(TreeNode root) {
    	boolean result = true;
    	LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	// 用于标记当前元素是否为空，若为空，则后面元素若有一个不为空则表明不是完全二叉树
    	boolean nullFlag = false;
    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		if(node != null){
    			if(nullFlag){
    				return false;
    			}
    			queue.add(node.left);
    			queue.add(node.right);
    		}else {
    			nullFlag = true;
			}
    	}
		return result;
    }
    
    public boolean isSymmetric(TreeNode root) {
		return false;
    }
}