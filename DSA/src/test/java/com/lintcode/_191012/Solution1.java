package com.lintcode._191012;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();//差值，索引+1
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++){
			int temp = target - nums[i];
			if(map.containsKey(temp)){
				result[0] = map.get(temp);
				result[1] = i + 1;
				break;
			}else {
				map.put(temp, i + 1);
			}
		}
		return result;
    }
}