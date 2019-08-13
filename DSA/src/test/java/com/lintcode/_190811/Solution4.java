package com.lintcode._190811;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lintcode._190705.ListNode;

public class Solution4 {
	
	public List<Integer> reverseStore(ListNode head) {
		List<Integer> result = new ArrayList<Integer>();
		ListNode _head = head;
		while(_head != null){
			result.add(_head.val);
			_head = _head.next;
		}
		Collections.reverse(result);
		return result;
    }
	
	public int countNodesII(ListNode head) {
		int result = 0;
		ListNode _head = head;
		while(_head != null){
			if(0 < _head.val && _head.val%2 == 1){
				result++;
			}
			_head = _head.next;
		}
		return result;
    }
}