package com.lintcode._190710;

import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		char[] arr = {'a', 'B', 'c', 'D', 'e', 'F', 'g'};
		new Solution1().sortLetters(arr );
	}
	
    public void sortLetters(char[] arr) {
    	int i = 0;
    	int j = arr.length - 1;
    	while(i < j){
    		System.err.println(Arrays.toString(arr));
    		while((i < j) && little(arr[i])){
    			i++;
    		}
    		while((i < j) && big(arr[j])){
    			j--;
    		}
    		if(i < j){
    			char temp = arr[i];
    			arr[i] = arr[j];
    			arr[j] = temp;
    		}
    	}
    }
    
    private boolean little(char c){
    	if('a' <= c && c <= 'z'){
    		return true;
    	}else {
			return false;
		}
    }
    
    private boolean big(char c){
    	if('A' <= c && c <= 'Z'){
    		return true;
    	}else {
			return false;
		}
    }
}