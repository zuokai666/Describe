package com.lintcode._190719;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {2,0,0,1,2,0,2};
		new Solution().sortColors(arr);
	}

	// 给定一个包含红，白，蓝且长度为 n 的数组，将数组元素进行分类使相同颜色的元素相邻，并按照红、白、蓝的顺序进行排序。我们可以使用整数 0，1 和
	// 2 分别代表红，白，蓝。
	// 一个仅使用常数级额外空间复杂度且只扫描遍历一遍数组的算法
	// left 指向第一个非0的数，right 指向倒数第一个非 2 的数，i 指向0时与 nums[l] 交换，指向 2 时与 nums[r]
	// 交换，指向 1 则继续向后指。
	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int i = left;
		while(i <= right){
			while(i == left && nums[i] == 0){
				i++;
				left++;
			}
			while(nums[right] == 2){
				right--;
			}
			if(nums[i] == 0){
				swap(nums, i, left);
				left++;
			}else if (nums[i] == 2) {
				swap(nums, i, right);
				right--;
			}else {
				i++;
			}
		}
	}
	
	private void swap(int[] nums,int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}