package com.lintcode._191008;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2};
		new Solution().findMin(arr);
	}
	
	public int findMin(int[] nums) {
		if(nums == null || nums.length == 0){
			return -1;
		}
		return findMinInternal(nums, 0, nums.length - 1);
    }
	
	public int findMinInternal(int[] nums,int begin,int end) {
		int middle = (begin + end) >> 1;
		if(nums[middle] > nums[0]){
			return findMinInternal(nums, middle + 1, end);
		}else {
			return findMinInternal(nums, begin, middle - 1);
		}
	}
}