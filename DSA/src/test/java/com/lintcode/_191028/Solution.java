package com.lintcode._191028;

public class Solution {
	
	public static void main(String[] args) {
		new Solution().reachNumber(2);
	}
	
	public int reachNumber(int target) {
		int tar = Math.abs(target);
		int step = 1;
		int pos = 0;
		while(pos < tar){
			pos = pos + step;
			step++;
		}
		step--;
		if(pos == tar){
			return step;
		}
		pos = pos - tar;
		if(pos % 2 == 0){
			return step;
		}else if((step + 1) % 2 == 1){
			return step + 1;
		}else {
			return step + 2;
		}
    }
}