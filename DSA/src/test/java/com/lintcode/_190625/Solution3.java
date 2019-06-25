package com.lintcode._190625;

import java.util.PriorityQueue;

/**
 * 486. 合并k个排序数组
 * 
 * 将 k个有序数组合并为一个大的有序数组
 * 
 * @author King
 *
 */
public class Solution3 {
	
	public static void main(String[] args) {
		
	}
	
    public int[] mergekSortedArrays(int[][] arrays) {
    	if(arrays==null) return new int[0];
    	PriorityQueue<Element> heap = new PriorityQueue<>(arrays.length);
    	int total_size = 0;
    	for(int i=0;i<arrays.length;i++){
    		if(arrays[i].length > 0){
    			heap.offer(new Element(i, 0, arrays[i][0]));
    			total_size += arrays[i].length;
    		}
    	}
    	int[] result = new int[total_size];
    	int index = 0;
    	while(!heap.isEmpty()){
    		Element ele = heap.poll();
    		result[index++] = ele.val;
    		if(ele.col + 1 < arrays[ele.row].length){//这里判断是否达到一行的终点，如果是不需要添加节点了，可以直接poll
    			ele.col++;
    			ele.val = arrays[ele.row][ele.col];
    			heap.add(ele);
    		}
    	}
		return result;
    }
    
    /**
     * 这个是核心，存储关于节点的横纵坐标
     * 
     * @author King
     *
     */
    class Element implements Comparable<Element>{
    	
        public int row, col, val;
        
        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
        
    	@Override
    	public int compareTo(Element o) {
    		return this.val - o.val ;
    	}
    }
}