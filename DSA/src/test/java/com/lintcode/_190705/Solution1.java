package com.lintcode._190705;

public class Solution1 {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int index = 0;
		int changeSize = n - m;
		ListNode node = head;
		ListNode _head = head;
		ListNode pivot = null;
		while(node != null && changeSize != 0){
			index++;
			if(index < m){
				_head = node;
			}else if(index == m){
				pivot = node;
				ListNode pivot1 = node.next;
				ListNode pivot2 = pivot1.next;
				
				_head.next = pivot1;
				pivot1.next = pivot;
				node.next = pivot2;
				pivot = pivot1;
				changeSize--;
			}else {
				ListNode pivot1 = node.next;
				ListNode pivot2 = pivot1.next;
				
				_head.next = pivot1;
				pivot1.next = pivot;
				node.next = pivot2;
				pivot = pivot1;
				changeSize--;
			}
			node = node.next;
		}
		return head;
    }
}