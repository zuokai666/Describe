package com.lintcode._190709;

import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<>();
		stk.push(2);
		stk.push(6);
		stk.push(1);
		new Solution().stackSorting(stk);
	}
	
	public void stackSorting(Stack<Integer> stk) {
		int size = stk.size();
		if (size == 0 || size == 1) {
			return;
		}
		Stack<Integer> support = new Stack<>();
		// 第一个肯定有序，最大，略过
		// 开始第二个
		int n = 1;// 主栈取出元素个数
		while (n < size) {
			for (int i = 0; i < n; i++) {
				support.push(stk.pop());
			}
			Integer temp = stk.pop();// 这里是需要比较的元素
			// 开始放入主栈
			while (!support.isEmpty()) {
				if (temp != null && support.peek().compareTo(temp) > 0) {
					stk.push(temp);
					temp = null;// 标志比较元素已入栈
				} else {
					stk.push(support.pop());
				}
			}
			if(temp != null){
				stk.push(temp);
				temp = null;// 标志比较元素已入栈
			}
			n++;
		}
	}
}