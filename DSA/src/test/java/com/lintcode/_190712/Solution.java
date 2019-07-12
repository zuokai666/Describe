package com.lintcode._190712;

import com.lintcode._190705.ListNode;

/**
 * 113. 删除排序链表中的重复数字 II
 * 
 * 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。
 * 
 * 输入 : 1->2->3->3->4->4->5->null
 * 输出 : 1->2->5->null
 * 
 * @author King
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);
		
		n6.next = n7;
		n5.next = n6;
		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;
		new Solution().deleteDuplicates(n1);
	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode vHead = new ListNode(-1);
    	ListNode node = vHead;
    	ListNode t = head;
    	boolean repeatable = false;
    	while(t != null){
    		if(t.next != null){
    			if(t.val != t.next.val){//非重复元素
    				if(repeatable){
    					repeatable = false;
    				}else {
    					node.next = t;
        				node = node.next;
					}
    			}else {//重复元素
    				repeatable = true;
    				node.next = null;
				}
    		}else {//当前元素是最后一个
    			if(repeatable){
    				node.next = null;
				}else {
					node.next = t;
				}
			}
    		t = t.next;
    	}
		return vHead.next;
    }
}