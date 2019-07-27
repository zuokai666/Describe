package com.lintcode._190724;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	// 给定一个数字列表，返回其所有可能的排列
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> rList = new ArrayList<>();
		for(int i=0;i<nums.length;i++){
			int gap = i + 1;
			if(gap == 1){
				List<Integer> sList = new ArrayList<>();
				sList.add(nums[i]);
				rList.add(sList);
			}else {
				List<List<Integer>> cList = new ArrayList<>();
				for(int j=0;j<rList.size();j++){
					List<Integer> nList = rList.get(j);//上一次元素
					for(int y=0;y<gap;y++){//新数插入位置
						@SuppressWarnings("unused")
						List<Integer> newList = new ArrayList<>();
						for(int x=0;x<nList.size();x++){
							
						}
					}
				}
				rList = cList;
			}
		}
		return rList;
	}
}