package com.lintcode._190708;

import java.util.Arrays;
import java.util.Stack;

// https://www.jianshu.com/p/bb123944d3e5
// N皇后问题
public class Solution {
	
	public static void main(String[] args) {
		new Solution().solveNQueens(8);
	}

    public void solveNQueens(int n) {
    	int[][] arr = new int[n][n];
    	Stack<Node> stack = new Stack<>();
    	int j = 0;
    	boolean jF = true;
    	for(int i=0;i<n;i++){
    		boolean putSuccess = false;
    		if(jF) j = 0;
    		for(;j<n;j++){
    			if(judgeSuccessIfPut(arr, i, j)){
        			stack.push(new Node(i, j));
        			putSuccess = true;
        			arr[i][j] = 1;
        			jF = true;
        			break;
        		}
    		}
    		if(!putSuccess){//表明当前路径错误，需要回溯
    			if(stack.isEmpty()){
    				System.err.println("山穷水尽");
    				return;
    			}
    			Node lifeNode = stack.pop();
    			arr[lifeNode.x][lifeNode.y] = 0;
    			i = lifeNode.x - 1;//后面回加-，所以这里提前减-
    			j = lifeNode.y + 1;
    			jF = false;
    		}
    	}
    	print(arr);
    }
    
    // 计算当前节点是否可以放置
    public boolean judgeSuccessIfPut(int[][] arr, int x, int y){
    	int n = arr.length;
		for(int i=0;i<n;i++){//判断列是否有值
    		if(arr[i][y] == 1){
    			return false;
    		}
    	}
    	for(int j=0;j<arr[x].length;j++){//判断行是否有值
    		if(arr[x][j] == 1){
    			return false;
    		}
    	}
    	//检查左上到右下斜线
    	int min = x < y ? x : y;
    	int xx = x - min;
    	int yy = y - min;
    	while(xx < n && yy < n){
    		if(arr[xx][yy] == 1){
    			return false;
    		}
    		yy++;
    		xx++;
    	}
    	//检查右上到左下斜线
    	xx = x;
    	yy = y;
    	while(0 <= xx && yy < n){
    		if(arr[xx][yy] == 1){
    			return false;
    		}
    		yy++;
    		xx--;
    	}
    	xx = x;
    	yy = y;
    	while(0 <= yy && xx < n){
    		if(arr[xx][yy] == 1){
    			return false;
    		}
    		xx++;
    		yy--;
    	}
		return true;
    }
    
    public void print(int[][] arr){
    	for(int i=0;i<arr.length;i++){
    		System.out.println(Arrays.toString(arr[i]));
    	}
    }
}