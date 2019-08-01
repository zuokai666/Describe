package com.lintcode._190801;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {1,3,1,4,4,2};
		new Solution().deduplication(arr);
	}
	
    public int deduplication(int[] nums) {
    	if(nums.length == 0){
    		return 0;
    	}
    	Set<Integer> set = new HashSet<>();
    	int x = 1;//直接从第二个元素开始
    	set.add(nums[0]);
    	for(int i=1;i<nums.length;i++){
    		if(set.contains(nums[i])){
    			
    		}else {
    			int temp = nums[i];
    			nums[i] = nums[x];
    			nums[x] = temp;
    			x++;
    			set.add(nums[x]);
			}
    	}
		return x;
    }
}