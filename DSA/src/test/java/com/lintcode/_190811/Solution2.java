package com.lintcode._190811;

import com.lintcode._190705.ListNode;

public class Solution2 {

	public ListNode insertNode(ListNode head, int val) {
		ListNode newNode = new ListNode(val);
		ListNode hHead = new ListNode(val - 1);
		hHead.next = head;
		ListNode temp = hHead;
		ListNode lastTemp = temp;
		while(temp != null){
			if(val <= temp.val){
				newNode.next = temp;
				lastTemp.next = newNode;
				break;
			}
			lastTemp = temp;
			temp = temp.next;
		}
		if(temp == null){//最后一个了
			lastTemp.next = newNode;
		}
		return hHead.next;
    }
}