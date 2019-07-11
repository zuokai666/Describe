package com.lintcode._190711;

import java.util.ArrayList;
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

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n11 = new ListNode(4);
		n1.next = n11;
		
		ListNode n2 = null;
		ListNode n3 = new ListNode(-1);
		ArrayList<ListNode> arrayList = new ArrayList<>(3);
		arrayList.add(n1);
		arrayList.add(n2);
		arrayList.add(n3);
		
		new Solution().mergeKLists(arrayList);
	}
	
	int size = 0;

	public ListNode mergeKLists(List<ListNode> lists) {
		int k = lists.size();
		ListNode[] minHeap = new ListNode[k];
		firstKInHeap(minHeap, lists);
		ListNode head = null;
		ListNode node = null;
		while (minHeap[0] != null) {
			if (head == null) {
				head = new ListNode(minHeap[0].val);
				node = head;
			} else {
				node.next = new ListNode(minHeap[0].val);
				node = node.next;
			}
			if (minHeap[0].next == null) {
				minHeap[0] = minHeap[size - 1];// 直接让后面的节点顶替它
				minHeap[size - 1] = null;
				size--;// 数量减一
				siftDown(minHeap, 0);// 顶替的节点下滤
			} else {
				minHeap[0] = minHeap[0].next;// 直接让后面的节点顶替它
				siftDown(minHeap, 0);// 顶替的节点下滤
			}
		}
		return head;
	}

	// 将K个头元素入堆，并且保证堆化，保证null元素都在最后面
	private void firstKInHeap(ListNode[] minHeap, List<ListNode> lists) {
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				minHeap[size++] = lists.get(i);
			}
		}
		heapify(minHeap);
	}

	// 堆化有两种，自上而下自左而右的上滤，复杂度是深度和；另一种是自下而上自右而左的下滤，复杂度是高度和，高度和<深度和，所以选择下滤
	private void heapify(ListNode[] minHeap) {
		int i = (size - 1 - 1) >> 1;// 最后一个需要下滤的节点
		for (; 0 <= i; i--) {
			siftDown(minHeap, i);
		}
	}

	// 下滤
	private void siftDown(ListNode[] minHeap, int i) {
		int a = i;
		while (a * 2 + 1 < size) {// 存在左节点
			int minChild = a * 2 + 1;
			if ((a * 2 + 2 < size) && (minHeap[a * 2 + 1].val > minHeap[a * 2 + 2].val)) {
				minChild = a * 2 + 2;
			}
			if (minHeap[a].val > minHeap[minChild].val) {
				ListNode temp = minHeap[a];
				minHeap[a] = minHeap[minChild];
				minHeap[minChild] = temp;
				a = minChild;
			} else {
				break;
			}
		}
	}
}