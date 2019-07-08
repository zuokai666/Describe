package com.wrr.test;

import java.util.Arrays;

public class SWRR_Test {

	public static void main(String[] args) {
		char[] servers = {'a','b','c'};
		int[] initWeighted = {5,1,1};
		int[] weighted = {5,1,1};
		generateSchedule(servers, initWeighted, weighted);
	}
	
	public static void generateSchedule(char[] servers,int[] initWeighted,int[] weighted){
		int sumWeighted = 0;
		for(int i=0;i<weighted.length;i++){
			sumWeighted = sumWeighted + weighted[i];
		}
		int maxIndex = -1;
		while((maxIndex = findMaxIndex(weighted)) != -1){
			System.err.println(Arrays.toString(weighted));
			weighted[maxIndex] = weighted[maxIndex] - sumWeighted;
			add(initWeighted, weighted);
			System.out.println(servers[maxIndex]);
		}
	}
	
	public static void add(int[] initWeighted,int[] weighted){
		for(int i=0;i<weighted.length;i++){
			weighted[i] = weighted[i] + initWeighted[i];
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