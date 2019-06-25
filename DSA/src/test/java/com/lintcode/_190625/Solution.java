package com.lintcode._190625;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		String[] s1 = {"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"};
		int k = 3;
		System.err.println(Arrays.toString(new Solution().topKFrequentWords(s1, k)));
	}
	
	
    public String[] topKFrequentWords(String[] words, int k) {
    	HashMap<String, Integer> map = new HashMap<>();
    	for(int i=0;i<words.length;i++){//space:O(n);time:O(n)
    		int oldV = map.getOrDefault(words[i], 0);
    		map.put(words[i], oldV + 1);
    	}
    	PriorityQueue<String> heap = new PriorityQueue<>(k, new Comparator<String>() {
    		
			@Override
			public int compare(String o1, String o2) {
				int s1 = map.get(o1);
				int s2 = map.get(o2);
				if(s1 > s2){
					return -1;
				}else if(s1 == s2){
					return o1.compareTo(o2);
				}else {
					return 1;
				}
			}
		});
    	for(String key:map.keySet()){//space:O(n);time:O(nlogn)
    		heap.add(key);
    	}
    	System.out.println(heap);
    	String[] reStrings = new String[k];
    	for(int i=0;i<k;i++){////space:O(k);time:O(klogn)
    		reStrings[i] = heap.poll();
    	}
		return reStrings;
    }
}