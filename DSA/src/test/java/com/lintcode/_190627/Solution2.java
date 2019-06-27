package com.lintcode._190627;

/**
 * 184. 最大数
 * 
 * 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数
 * 
 * 
 * @author king
 * @date 2019-06-27 23:20:47
 * 
 */
public class Solution2 {
    
	public static void main(String[] args) {
		int[] nums = {25,5,12,97,3,8,79,73,38,88,98,29,84,74,16,2,67,65,41,44,88,75,51,87,95,90,45,40,7,53,5,30,77,5,56,58,41,51,62,88,33,69,81,78,18,63,82,90,21,6,12,92,67,6,81,83,14,6,76,85,79,96,41,44,20,89,59,58,83,58,73,1,41,41,24,55,61,49,10,42,5,1,98,30,91,9,34,5,84,43,73,4,22,11,21,14,1,62,77,41};
		String reString = new Solution2().largestNumber(nums);
		if(reString.equals("998989796959291909089888888887858484838382818179797877777767574737373696767666656362626159585858565555555535151494544444434241414141414140383433330302925242222121201816141412121111110")){
			System.err.println(true);
		}else {
			System.err.println(false);
		}
	}
	
    public String largestNumber(int[] nums) {
    	mergeSort(nums, 0, nums.length - 1);
    	StringBuilder temp = new StringBuilder();
    	for(int i=0;i<nums.length;i++){
    		temp.append(nums[i]);
    	}
		return temp.toString();
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
    		}else if(compare(copy[i], copy[j]) > 0){
       			arr[f++] = copy[i++];
    		}else {
       			arr[f++] = copy[j++];
			}
    	}
    }
    
    private int compare(int o1, int o2){
    	String s1 = Integer.toString(o1);
    	String s2 = Integer.toString(o2);
    	int len1 = s1.length();
    	int len2 = s2.length();
    	int max = len1 > len2 ? len1 : len2;
    	int i = 0;
    	int j = 0;
    	while(i < max && j < max){
    		char c1 = (i < len1) ? s1.charAt(i) : s1.charAt(i = 0);
    		char c2 = (j < len2) ? s2.charAt(j) : s2.charAt(j = 0);
    		if(c1 != c2){
    			return c1 - c2;
    		}
    		i++;
    		j++;
    	}
    	return len1 - len2;
    }
}