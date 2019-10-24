package com.lintcode._191021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lintcode._190702.TreeNode;
import com.lintcode._190705.ListNode;

public class Solution {
	
	public List<ListNode> binaryTreeToLists(TreeNode root) {
		List<ListNode> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		ListNode dummy = new ListNode(0);//标记-1
		ListNode lastNode = null;
		while(!queue.isEmpty()){
			dummy.next = null;
			lastNode = dummy;
			int size = queue.size();//重点：size不变，就是这一层的所有节点个数，就算后续有新节点，也不会读出来
			for(int i=0;i<size;i++){
				TreeNode head = queue.poll();
				lastNode.next = new ListNode(head.val);
				lastNode = lastNode.next;
				if(head.left != null){
					queue.offer(head.left);
				}
				if(head.right != null){
					queue.offer(head.right);
				}
			}
			result.add(dummy.next);
		}
		return result;
    }
}