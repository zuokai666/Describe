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
		if(asc){
			System.out.println("升序成功");
			return;
		}
		if(desc){
			System.out.println("降序成功");
			return;
		}
		throw new RuntimeException("排序失败");
	}
}