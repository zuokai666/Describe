package com.lintcode._190712;

public class Solution1 {

	public static void main(String[] args) {
		int[] prices = { 2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8 };
		System.err.println(new Solution1().maxProfit1(prices));
		System.err.println(new Solution1().maxProfit(prices));
	}

	// 后面部分最大值-前面部分最小值
	public int maxProfit(int[] prices) {
		if(prices.length == 0){
			return 0;
		}
		int max = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] < min){
				min = prices[i];
			}else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}
	
	// 时间复杂度O(n^2)忽略了后面部分最大值-前面部分最小值
	public int maxProfit1(int[] prices) {
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			for (int j = 0; j < i; j++) {
				int p = prices[i] - prices[j];
				System.err.println(prices[i] + " - " + prices[j]);
				if (p > max) {
					max = p;
				}
			}
		}
		return max;
	}
}