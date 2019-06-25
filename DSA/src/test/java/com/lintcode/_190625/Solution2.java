package com.lintcode._190625;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 空间与时间的抉择
 * 
 * @author King
 *
 */
public class Solution2 {

	//空间复杂度O(n)，时间复杂度O(n)
    public boolean isUnique(String str) {
        HashSet<Integer> set = new HashSet<>(str.length());//可以避免数组扩容
        for(int i=0;i<str.length();i++){
        	int v = str.charAt(i);
        	if(set.contains(v)){
        		return false;
        	}else {
				set.add(v);
			}
        }
        return true;
    }
    
    //没有额外空间，时间复杂度O(n^2)
    public boolean isUnique1(String str) {
    	for(int i=0;i<str.length();i++){
        	for(int j=i+1;j<str.length();j++){
            	if(str.charAt(i) == str.charAt(j)){
            		return false;
            	}
            }
        }
        return true;
    }
    
    public char firstUniqChar(String str) {
    	HashMap<Character,Integer> set = new LinkedHashMap<>(str.length());
        for(int i=0;i<str.length();i++){
        	Character v = str.charAt(i);
            int vv = set.getOrDefault(v, 0);
            set.put(v, vv + 1);
        }
        Iterator<Entry<Character, Integer>> iter = set.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Character, Integer> entry = iter.next();
			Character key = entry.getKey();
			int time = entry.getValue();
			if(time == 1){
				return key;
			}
		}
        return 'Z';
    }
}