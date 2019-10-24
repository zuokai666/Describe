package com.lintcode._191018;

import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
//		int[] push = {1, 2, 3};
//		int[] pop = {3, 2, 1};
		
//		int[] push = {1, 2, 3};
//		int[] pop = {3, 1, 2};
		
//		int[] push = {1, 2, 3};
//		int[] pop = {1, 2, 3};
		
//		int[] push = {1, 2, 3};
//		int[] pop = {1, 3, 2};
		
		//add
		
//		int[] push = {1, 2, 3, 4};
//		int[] pop = {3, 2, 1, 4};
		
		int[] push = {1, 2, 3, 4};
		int[] pop = {1, 2, 4, 3};
		System.out.println(new Solution().isLegalSeq(push, pop));
	}
	
	//push = [1, 2, 3], pop = [3, 2, 1]
	public boolean isLegalSeq(int[] push, int[] pop) {
		Stack<Integer> stack = new Stack<Integer>();
		int j = 0;//pop数组的哨兵
		for(int i=0;i<push.length;i++){
			stack.push(push[i]);
			if(pop[j] == push[i]){//这个值需要弹出
				int a = i;//i的副本
				while(j < pop.length && 0 <= a && !stack.isEmpty()){
					if(pop[j] == push[a]){
						//正常
					}else {
						return false;
					}
					stack.pop();
					j++;
					a--;
				}
			}
		}
		return true;
    }
}