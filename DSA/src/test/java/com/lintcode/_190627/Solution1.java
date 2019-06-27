package com.lintcode._190627;

import java.util.Arrays;

public class Solution1 {
    
    public String largestNumber(int[] nums) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<nums.length;i++){
    		sb.append(nums[i]);
    	}
		String result = sb.toString();
		System.err.println(result);
		char[] arr = new char[result.length()];
		for(int i=0;i<arr.length;i++){
    		arr[i] = result.charAt(i);
    	}
    	System.err.println(Arrays.toString(arr));
    	mergeSort(arr, 0, arr.length - 1);
    	StringBuilder temp = new StringBuilder();
    	for(int i=0;i<arr.length;i++){
    		temp.append(arr[i]);
    	}
		return temp.toString();
    }
    
    public void mergeSort(char[] arr,int b,int e){
    	if(e <= b) return;
    	int m = (b + e) >> 1;
    	mergeSort(arr, b, m);
    	mergeSort(arr, m + 1, e);
    	char[] copy = new char[e - b + 1];
    	for(int i=0;i<copy.length;i++){
    		copy[i] = arr[i + b];
    	}
    	//以下是copy数组的变量
    	int bb = 0;
    	int ee = copy.length - 1;
    	int mm = (bb + ee) >> 1;
    	int i = bb;
    	int j = mm + 1;
    	int f = b;
    	while(i <= mm || j <= ee){
    		if(ee < j){
    			arr[f++] = copy[i++];
    		}else if(mm < i){
    			arr[f++] = copy[j++];
    		}else if(copy[i] > copy[j]){
       			arr[f++] = copy[i++];
    		}else {
       			arr[f++] = copy[j++];
			}
    	}
    }
}