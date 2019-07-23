package com.lintcode._190723;

import java.util.ArrayList;
import java.util.List;

import com.lintcode._190702.TreeNode;

/**
 * 11. 二叉查找树中搜索区间
 * 
 * 给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值。
 * 
 * @author King
 * 
 */
public class Solution {
	
	//迭代版中序遍历-左根右
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
    	List<Integer> result = new ArrayList<>();
    	midLook(root, result, k1, k2);
		return result;
    }
    
    public void midLook(TreeNode node, List<Integer> result, int k1, int k2) {
    	if(node == null){
    		return;
    	}
    	if(node.val < k1){
    		midLook(node.right, result, k1, k2);//看柚子树
    	}else if(k1 <= node.val && node.val <= k2){
    		midLook(node.left, result, k1, k2);
    		result.add(node.val);
        	midLook(node.right, result, k1, k2);
    	}else if (k2 < node.val) {
    		midLook(node.left, result, k1, k2);//看左子树
		}
    }
}