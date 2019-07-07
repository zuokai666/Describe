package com.wrr.test;

//Weighted Round Robin:加权轮询调度算法
public class WRR_Test {
	
	public static void main(String[] args) {
		char[] servers = {'a','b','c'};
		int[] weighted = {5,1,1};
		generateSchedule(servers, weighted);
	}
	
	public static void generateSchedule(char[] servers,int[] weighted){
		int maxIndex = -1;
		while((maxIndex = findMaxIndex(weighted)) != -1){
			weighted[maxIndex]--;
			System.out.println(servers[maxIndex]);
		}
	}
	
	public static int findMaxIndex(int[] weighted){
		int result = 0;
		for(int i=1;i<weighted.length;i++){
			if(weighted[result] < weighted[i]){
				result = i;
			}
		}
		if(weighted[result] == 0){
			result = -1;//标志着一个轮询的结束
		}
		return result;
	}
}