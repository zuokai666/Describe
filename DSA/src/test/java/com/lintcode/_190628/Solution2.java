package com.lintcode._190628;

public class Solution2 {
    
    public boolean isLegalIdentifier(String str) {
    	if(str == null || str.isEmpty()) return false;
    	for(int i=0;i<str.length();i++){
    		char v = str.charAt(i);
    		if(i == 0){
    			if(!isNumber(v)){
    				return false;
    			}
    		}else {
    			if(!isCase(v)){
    				return false;
    			}
			}
    	}
    	return true;
    }
    
    private boolean isNumber(char v){
    	if('0' <= v && v <= '9'){
    		return true;
    	}else {
			return false;
		}
    }
    
    private boolean isCase(char v){
    	if('a' <= v && v <= 'z'){
    		return true;
    	}else if('A' <= v && v <= 'Z'){
    		return true;
		}else if('_' == v){
			return true;
		}else {
			return false;
		}
    }
}