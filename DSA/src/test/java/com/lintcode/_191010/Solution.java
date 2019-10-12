package com.lintcode._191010;

public class Solution {
	
	public static void main(String[] args) {
		int[] cost = {1,2,3,5};
		int[] val = {4,6,10};
		System.out.println(new Solution().doingHomework(cost, val));
	}
	
	public long doingHomework(int[] cost, int[] val) {
		long result = 0;
		int vI = 0;
		int sum = 0;
		for(int i=0;i<cost.length;){
			if(sum + cost[i] <= val[vI]){
				sum = sum + cost[i];
				i++;
			}else {
				result = result + sum;
				vI++;
				if(val.length <= vI){
					break;
				}
			}
		}
		return result;
    }
}