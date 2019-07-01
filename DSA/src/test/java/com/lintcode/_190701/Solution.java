package com.lintcode._190701;

public class Solution {
	
    public String stringSort(String str) {
    	int[] bucket = new int[26];
    	for(int i=0;i<str.length();i++){
    		char v = str.charAt(i);
    		bucket[v - 'a']++;
    	}
    	Pair[] pairs = new Pair[26];
    	int pairsSize = 0;
    	for(int i=0;i<bucket.length;i++){
    		if(bucket[i] != 0){
    			pairs[pairsSize++] = new Pair((char) (i + 'a'), bucket[i]);
    		}
    	}
    	mergeSort(pairs, 0, pairsSize - 1);
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<pairsSize;i++){
    		for(int j=0;j<pairs[i].count;j++){
    			sb.append(pairs[i].v);
    		}
    	}
    	return sb.toString();
    }
    
    private void mergeSort(Pair[] arr,int b,int e){
    	if(e <= b) return;
    	int m = (b + e) >> 1;
    	mergeSort(arr, b, m);
    	mergeSort(arr, m + 1, e);
    	Pair[] copy = new Pair[e - b + 1];
    	for(int i=0;i<copy.length;i++){
    		copy[i] = arr[i + b];
    	}
    	// 以下是copy[]的变量
    	int bb = 0;
    	int ee = copy.length - 1;
    	int mm = (bb + ee) >> 1;
    	int f = b;
    	int i = bb;
    	int j = mm + 1;
    	while(i <= mm || j <= ee){
    		if(ee < j){
    			arr[f++] = copy[i++];
    		}else if(mm < i){
    			arr[f++] = copy[j++];
    		}else if(copy[i].compareTo(copy[j]) > 0){
    			arr[f++] = copy[i++];
    		}else {
    			arr[f++] = copy[j++];
			}
    	}
    }
    
    class Pair implements Comparable<Pair>{
    	
    	char v;
    	int count;
    	
    	public Pair(char v,int count){
    		this.v = v;
    		this.count = count;
    	}
    	
		@Override
		public int compareTo(Pair o) {
			if(count > o.count){
				return 1;
			}else if(count == o.count){
				return o.v - v;
			}else {
				return -1;
			}
		}
    }
}