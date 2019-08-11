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
    	int x = 0;
    	for(int i=0;i<nums.length;i++){
    		if(set.contains(nums[i])){
    			
    		}else {
    			if(x != i){
    				int temp = nums[i];
        			nums[i] = nums[x];
        			nums[x] = temp;
    			}
    			set.add(nums[x]);
    			x++;
			}
    	}
		return x;
    }
}