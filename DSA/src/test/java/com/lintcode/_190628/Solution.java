package com.lintcode._190628;

public class Solution {
    /**
     * @param nums: 
     * @param sub: 
     * @return: return a Integer array
     */
    public int[] SimpleQueries(int[] nums, int[] sub) {
        int[] result = new int[sub.length];
        if(nums == null || nums.length == 0){
            return result;
        }
        mergeSort(nums, 0, nums.length - 1);
        for(int i=0;i<sub.length;i++){
        	if(sub[i] < nums[0]){//比最小还小
        		result[i] = 0;
        	}else if(nums[nums.length - 1] < sub[i]){//比最大的还大
        		result[i] = nums.length;
        	}else {
				int index = binarySearch(sub[i], nums);
        		result[i] = index + 1;
			}
        }
        return result;
    }
    
    private int binarySearch(int k,int[] arr){
		return binarySearchInternal(k, arr, 0, arr.length - 1);
    }
    
    private int binarySearchInternal(int k,int[] arr,int b,int e){
    	if(e < b) return -1;
    	int m = (b + e) >> 1;
    	if(arr[m] == k){
    		if(m + 1 < arr.length && arr[m + 1] == k){
    			return binarySearchInternal(k, arr, m + 1, e);
    		}else {
    			return m;//命中元素最右侧的索引
			}
    	}else if(arr[m] < k){
    		if(m + 1 < arr.length && k < arr[m + 1]){
    			return m;
    		}else {
        		return binarySearchInternal(k, arr, m + 1, e);
			}
    	}else {
    		return binarySearchInternal(k, arr, b, m - 1);
		}
    }
    
    private void mergeSort(int[] arr,int b,int e){
    	if(e <= b) return;
    	int m = (b + e) >> 1;
    	mergeSort(arr, b, m);
    	mergeSort(arr, m + 1, e);
    	int[] copy = new int[e - b + 1];
    	for(int i=0;i<copy.length;i++){
    		copy[i] = arr[i + b];
    	}
    	// 以下是copy数组的变量
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
    		}else if(copy[i] <= copy[j]){
       			arr[f++] = copy[i++];
    		}else {
       			arr[f++] = copy[j++];
			}
    	}
    }
}