package com.lintcode._190811;

public class Solution1 {

	public String depress(int m, int k, int[] arr) {
		int sum = 0;
		for(int i=0;i<k;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j] < arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			sum = sum + arr[arr.length - i - 1];
		}
		return sum>=m ? "no" : "yes";
    }
}