package com.lintcode._190927;

public class Solution {

	public static void main(String[] args) {
		int[] nums = {1,3,4,2};
		new Solution().kthLargestElement(1, nums);
	}

	public int kthLargestElement(int n, int[] nums) {
		if(n < 1 || nums.length < n){
			return -1;
		}
		return getKthLargestElementByQuickSort(n, nums, 0, nums.length - 1);
    }
	
	private int getKthLargestElementByQuickSort(int k, int[] nums, int start, int end){
		int left = start;
		int right = end;
		int t = nums[left];//基准值pivot
		while(left < right){
			while(nums[right] < t && left < right){//从大到小
				right--;
			}
			if(left < right){
				nums[left++] = nums[right];
			}
			while(t < nums[left] && left < right){//从大到小
				left++;
			}
			if(left < right){
				nums[right--] = nums[left];
			}
		}
		nums[left] = t;
		int pos = left - start + 1;
		if(pos == k){
			return nums[left];
		}else if(pos < k){
			return getKthLargestElementByQuickSort(k, nums, start, left - 1);
		}else {
			return getKthLargestElementByQuickSort(k - pos, nums, left + 1, end);
		}
	}
}