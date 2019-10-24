package com.lintcode._191023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lintcode._190702.TreeNode;

public class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return null;
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> tempResult = new ArrayList<>();
			for(int i=0;i<size;i++){
				TreeNode node = queue.poll();
				if(node != null){
					tempResult.add(node.val);
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
			if(!tempResult.isEmpty()){
				result.add(tempResult);
			}
		}
		return result;
    }
}