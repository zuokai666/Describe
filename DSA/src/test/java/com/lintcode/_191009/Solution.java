package com.lintcode._191009;

//75. 寻找峰值
public class Solution {

	public static void main(String[] args) {
		int[] arr = {1, 2, 1, 3, 4, 5, 7, 6};
		new Solution().findPeak(arr);
	}
	
	//返回峰顶元素的下标
	public int findPeak(int[] arr) {
		if(arr == null || arr.length < 3){
			return -1;
		}
		return findPeakInternal(arr, 0, arr.length - 1);
    }
	
	//1, 2, 1, 3, 4, 5, 7, 6
	public int findPeakInternal(int[] arr, int begin, int end) {
		if(end <= begin){
			return -1;
		}
		int middle = (begin + end) >> 1;
		if(arr[middle - 1] < arr[middle] && arr[middle] > arr[middle + 1]){//正好是波峰
			return middle;
		}else if(arr[middle - 1] > arr[middle]){//下降趋势
			return findPeakInternal(arr, begin, middle);
		}else {//上升趋势
			return findPeakInternal(arr, middle, end);
		}
    }
}