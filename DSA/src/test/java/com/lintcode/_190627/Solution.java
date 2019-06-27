package com.lintcode._190627;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {6,5,4,3,2,1,7,8,9,10};
//		new Solution().sort(arr, 0, arr.length - 1);
//		System.err.println(Arrays.toString(arr));
		int a = new Solution().kthLargestElement(3, arr);
		System.err.println(a);
	}
	
    public int kthLargestElement(int n, int[] arr) {
    	int pivotIndex = sort(arr, 0, arr.length - 1);
    	while(pivotIndex != -1){
    		if(pivotIndex + 1 == n){
        		return arr[pivotIndex];
        	}else if(pivotIndex + 1 < n){
        		pivotIndex = sort(arr, pivotIndex + 1, arr.length - 1);
        	}else {
        		pivotIndex = sort(arr, 0, pivotIndex - 1);
			}
    	}
		return -1;
    }
    
    public int sort(int[] arr,int i,int j){
    	if(j == i){
    		return i;
    	}else if(j < i){
    		return -1;
    	}
    	int b = i;
    	int e = j;
    	int pivot = arr[b];
    	while(b < e){
    		while((b < e) && (arr[e] <= pivot)){
    			e--;
    		}
    		while((b < e) && (pivot <= arr[b])){
    			b++;
    		}
    		if(b < e){
    			int temp = arr[b];
    			arr[b] = arr[e];
    			arr[e] = temp;
    		}
    	}
    	arr[i] = arr[b];
    	arr[b] = pivot;
    	System.err.println(Arrays.toString(arr));
    	return b;
    }
}