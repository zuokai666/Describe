package com.lintcode._190811;

import com.lintcode._190705.ListNode;

public class Solution3 {

	public ListNode middleNode(ListNode head) {
		int size = countNodes(head);
		int mid = size%2==0 ? size/2 : size/2 + 1;
		ListNode _head = head;
		while(_head != null){
			if(mid != 0){
				mid--;
				if(mid == 0){
					return _head;
				}
			}
			_head = _head.next;
		}
		return head;
    }
	
	public int countNodes(ListNode head) {
		int size = 0;
		ListNode _head = head;
		while(_head != null){
			size++;
			_head = _head.next;
		}
		return size;
    }
}