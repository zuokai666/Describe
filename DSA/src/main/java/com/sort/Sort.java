package com.sort;

public class Sort {
	
	public static void check(int[] arr){
		boolean asc = true;
		boolean desc = true;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i+1] < arr[i]){
				asc = false;
			}
		}
		for(int i=0;i<arr.length-1;i++){
			if(arr[i+1] > arr[i]){
				desc = false;
			}
		}
		if(asc || desc){
			System.out.println("排序成功");
			return;
		}
		throw new RuntimeException("排序失败");
	}
}