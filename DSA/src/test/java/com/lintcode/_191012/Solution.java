package com.lintcode._191012;

import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		Stack<Integer> temp = new Stack<>();
		temp.push(4);
		temp.push(2);
		temp.push(1);
		temp.push(3);
		new Solution().stackSorting(temp);
	}
	
	public void stackSorting(Stack<Integer> stk) {
		if(stk == null || stk.size() <= 1){
			return;
		}
		Stack<Integer> temp = new Stack<>();
		int size = stk.size();//栈中的元素个数
		for(int i=0;i<stk.size();i++){//控制弹出临时栈的元素个数
			for(int j=i;j>0;j--){
				temp.push(stk.pop());//将排好序的元素弹出
			}
			int element = stk.pop();//弹出要比较的元素
			while(!temp.isEmpty()){//重新入栈
				Integer pop = temp.pop();
				if(element <= pop){
					stk.push(element);
				}
				stk.push(pop);
			}
			if(stk.size() != size){
				stk.push(element);
			}
		}
    }
}