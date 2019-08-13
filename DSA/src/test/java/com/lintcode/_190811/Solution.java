package com.lintcode._190811;

import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		System.err.println(10 >> 2 - 1);
	}
	
	public int getAns(int[] a) {
		int[] copy = new int[a.length];
		for(int i=0;i<copy.length;i++){
			copy[i] = a[i];
		}
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		int mid = a.length%2==0 ? a[a.length / 2 - 1] : a[a.length / 2];
		for(int i=0;i<copy.length;i++){
			if(mid == copy[i]){
				return i;
			}
		}
		return 0;
    }
	
	private void mergeSort(int[] arr, int b, int e){
		if(e <= b) return;
		int m = (b + e) >> 1;
		mergeSort(arr, b, m);
		mergeSort(arr, m + 1, e);
		int[] copy = new int[e - b + 1];
		for(int i=0;i<copy.length;i++){
			copy[i] = arr[b + i];
		}
		int bb = 0;
		int ee = copy.length - 1;
		int mm = (bb + ee) >> 1;
		int f = b;
		int i = bb;
		int j = mm + 1;
		while((i <= mm) || (j <= ee)){
			if(mm < i){
				arr[f++] = copy[j++];
			}else if(ee < j){
				arr[f++] = copy[i++];
			}else if(copy[i] > copy[j]){
				arr[f++] = copy[j++];
			}else {
				arr[f++] = copy[i++];
			}
		}
	}
}