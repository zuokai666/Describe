package com.lintcode._190711;

import java.util.List;

import com.lintcode._190705.ListNode;

/**
 * 104. 合并k个排序链表
 * 
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度
 * 
 * @author King
 *
 */
public class Solution {

	public ListNode mergeKLists(List<ListNode> lists) {
		int k = lists.size();
		
		firstKInHeap(minHeap, lists);
		
		return null;
	}

	// 将K个头元素入堆，并且保证堆化
	private void firstKInHeap(ListNode[] minHeap, List<ListNode> lists) {
		for (int i = 0; i < lists.size(); i++) {
			minHeap[i] = lists.get(i);
		}
		
	}
	
	
}