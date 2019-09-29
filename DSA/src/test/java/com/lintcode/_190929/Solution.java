package com.lintcode._190929;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int[] numbers = {-1 ,0 ,1 ,2 ,-1 ,-4};
		new Solution().threeSum(numbers);
	}
	
	public List<List<Integer>> threeSum(int[] numbers) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numbers == null || numbers.length < 3){
			return result;
		}
		Arrays.sort(numbers);
		for(int i=0;i<numbers.length-2;i++){
			if(i>=1&&numbers[i]==numbers[i-1]){
				continue;
			}
			int j=i+1;
			int k=numbers.length-1;
			while(j < k){
				if(numbers[i]+numbers[j]+numbers[k]==0){
					result.add(Arrays.asList(numbers[i],numbers[j],numbers[k]));
					j++;
					k--;
					while(j<k&&numbers[j]==numbers[j-1]){
						j++;
					}
					while(j<k&&numbers[k]==numbers[k+1]){
						k--;
					}
				}else if(numbers[i]+numbers[j]+numbers[k]>0){
					k--;
				}else {
					j++;
				}
			}
		}
		return result;
    }
}