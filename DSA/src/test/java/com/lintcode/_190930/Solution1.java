package com.lintcode._190930;

public class Solution1 {

	public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int result = 0;
        for(int i=s.length()-1;i>=0;i--){
        	if(s.charAt(i) == ' '){
        		break;
        	}else {
				result++;
			}
        }
        return result;
    }
}